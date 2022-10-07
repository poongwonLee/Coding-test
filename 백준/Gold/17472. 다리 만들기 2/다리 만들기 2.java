import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	static int N, M,min=Integer.MAX_VALUE;
	static int[][]arr,visit;
	static int []dx= {0,1,0,-1},dy= {1,0,-1,0},unf;
	static HashMap<String, Integer> hm = new HashMap<>();
	static PriorityQueue<int []> pq;
	
	static int find(int a) {
		if(unf[a]==a) return a;
		else return unf[a]=find(unf[a]);
	}
	static void union(int a,int b) {
		int x=find(a);
		int y=find(b);
		if(x!=y)
			unf[x]=unf[y];
	}
	static void bfs(int a,int b,int cnt) {
		
		Queue<Integer> q= new LinkedList<Integer>();
		visit[a][b]=1;
		q.add(a);
		q.add(b);
		while(!q.isEmpty()) {
			int x=q.poll();
			int y=q.poll();
			hm.put(x+" "+y, cnt);
			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(!(0<=xx&&xx<N &&0<=yy&&yy<M)) {
					
					continue;
				}
				if(arr[xx][yy]==0) {
					hm.put(x+" "+y, cnt);
				}
				if(visit[xx][yy]!=0 || arr[xx][yy]!=1)continue;
				visit[xx][yy]=1;
				q.add(xx);
				q.add(yy);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		visit=new int[N][M];
		int cnt=0;
		
		for(int i=0;i<N;i++)
			arr[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1 && visit[i][j]==0) {
					bfs(i,j,++cnt);
				}
			}
		}
		pq= new PriorityQueue<>(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (Entry<String, Integer> i : hm.entrySet()) {
			for (Entry<String, Integer> j : hm.entrySet()) {
				if(i.getValue()==j.getValue())continue;
				int aX=Integer.parseInt(i.getKey().split(" ")[0]);
				int aY=Integer.parseInt(i.getKey().split(" ")[1]);
				int bX=Integer.parseInt(j.getKey().split(" ")[0]);
				int bY=Integer.parseInt(j.getKey().split(" ")[1]);
				if(aX==bX &&isCheck(aY,bY,aX,0)) {
					pq.add(new int[] {i.getValue(),j.getValue(),Math.abs(aY-bY)-1});
				}
				if(aY==bY &&isCheck(aX, bX, aY, 1)) {
					pq.add(new int[] {i.getValue(),j.getValue(),Math.abs(aX-bX)-1});

				}
			}
		}
		unf=new int[cnt+1];
		for(int i=1;i<=cnt;i++)
			unf[i]=i;
		int res=0;
		while(!pq.isEmpty()) {
			int x=pq.peek()[0];
			int y=pq.peek()[1];
			int val=pq.peek()[2];
			pq.poll();
			if(find(x)!=find(y)) {
				union(x,y);
				res+=val;
			}
		}
		
		for(int i=1;i<=cnt;i++) 
			if(find(unf[1])!=find(unf[i]))res=0;
		
		System.out.println(res==0 ? -1:res);
	}
	static boolean isCheck(int x,int y,int rc,int op) {
		
		int min=Math.min(x,y);
		int max=Math.max(x,y);
		if(max-min<=2)return false;
		min+=1;
		
		if(op==0) {
			while(min<M&&min<max) {
				if(arr[rc][min++]==1) return false;
			}
		}
		else {
			while(min<N&&min<max) {
				if(arr[min++][rc]==1) return false;
			}
		}
		
		return true;
	}
}
