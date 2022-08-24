import java.io.*;
import java.util.*;


public class Main {

	static int N, M;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] visit, map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new int[N][M];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(i);
					q.add(j);
					visit[i][j] = 1;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x=q.poll();
			int y=q.poll();
			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(!(0<=xx&&xx<N&&0<=yy&&yy<M ))continue;
				if(visit[xx][yy]!=0||map[xx][yy]!=0)continue;
				visit[xx][yy]=visit[x][y]+1;
				map[xx][yy]=1;
				q.add(xx);
				q.add(yy);			
			}
		}
		
		boolean flag=true;
		int max=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max=Math.max(max, visit[i][j]);
				if(map[i][j]==0)flag=false;
			}
		}
		System.out.println(flag ? max-1 :-1);
	}
}
