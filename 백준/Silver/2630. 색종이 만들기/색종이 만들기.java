import java.io.*;
import java.util.*;

public class Main {
	public static int N, S, cnt, cnt2;
	public static int[][] arr;

	public static void dfs(int size, int x, int y) {
		if (size <= 0)
			return;
		boolean flag = true;
		boolean flag2 = true;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] == 0) {
					flag = false;
				} else
					flag2 = false;
			}
		}
		if(flag) {
			cnt++;
			return;
		}
		if(flag2) {
			cnt2++;
			return;
		}
		size /= 2;
		dfs(size, x, y);
		dfs(size, x, y + size);
		dfs(size, x + size, y);
		dfs(size, x + size, y + size);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(N, 0, 0);
		System.out.println(cnt2);
		System.out.println(cnt);
	}
}