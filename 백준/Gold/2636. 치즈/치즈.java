import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] visit, map;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++)
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int cnt = 0;
		int ans = 0;
		int lastCnt=0;
		for (int []ll : map) for (int l: ll) cnt+= (l==0 ? 1:0);
			
		while (cnt != N * M) {
			lastCnt=N*M-cnt;
			cnt = 0;
			ans++;
			visit=new int[N][M];
			visit[0][0]=1;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			q.add(0);
			while (!q.isEmpty()) {
				int x = q.poll();
				int y = q.poll();
				for (int i = 0; i < 4; i++) {
					int xx = x + dx[i];
					int yy = y + dy[i];
					if (!(0 <= xx && xx < N && 0 <= yy && yy < M)) continue;
					if (map[xx][yy] == 1) {
						map[xx][yy] = 0;
						visit[xx][yy] = 1;
					}
					if (map[xx][yy] == 1 || visit[xx][yy] != 0) continue;
					q.add(xx);
					q.add(yy);
					visit[xx][yy] = 1;
				}
			}
			for (int []ll : map) for (int l: ll) cnt+= (l==0 ? 1:0);	
		}

		System.out.println(ans);
		System.out.println(lastCnt);

	}
}
