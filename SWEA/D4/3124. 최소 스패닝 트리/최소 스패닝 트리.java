import java.util.*;
import java.io.*;

class Solution {
	static int[] unf;

	static int find(int x) {
		if (unf[x] == x)
			return x;
		else
			return unf[x] = find(unf[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			unf[y] = x;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			sb.append("#").append(test).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			unf = new int[N + 1];
			for (int i = 1; i <= N; i++)
				unf[i] = i;

			long res = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
			while (M-- != 0) {
				st = new StringTokenizer(br.readLine());
				pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) });
			}
			
			while(!pq.isEmpty()) {
				int a=pq.peek()[0];
				int b=pq.peek()[1];
				int val=pq.peek()[2];
				pq.poll();
				if(find(a)==find(b))continue;
				union(a,b);
				res+=val;
			}
			sb.append(res);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}