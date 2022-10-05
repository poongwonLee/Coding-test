import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static char map[][];
	static int visit[][][];
	static int[] dx= {0,0,1,-1},dy= {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visit=new int[N][M][1<<6];
		int startX=0,startY=0;
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j]=='0') {
					startX=i;
					startY=j;
				}
			}
		}
		
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(startX);
		q.add(startY);
		q.add(0);
		visit[startX][startY][0]=1;
		
		while(!q.isEmpty()) {
			int x=q.poll();
			int y=q.poll();
			int k=q.poll();
			if(map[x][y]=='1') {
				System.out.println(visit[x][y][k]-1);
				return;
			}
			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(!(0<=xx&&xx<N &&0<=yy &&yy<M)) continue;
				if(map[xx][yy]=='#'||visit[xx][yy][k]!=0)continue;
				if('a'<= map[xx][yy]&& map[xx][yy]<='z'){
					int kk=( k | (1<< (map[xx][yy]-'a') ));
					q.add(xx);
					q.add(yy);
					q.add(kk);
					visit[xx][yy][kk]=visit[x][y][k]+1;
				}
				if(('A'<=map[xx][yy]&&map[xx][yy]<='Z' && 
						(k & (1<<(map[xx][yy]-'A')))==0))continue;
				visit[xx][yy][k]=visit[x][y][k]+1;
				q.add(xx);
				q.add(yy);
				q.add(k);
			
			}
			
		}
		System.out.println(-1);
		
		

	}
}
