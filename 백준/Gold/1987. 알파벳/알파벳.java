import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] visit = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < str.length; j++)
				arr[i][j] = str[j].charAt(0) - 'A';
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, 1 << arr[0][0], 1 });
		visit[0][0]=1<<arr[0][0];
		int max = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int bit = q.peek()[2];
			int cnt = q.peek()[3];
			max = Math.max(max, cnt);

			q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (!(0 <= xx && xx < n && 0 <= yy && yy < m))
					continue;
				if ((bit & 1 << arr[xx][yy]) != 0)
					continue;
				int nextBit = bit | 1 << arr[xx][yy];
				if(nextBit==visit[xx][yy])continue;
				
				visit[xx][yy]=nextBit;
				q.add(new int[] { xx, yy, nextBit, cnt + 1 });
				
			}

		}
		System.out.println(max);
	}
}