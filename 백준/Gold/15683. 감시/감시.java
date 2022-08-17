import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr, copyArr;
	static int N, M,min=Integer.MAX_VALUE;
	static ArrayList<CCTV> list = new ArrayList<>();
	static int[][] cctvMove = { { 0 }, { 4, 1 }, { 2, 1, 3 }, { 4, 0, 1 }, { 4, 3, 0, 1 }, { 1, 0, 1, 2, 3 } };

	static void dfs(int v) {
		if (v == list.size()) {
			int cnt=0;
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(arr[i][j]==0)
						cnt++;
			min=Math.min(min, cnt);
			return;
		}

		int[][] tmp = new int[N][M];
		Copy(tmp, arr);
		CCTV cv = list.get(v);

		for (int i = 0; i < cctvMove[cv.op][0]; i++) {
			Move(cv, i);
			dfs(v + 1);
			Copy(arr, tmp);
		}

	}

	static void Move(CCTV cctv, int idx) {
		for (int i = 1; i < cctvMove[cctv.op].length; i++) {
			int nextIdx = (idx + cctvMove[cctv.op][i]) % 4;
			int x = cctv.x;
			int y = cctv.y;
			arr[x][y] = cctv.op;
			while (nextIdx == 0 && 0 <= x - 1 && arr[x - 1][y] != 6)
				arr[--x][y] = 7;
			while (nextIdx == 1 && y + 1 < M && arr[x][y + 1] != 6) 
				arr[x][++y] = 7;
			while (nextIdx == 2 && x + 1 < N && arr[x + 1][y] != 6)
				arr[++x][y] = 7;
			while (nextIdx == 3 && 0 <= y - 1 && arr[x][y - 1] != 6) 
				arr[x][--y] = 7;
		}
	}

	static void Copy(int[][] arr, int[][] tmp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				arr[i][j] = tmp[i][j];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copyArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= arr[i][j] && arr[i][j] <= 5)
					list.add(new CCTV(i, j, arr[i][j]));
			}
		}
		dfs(0);
		System.out.println(min);
	}

	static class CCTV {
		int x, y, op;
		public CCTV(int x, int y, int op) {
			super();
			this.x = x;
			this.y = y;
			this.op = op;
		}

	}
}