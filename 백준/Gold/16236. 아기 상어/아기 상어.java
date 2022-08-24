import java.io.*;
import java.util.*;

public class Main {

	static int N,startX=0, startY=0,size=2,time,cnt;
	static int []dx= {0,0,1,-1},dy= {1,-1,0,0};
	static int[][] visit,map;
	static boolean flag=true;
	static void bfs(int a,int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit = new int[N][N];
		q.add(a);
		q.add(b);
		visit[a][b]=1;
		PriorityQueue<int []> pq= new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] x, int[] y) {
				if(x[2]==y[2]) {
					if(x[0]==y[0])
						return Integer.compare(x[1], y[1]);
					return Integer.compare(x[0], y[0]);
				}
				return Integer.compare(x[2], y[2]);
			}
		});
		
		
		while(!q.isEmpty()) {

			int x=q.poll();
			int y=q.poll();
			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(!(0<=xx&& xx<N && 0<=yy &&yy<N))continue;
				if(map[xx][yy]>size || visit[xx][yy]!=0)continue;
				visit[xx][yy]=visit[x][y]+1;
				if(map[xx][yy]!=0 &&map[xx][yy]<size) pq.add(new int [] {xx,yy,visit[xx][yy]});
				q.add(xx);
				q.add(yy);
			}
		}
		if(!pq.isEmpty()) {
			cnt++;
			time+=pq.peek()[2]-1;
			
			map[pq.peek()[0]][pq.peek()[1]]=0;
			startX=pq.peek()[0];
			startY=pq.peek()[1];
			
		}else
			flag=false;
		if(cnt==size) {
			cnt=0;
			size++;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j=0;j<N;j++) {
				if(map[i][j]==9) {
					startX=i;
					startY=j;
				}
			}
		}
		map[startX][startY]=0;
		while(flag) {
			bfs(startX,startY);
		}
		
		System.out.println(time);
		
//		System.out.println(map[endX][endY].equals("S") ? visit[endX][endY] :"KAKTUS");
	}
}
