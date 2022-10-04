
import java.util.*;
import java.io.*;


class Solution {
	static int [][]copyArr,arr,moveArr,visit;
	static int N, M, K,min;
	static int[] select,dx= {0,0,1,-1},dy= {1,-1,0,0};
	
	static void copy(int [][]a,int [][]b) {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				a[i][j]=b[i][j];
	}
	
	static void dfs(int v) {
		if(v==K) {
			
			copy(arr,copyArr);
			for(int s=0;s<K;s++) {
				int j=select[s];
				
				for(int i=0;i<N;i++) {
					if(arr[i][j]!=0) {
						bfs(i,j);
						func();//깨진벽돌 이동
						break;
					}
				}
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]!=0)
						cnt++;
				}
			}
			
			min=Math.min(min,cnt);
			return;
		}
		for(int i=0;i<M;i++) {
			select[v]=i;
			dfs(v+1);

		}
		
	}
	static void bfs(int a,int b) {
		visit= new int[N][M];
		Queue<Integer> q= new LinkedList<>();
		
		
		q.add(a);
		q.add(b);
		q.add(arr[a][b]);
		arr[a][b]=0;
		visit[a][b]=1;
		while(!q.isEmpty()) {
			int x=q.poll();
			int y=q.poll();
			int tmpk=q.poll()-1;			

			for(int i=0;i<4;i++) {
				int xx=x;
				int yy=y;
				int k=tmpk;
				while(k-->0) {
					xx+=dx[i];
					yy+=dy[i];
					if(!(0<=xx&&xx<N && 0<=yy && yy<M)) continue;
					if(visit[xx][yy]!=0)continue;
					visit[xx][yy]=1;
					
					q.add(xx);
					q.add(yy);
					q.add(arr[xx][yy]);
					arr[xx][yy]=0;
				}
			}
			
		}
	}
	
	static void func() { //깨진 벽돌 내리기
		moveArr=new int[N][M];
		
		for(int j=0;j<M;j++) {
			int idx=N-1;
			for(int i=N-1;i>=0;i--) {
				if(arr[i][j]!=0) {
					moveArr[idx--][j]=arr[i][j];
				}
			}
		}
		copy(arr,moveArr);
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			min=Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			copyArr = new int[N][M];
			select= new int[K];
			for(int i=0;i<N;i++) 
				copyArr[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			dfs(0);

			System.out.println("#"+test_case+" "+min);
		}

	}
}
