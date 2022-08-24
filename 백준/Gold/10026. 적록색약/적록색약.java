import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] visit;
	static String[][] map;

	static void bfs(int a, int b,boolean flag) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		q.add(b);
		visit[a][b] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (!(0 <= xx && xx < N && 0 <= yy && yy < N))continue;
				if (visit[xx][yy]!=0)continue;
				
				if ( (flag&&map[x][y].equals("G")&&map[xx][yy].equals("R"))
						||(flag&&map[x][y].equals("R")&&map[xx][yy].equals("G"))
						||map[xx][yy].equals(map[x][y])) {
				visit[xx][yy]=1;
				q.add(xx);
				q.add(yy);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new String[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
			
		}

		int RGCnt = 0;
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
					RGCnt++;
					bfs(i, j,true);
				}
			}
		}
		int notRGCnt = 0;
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
					notRGCnt++;
					bfs(i, j,false);
				}
			}
		}
		System.out.println(notRGCnt+" "+RGCnt);
	}
}
