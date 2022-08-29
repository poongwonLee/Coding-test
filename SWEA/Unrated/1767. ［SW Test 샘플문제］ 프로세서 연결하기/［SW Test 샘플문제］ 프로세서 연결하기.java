import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int N, M, size, min;
	static int[] visit;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static ArrayList<Point> list;

	static void com(int idx, int cnt, int R) {
		if (cnt == R) {
			dfs(0, 0);
			return;
		}
		if (size == idx)
			return;
		visit[idx] = 1;
		com(idx + 1, cnt + 1, R);
		visit[idx] = 0;
		com(idx + 1, cnt, R);
	}

	static void dfs(int idx, int cnt) {
		if (idx == size) {
			min =Math.min(min, cnt);
			return;
		}
		if (visit[idx] == 0) {
			dfs(idx + 1, cnt);
		}
		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			Point cur = list.get(idx);
			int xx = cur.x + dx[i];
			int yy = cur.y + dy[i];
			int tmp = 0;
			while (true) {

				if (xx == -1 || yy == -1 || xx == N || yy == N)
					break;
				if (arr[xx][yy] != 0) {
					flag = false;
					break;
				}
				arr[xx][yy] = 2;
				tmp++;
				xx +=  dx[i];
				yy +=  dy[i];
			}
			if (flag) {
				dfs(idx+1 , cnt + tmp);
			}
			xx-=dx[i];
			yy-=dy[i];
			while (true) {
				if (xx == cur.x && yy==cur.y)
					break;
				arr[xx][yy] = 0;
				xx -= dx[i];
				yy -= dy[i];
			}

		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= t; test++) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			min=Integer.MAX_VALUE;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (arr[i][j] == 1)
						list.add(new Point(i, j));
				}
			}
			size = list.size();
			visit = new int[size];
			for (int i = size; i >= 0; i--) {
				com(0, 0, i);
				if(min!=Integer.MAX_VALUE) break;
			}
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}