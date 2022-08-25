import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] dist,map;
	static int[] dx={0,0,1,-1},dy= {1,-1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {

			map = new int[N][N];
			for (int i = 0; i < N; i++)
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			dist= new int[N][N];
			for(int i=0;i<N;i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			
			dist[0][0]=map[0][0];
			PriorityQueue<int []> pq= new PriorityQueue<>((x,y)->Integer.compare(x[2],y[2]));
			pq.add(new int [] {0,0,map[0][0]});
			
			while(!pq.isEmpty()){
				int curX=pq.peek()[0];
				int curY=pq.peek()[1];
				int curVal=pq.peek()[2];
				pq.poll();
				if(dist[curX][curY]!=curVal) continue;
				for(int i=0;i<4;i++) {
					int nextX=curX+dx[i];
					int nextY=curY+dy[i];
					if(!(0<=nextX && nextX<N && 0<=nextY && nextY<N)) continue;
					if(dist[nextX][nextY] > map[nextX][nextY]+curVal) {
						dist[nextX][nextY] = map[nextX][nextY]+curVal;
						pq.add(new int[] {nextX,nextY,dist[nextX][nextY]});
					}
				}
				
				
			}
			System.out.printf("Problem %d: %d\n",cnt++,dist[N-1][N-1]);
			
		}
	}
}
