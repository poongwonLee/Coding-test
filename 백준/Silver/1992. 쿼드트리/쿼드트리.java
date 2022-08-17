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
			System.out.print(1);
			return;
		}
		if(flag2) {
			cnt2++;
			System.out.print(0);
			return;
		}
		System.out.print("(");
		size /= 2;
		dfs(size, x, y);
		dfs(size, x, y + size);
		dfs(size, x + size, y);
		dfs(size, x + size, y + size);
		System.out.print(")");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[]str= br.readLine().split("");
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}
		dfs(N, 0, 0);
		
	}
}