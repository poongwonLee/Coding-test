import java.util.*;
import java.awt.Point;
import java.io.*;

class Solution {
	static int[]dx= {0,0,1,-1},dy= {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			sb.append("#").append(test).append(" ");
			st= new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			
			int[][]arr= new int[n][n];
			int [][]visit=new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], Integer.MAX_VALUE);
				arr[i]=Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			
			PriorityQueue<int []> pq= new PriorityQueue<>((x,y)->Integer.compare(x[2], y[2]));
			
			pq.add(new int[] {0,0,0});
			visit[0][0]=0;
			
			while(!pq.isEmpty()) {
				int x=pq.peek()[0];
				int y=pq.peek()[1];
				int dist=pq.peek()[2];
				pq.poll();
				if(visit[x][y]!=dist) continue;
				for(int i=0;i<4;i++) {
					int xx=x+dx[i];
					int yy=y+dy[i];
					if(!(0<=xx&&xx<n && 0<=yy &&yy<n))continue;
					if(visit[xx][yy] > arr[xx][yy]+dist) {
						visit[xx][yy] =arr[xx][yy]+dist;
						
						pq.add(new int[] {xx,yy,visit[xx][yy]});
					}
				}
			}
			sb.append(visit[n-1][n-1]).append("\n");
		}

		System.out.println(sb);
	}
}