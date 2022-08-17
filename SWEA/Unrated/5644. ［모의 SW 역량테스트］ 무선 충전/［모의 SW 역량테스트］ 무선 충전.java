import java.util.*;
import java.awt.Point;
import java.io.*;
import java.lang.reflect.Array;

class Solution {
	static int[][] arr;
	static int M, A;
	static int[] dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };
	static int[] moveA, moveB, ansA, ansB;
	static AP[] APs;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int res = 0;

	static class AP {
		int c, p, x, y;

		public AP(String x, String y, String c, String p) {
			super();
			this.c = Integer.parseInt(c);
			this.p = Integer.parseInt(p);
			this.y = Integer.parseInt(x) - 1;
			this.x = Integer.parseInt(y) - 1;
		}

		@Override
		public String toString() {
			return "AP [c=" + c + ", p=" + p + ", x=" + x + ", y=" + y + "]";
		}

	}

	static void checkAP(int x, int y, int xx, int yy, int idx) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			if ((Math.abs(APs[i].x - x) + Math.abs(APs[i].y - y)) <= APs[i].c)
				a.add(i);
			if ((Math.abs(APs[i].x - xx) + Math.abs(APs[i].y - yy)) <= APs[i].c)
				b.add(i);
		}
		int max = 0;
		int idxa = 0;
		int idxb = 0;
		if (a.isEmpty() && b.isEmpty())
			return;
		
		if (!a.isEmpty() && !b.isEmpty()) {
			for (int i = 0; i < a.size(); i++) {
				int sum = 0;
				for (int j = 0; j < b.size(); j++) {
					if (a.get(i) == b.get(j)) {
						sum = APs[a.get(i)].p;
					} else {
						sum = APs[a.get(i)].p + APs[b.get(j)].p;
					}
					if (max < sum) {
						idxa = i;
						idxb = j;
						max = sum;
					}
				}
			}
		} else if (!a.isEmpty()) {
			for (int i = 0; i < a.size(); i++)
				max = Math.max(max, APs[a.get(i)].p);

		} else if(!b.isEmpty()) {
			
			for (int i = 0; i < b.size(); i++)
				max = Math.max(max, APs[b.get(i)].p);
		}
		res += max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			res=0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M];
			moveB = new int[M];
			ansA = new int[M + 1];
			ansB = new int[M + 1];

			APs = new AP[A];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				moveA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				moveB[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				APs[i] = new AP(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
			}
			arr = new int[10][10];

			int x = 0, y = 0;
			int xx = 9, yy = 9;
			checkAP(x, y, xx, yy, 0);
			for (int i = 0; i < M; i++) {
				x += dx[moveA[i]];
				y += dy[moveA[i]];
				xx += dx[moveB[i]];
				yy += dy[moveB[i]];
				checkAP(x, y, xx, yy, i + 1);
			}


			sb.append("#").append(test).append(" ");
			sb.append(res).append("\n");

			
		}
		System.out.println(sb);
	}

}
