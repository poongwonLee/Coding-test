import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr, copyArr;
	static int[] visit, select;
	static int k, n, m,min=Integer.MAX_VALUE;
	static ArrayList<int[]> list = new ArrayList<>();

	static void Copy() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++)
				arr[i][j] = copyArr[i][j];
		}
	}

	static void dfs(int v) {
		if (k == v) {
			Copy();
			
			for (int i : select) 
				func(list.get(i)[0], list.get(i)[1], list.get(i)[2]);
			
			for (int i = 1; i <= n; i++) {
				int sum=0;
				for (int j = 1; j <= m; j++) 
					sum+=arr[i][j];
				min=Math.min(min, sum);
			}
			return;

		}
		for (int i = 0; i < k; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				select[v] = i;
				dfs(v + 1);
				visit[i] = 0;
			}
		}
	}

	static void func(int r, int c, int s) {

		for (int cnt = 0; cnt < s; cnt++) {

			int x1 = r - s + cnt, y1 = c - s + cnt, x2 = r + s - cnt, y2 = c + s - cnt;
			int tmp = arr[x1][y2];
			for (int i = y2; i > y1; i--)
				arr[x1][i] = arr[x1][i - 1];

			int tmp2 = arr[x2][y2];
			for (int i = x2; i > x1; i--)
				arr[i][y2] = arr[i - 1][y2];
			arr[x1 + 1][y2] = tmp;

			tmp = arr[x2][y1];
			for (int i = y1; i < y2; i++)
				arr[x2][i] = arr[x2][i + 1];
			arr[x2][y2 - 1] = tmp2;

			for (int i = x1; i < x2; i++)
				arr[i][y1] = arr[i + 1][y1];
			arr[x2 - 1][y1] = tmp;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visit = new int[k];
		select = new int[k];
		arr = new int[n + 1][m + 1];
		copyArr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				copyArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int[] num = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) };
			list.add(num);
		}
		dfs(0);
		System.out.println(min);
	
	}
}