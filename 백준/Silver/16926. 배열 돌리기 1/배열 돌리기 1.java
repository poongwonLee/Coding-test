import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
				r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= n / 2 && k<=m/2; k++) {
			int x1 = k, y1 = k, x2 = n - k + 1, y2 = m - k + 1;
			for (int cnt = 0; cnt < r; cnt++) {
				
				int tmp = arr[x2][y1];
				for (int i = x2; i > x1; i--)
					arr[i][y1] = arr[i - 1][y1];

				int tmp2 = arr[x2][y2];
				for (int i = y2; i > y1; i--)
					arr[x2][i] = arr[x2][i - 1];
				arr[x2][y1 + 1] = tmp;

				tmp = arr[x1][y2];
				for (int i = x1; i < x2; i++)
					arr[i][y2] = arr[i + 1][y2];
				arr[x2 - 1][y2] = tmp2;

				for (int i = y1; i < y2; i++)
					arr[x1][i] = arr[x1][i + 1];
				arr[x1][y2 - 1] = tmp;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}