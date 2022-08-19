import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] visit;
	static int n, m, d, max;
	static List<Point> zeroList = new ArrayList<>(), attackList = new ArrayList<>(),
			selectList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	static void isAttack() {

	}

	static void dfs(int v, int cnt) {
		if (cnt == 3) {

			int attackCnt = 0;
			int[] attackVisit = new int[attackList.size()];
			for (int i = 0; i < n ; i++) {
				PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						if (o1[2] == o2[2]) {
							if (attackList.get(o1[1]).y == attackList.get(o2[1]).y)
								return Integer.compare(attackList.get(o1[1]).x, attackList.get(o2[1]).x);
							return Integer.compare(attackList.get(o1[1]).y, attackList.get(o2[1]).y);
						}
						return Integer.compare(o1[2], o2[2]);
					}
				});

				for (int s = 0; s < selectList.size(); s++) {
					int minDist = Integer.MAX_VALUE;
					int minAttackIdx = 0;
					for (int j = 0; j < attackList.size(); j++) {
						Point attack = attackList.get(j);
						int dist = Math.abs((attack.x + i) - selectList.get(s).x)
								+ Math.abs(attack.y - selectList.get(s).y);
						if (((attack.x + i) <= n - 2) && dist <= d && dist <= minDist && attackVisit[j] == 0) {

							minDist = dist;
							minAttackIdx = j;
							if(dist==minDist)pq.add(new int[] {s,minAttackIdx,minDist});
						}
					}
					if (minDist != Integer.MAX_VALUE) {
						pq.add(new int[] { s, minAttackIdx, minDist });
					}

				}
				int[] selectVisit = new int[selectList.size()];
				while (!pq.isEmpty()) {
					int select = pq.peek()[0];
					int attack = pq.peek()[1];
					int dist = pq.peek()[2];
					pq.poll();
					if (selectVisit[select] == 0) {
						selectVisit[select] = 1;
						if (attackVisit[attack] == 0) {
							attackVisit[attack] = 1;
							attackCnt++;
						}
					}
				}
			}

			max = Math.max(max, attackCnt);
			return;
		}
		if (v == zeroList.size())
			return;
		selectList.add(zeroList.get(v));
		dfs(v + 1, cnt + 1);
		selectList.remove(selectList.size() - 1);
		dfs(v + 1, cnt);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()) + 1;
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					;
				else
					attackList.add(new Point(i, j));
			}
		}
		for (int i = 0; i < m; i++)
			zeroList.add(new Point(n - 1, i));
		visit = new int[zeroList.size()];
		dfs(0, 0);

		System.out.println(max);

	}
}
/*
 * 9 10 4 1 0 0 1 0 1 0 1 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 1 0 0 1 1 1 0 0 1 1 0
 * 1 0 1 1 0 0 1 1 0 0 0 0 1 0 1 0 1 1 1 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 0 1 1 1 1
 * 1 1 1 1 0 1 0 1 1 0 1 1 0 1 1 0
 */