import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	static int N, M, K;
	static HashMap<String, int[]> hm = new HashMap<>();
	static HashMap<String, int[]> hm2 = new HashMap<>();

	static Queue<int[]> q = new LinkedList<int[]>();

//	r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000)
//	로 이루어져 있다. (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. 
//	d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) ;
		M = Integer.parseInt(st.nextToken()) ;
		K = Integer.parseInt(st.nextToken());

		int r, c, s, d, z;
		while (K-- != 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			hm.put(r + " " + c, new int[] { s, d, z });
			q.add(new int[] { r, c, s, d, z });
		}
		int res = 0;
		for (int j = 1; j <= M; j++) {
			for (int i = 1; i <= N; i++) {
				int[] h = hm.get(i+" "+j);
				if (h != null) {
//					System.out.println(i + " " + j);
//					System.out.println(Arrays.toString(hm.get(i + " " + j)));
					
					res += h[2];
					hm.remove(i+" "+ j);
					break;
				}
			}
			int qSize = q.size();
//			System.out.println(qSize);
			hm2.putAll(hm);;
			hm.clear();
			while (qSize-- != 0) {
				
				r = q.peek()[0];
				c = q.peek()[1];
				s = q.peek()[2];
				d = q.peek()[3];
				z = q.peek()[4];
//				System.out.println(Arrays.toString(q.peek()));
				q.poll();
				int[] h2 = hm2.get(r+" "+c);
				if (h2==null||h2[2] != z) {
//					System.out.println(r+" "+c+" "+s+" "+z);
					continue;
				}
				hm2.remove(r + " " + c);

				if (d == 1) {
					int ns = N - r + s;
					int div = ns / (N - 1);
					int mod = ns % (N - 1);
					int nr = N;
					int nc = c;
					int nd = d;
					if (div != 0) {
						nr = div % 2 == 0 ? N : 1;
						nc = c;

						nd = div % 2 == 0 ? 2 : 1;
						if (mod > 0)
							nd = nd == 1 ? 2 : 1;
					}
					if (nd == 1)
						nr -= mod;
					else
						nr += mod;
					int[] h = hm.get(nr + " " + nc);
					if (h== null || h[2] < z) {
						hm.put(nr + " " + nc, new int[] { s, nd, z });
						q.add(new int[] { nr, nc, s, nd, z });
					}

				} else if (d == 2) {
					int ns = r + s - 1;
					int div = ns / (N - 1);
					int mod = ns % (N - 1);

					int nr = 1;
					int nc = c;
					int nd = d;
					if (div != 0) {
						nr = div % 2 != 0 ? N : 1;
						nc = c;

						nd = div % 2 != 0 ? 2 : 1;
						if (mod > 0)
							nd = nd == 1 ? 2 : 1;
					}
					if (nd == 1)
						nr -= mod;
					else
						nr += mod;

					int[] h = hm.get(nr + " " + nc);
					if (h== null || h[2] < z) {
						hm.put(nr + " " + nc, new int[] { s, nd, z });
						q.add(new int[] { nr, nc, s, nd, z });
					}

				} else if (d == 3) {
					int ns = c + s - 1;
					int div = ns / (M - 1);
					int mod = ns % (M - 1);

					int nr = r;
					int nc = 1;
					int nd = d;
					if (div != 0) {
						nr = r;
						nc = div % 2 != 0 ? M : 1;

						nd = div % 2 != 0 ? 3 : 4;
						if (mod > 0)
							nd = nd == 3 ? 4 : 3;
					}
					if (nd == 4)
						nc -= mod;
					else
						nc += mod;

					int[] h = hm.get(nr + " " + nc);
					if (h== null || h[2] < z) {
						hm.put(nr + " " + nc, new int[] { s, nd, z });
						q.add(new int[] { nr, nc, s, nd, z });
					}

				} else if (d == 4) {
					int ns = M - c + s;
					int div = ns / (M - 1);
					int mod = ns % (M - 1);

					int nr = r;
					int nc = M;
					int nd = d;
					if (div != 0) {
						nr = r;
						nc = div % 2 == 0 ? M : 1;

						nd = div % 2 == 0 ? 3 : 4;
						if (mod > 0)
							nd = nd == 3 ? 4 : 3;
					}
					if (nd == 4)
						nc -= mod;
					else
						nc += mod;

					int[] h = hm.get(nr + " " + nc);
					if (h== null || h[2] < z) {
						hm.put(nr + " " + nc, new int[] { s, nd, z });
						q.add(new int[] { nr, nc, s, nd, z });
					}
				}
				
			}
//			for (Entry<String, int[]> string : hm.entrySet()) {
//				System.out.println(string.getKey()+" "+Arrays.toString(string.getValue()));
//			}
			
		}
		System.out.println(res);

	}
}
