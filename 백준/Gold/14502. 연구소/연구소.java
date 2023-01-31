
import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
	static int N, M, cnt, max;
	static int[] select, dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] arr, visit;
	static ArrayList<Point> list = new ArrayList<>();

	static void dfs(int v) {
		if (v == 3) {
			visit=new int [N][M];
			cnt=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visit[i][j]==0 && arr[i][j]==2) {
						bfs(i,j);
					}
				}
			}
			max=Math.max(list.size()-3-cnt, max);
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (select[i] == 0) {
				select[i] = 1;
				arr[list.get(i).x][list.get(i).y]=1;
				dfs(v + 1);
				arr[list.get(i).x][list.get(i).y]=0;
				select[i]=0;
			}

		}

	}

	static void bfs(int a, int b) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(a);
		q.add(b);
		visit[a][b]=1;
		while(!q.isEmpty()) {
			int x= q.poll();
			int y= q.poll();
			
			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(!(0<=xx&&xx<N &&0<=yy&yy<M))continue;
				if(visit[xx][yy]!=0 || arr[xx][yy]!=0) continue;
				visit[xx][yy]=1;
				q.add(xx);
				q.add(yy);
				cnt++;
			}
		}
		
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					list.add(new Point(i, j));
			}
		}
		select = new int[list.size()];
		dfs(0);
		System.out.println(max);

	}
}
