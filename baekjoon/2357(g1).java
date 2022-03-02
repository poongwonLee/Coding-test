import java.util.*;

import java.io.*;

public class Main {

	static int N, M, K, S;
	static int arr[];
	static int treeMax[], treeMin[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (S = 1; S < N; S *= 2)
			;
		arr = new int[N + 1];
		treeMax = new int[S * 2];
		treeMin = new int[S * 2];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		initDU();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			queryDU(a, b);
		}
		System.out.println(sb);

	}

	static void queryDU(int left, int right) {
		left += S - 1;
		right += S - 1;
		int max = 0;
		int min = Integer.MAX_VALUE;
		while (left <= right) {
			if (left % 2 == 1) {
				max = Math.max(max, treeMax[left]);
				min = Math.min(min, treeMin[left++]);
			}
			if (right % 2 == 0) {
				max = Math.max(max, treeMax[right]);
				min = Math.min(min, treeMin[right--]);
			}
			left /= 2;
			right /= 2;
		}
		sb.append(min + " " + max + "\n");
	}

	static void initDU() {

		for (int i = S; i < S + N; i++) {
			treeMax[i] = arr[i - S + 1];
			treeMin[i] = arr[i - S + 1];
		}
		for (int i = S - 1; i >= 1; i--) {
			treeMax[i] = Math.max(treeMax[i * 2], treeMax[i * 2 + 1]);
			treeMin[i] = Math.min(treeMin[i * 2], treeMin[i * 2 + 1]);
		}
	}
}
