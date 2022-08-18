import java.io.*;
import java.util.*;

public class Main {
	static int n, m, cnt;
	static int[] col, dx = { -1, 0, 1 };
	static int[][] arr;
	static boolean flag;

	static void dfs(int x, int y) {
		arr[x][y] = 1;
		if (y + 1 == m) {
			cnt++;
			flag = false;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int xx = x + dx[i];
			int yy = y + 1;
			if (0 <= xx && xx < n && yy < m && arr[xx][yy] == 0) {
				if (flag)
					dfs(xx, yy);
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (str[j].equals("x"))
					arr[i][j] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			flag = true;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
}