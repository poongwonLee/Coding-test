
import java.util.*;
import java.io.*;

class Solution {

	static int[][] arr, copyArr;
	static int[] select, visit;
	static int N, M, K, min;



	static void dfs(int v, int cnt) {
		if (v == N) {
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
					if (cnt2 >= K-1) {
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
				min = Math.min(min, cnt);
			}
			return;
		}
		dfs(v+1,cnt);
		for(int k=0;k<2;k++) {
			for(int j=0;j<M;j++)
				arr[v][j]=k;
			dfs(v+1,cnt+1);
		}
		for(int k=0;k<2;k++) {
			for(int j=0;j<M;j++)
				arr[v][j]=copyArr[v][j];
		}
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
			for(int i=0;i<N;i++)
				arr[i]=Arrays.copyOf(copyArr[i], M);
			dfs(0,0);
			sb.append("#").append(test_case).append(" ").append(min).append("\n");

		}
		System.out.println(sb);

	}

}
