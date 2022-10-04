
import java.util.*;
import java.io.*;

class Main {
	static int[][] arr;

	static void dfs(int a, int b) {

		for (int i = a; i < 9; i++) {
			for (int j = b; j < 9; j++) {

				if (arr[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (!isValid(i, j, k)) {
							arr[i][j] = k;
							dfs(i, j);
							arr[i][j] = 0;
						}
					}
					if (arr[i][j] == 0) return;
				}
				if (i == 8 && j == 8) {
					for (int[] ll : arr) {
						for (int l : ll)
							System.out.print(l);
						System.out.println();
					}
					System.exit(0);
				}
			}
			b = 0;
		}

	}

	static boolean isValid(int x, int y, int val) {
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == val)
				return true;
			if (arr[i][y] == val)
				return true;
		}
		x = x / 3 * 3;
		y = y / 3 * 3;
		for (int i = x; i < x + 3; i++)
			for (int j = y; j < y + 3; j++)
				if (arr[i][j] == val)
					return true;
		return false;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		arr = new int[9][9];
		for (int i = 0; i < 9; i++)
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		dfs(0, 0);

	}
}
