
import java.util.*;
import java.io.*;

class Solution {

	static int[][] arr, copyArr;
	static int[] select, visit;
	static int N, M, K, min;
	static ArrayList<Integer> list = new ArrayList<>();

	static void dfs(int v, int cnt) {
//		if(min<v)return;

		
		if (cnt <= K &&cnt<min) {

			list.clear();
			for (int i = 0; i < N; i++) {
				if (visit[i] == 1) {
					list.add(i);
				}
			}
			select = new int[list.size()];
			dfs3(0, list.size());
//			System.out.println(Arrays.toString(visit));
		}
		if (v == N)
			return;
		visit[v] = 1;
		dfs(v + 1, cnt + 1);
		visit[v] = 0;
		dfs(v + 1, cnt);
	}

	static void dfs3(int v, int size) {
		if (v == size && min>size) {
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					arr[i][j] = copyArr[i][j];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < M; j++) {
					arr[list.get(i)][j] = select[i];
				}
			}

//			for (int[] is : arr) {
//				System.out.println(Arrays.toString(is));
//			}
			boolean flag = true;
			for (int j = 0; j < M; j++) {
				int cnt2 = 0;
				boolean flag2 = false;
				for (int i = 0; i < N - 1; i++) {
					if (arr[i][j] == arr[i + 1][j])
						cnt2++;
					else {

						cnt2 = 0;
					}
					if (cnt2 >= K - 1) {
						flag2 = true;
						break;
					}

				}
				if (!flag2) {
					flag = false;
					break;
				}
			}
			if (flag) {
				min = Math.min(min, size);
			}

			return;

		}
		if(v==size)return;
		select[v] = 1;
		dfs3(v + 1, size);
		select[v] = 0;
		dfs3(v + 1, size);

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			copyArr = new int[N][M];
			select = new int[N];
			visit = new int[N];
			for (int i = 0; i < N; i++)
				copyArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//			dfs(0, 0);
			dfs(0, 0);
//			System.out.println(min);
			sb.append("#").append(test_case).append(" ").append(min).append("\n");

		}
		System.out.println(sb);

	}

}
