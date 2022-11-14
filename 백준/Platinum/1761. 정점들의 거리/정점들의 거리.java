import java.util.*;

import java.io.*;

public class Main {
	static int N, K;
	static int logN=17;
	static ArrayList<Edge> list[];
	static long depth[], parentDist[][];
	static int parent[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		depth = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
		}
		

		parent = new int[logN + 1][N + 1];
		parentDist = new long[logN + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			st= new StringTokenizer(br.readLine());
			int u =Integer.parseInt(st.nextToken());
			int v =Integer.parseInt(st.nextToken());
			int val =Integer.parseInt(st.nextToken());
			
			list[u].add(new Edge(v, val));
			list[v].add(new Edge(u, val));
		}

		dfs(1,-1,0);
		
		 
		for (int i = 1; i <= logN; i++) {

			for (int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
				parentDist[i][j]= parentDist[i-1][parent[i-1][j]] + parentDist[i-1][j];
			}
		}

		K = Integer.parseInt(br.readLine());
		while (K-- != 0) {
			st= new StringTokenizer(br.readLine());
			LCA(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}

	}

	static void LCA(int a, int b) {

		if (depth[a] < depth[b]) { // a가 더 깊은걸로
			int tmp = a;
			a = b;
			b = tmp;
		}
		long sum=0;
		int i = 0;
		for (; i < logN; i++) {
			if ((depth[a] - depth[b] & (1 << i)) >= 1) {

				sum+=parentDist[i][a];
				a = parent[i][a];
				
			}
		}

		if (a == b) {
			System.out.println(sum);
			return;
		}

		for (i = logN; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				sum+=parentDist[i][a];
				sum+=parentDist[i][b];
				a = parent[i][a];
				b = parent[i][b];

			}
		}
		sum+=parentDist[0][a];
		sum+=parentDist[0][b];
		System.out.println(sum);
	}
	static void bfs() {
		Arrays.fill(depth, -1);
		Deque<Integer> q= new LinkedList<>();
		q.add(1);
		depth[1]=0;
		while(!q.isEmpty()) {
			int now= q.poll();
			for(int i=0;i<list[now].size();i++) {
				int next= list[now].get(i).v;
				int nextVal= list[now].get(i).val;
				if(depth[next]!=-1) {
					continue;
				}
				depth[next] = depth[now] + 1;
				parent[0][next] = now;
				parentDist[0][next] = nextVal;
				q.add(next);
			}
		}
	}

	static void dfs(int now, int par, int v) {
		for (int i = 0; i < list[now].size(); i++) {
			Edge next = list[now].get(i);
			if (next.v == par)
				continue;
			depth[next.v] = depth[now] + 1;
			parent[0][next.v] = now;
			parentDist[0][next.v] = next.val;
			dfs(next.v, now, v + 1);

		}
	}

	static class Edge {
		int v;
		int val;

		public Edge(int v, int val) {
			this.v = v;
			this.val = val;

		}
	}


}