import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int unf[], weight[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = rd.nextInt();
			M = rd.nextInt();
			if (N == 0 && M == 0) {
				System.out.println(sb);
				return;
			}
			unf = new int[N + 1];
			weight = new int[N + 1];
			for(int i=1;i<=N;i++) {
				unf[i]=i;
			}
			while (M-- != 0) {
				String op = rd.next();
				int a = rd.nextInt();
				int b = rd.nextInt();

				if (op.equals("!")) {
					int diff = rd.nextInt();
					union(a, b, diff);
					
				} else {
					if (find(a) == find(b)) {
						sb.append(weight[b] - weight[a] + "\n");
					} else {
						sb.append("UNKNOWN\n");
					}

				}
				
			}
			
		}
	}

	static int find(int a) {
		if (unf[a] == a) {
			return a;
		} else {
			int idx = find(unf[a]);
			weight[a] += weight[unf[a]];
			return unf[a] = idx;
		}
	}

	static void union(int a, int b, int diff) {
		int x = find(a);
		int y = find(b);
		if (x != y) {
			weight[y] = weight[a] - weight[b] + diff;
			unf[y] = unf[x];
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
