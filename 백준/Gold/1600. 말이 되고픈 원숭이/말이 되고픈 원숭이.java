import java.io.*;
import java.util.*;

public class Main {

	static int N, M, T;
	static int[][] tmpMap, map;
	static int[] dx = { 0, 0, 1, -1,-2,-1,1,2,2,1,-1,-2}, dy = { 1, -1, 0, 0,1,2,2,1,-1,-2,-2,-1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m= Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int arr[][]= new int[n][m];
		int visit[][][]= new int[n][m][k+1];
		
		
	
		
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				arr[i][j]=Integer.parseInt(st.nextToken());
		}
		
		Queue<int []> q= new LinkedList<int[]>();
		visit[0][0][0]=1;

		q.add(new int[] {0,0,0});
		while(!q.isEmpty()) {
			int x=q.peek()[0];
			int y=q.peek()[1];
			int cnt=q.peek()[2];
			q.poll();
			for(int i=0;i<12;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				
				if(!(0<=xx&&xx<n &&0<=yy&&yy<m)) continue;
				if(i>=4 &&(cnt >=k ||visit[xx][yy][cnt+1]!=0) ) continue;
				if(i<=3 && visit[xx][yy][cnt]!=0) continue;
				if(arr[xx][yy]!=0) continue;
				
				if(i>=4) {
					visit[xx][yy][cnt+1]=visit[x][y][cnt]+1;
					q.add(new int[] {xx,yy,cnt+1});

				}
				else {
					visit[xx][yy][cnt]=visit[x][y][cnt]+1;
					q.add(new int[] {xx,yy,cnt});
				}
				
			}
		}
	
		int min=Integer.MAX_VALUE;
		for(int i=0;i<=k;i++) {
			min= Math.min(visit[n-1][m-1][i]==0 ?min : visit[n-1][m-1][i] ,min);
		}
		System.out.println(min==Integer.MAX_VALUE ? -1 :min-1);
	}
}
