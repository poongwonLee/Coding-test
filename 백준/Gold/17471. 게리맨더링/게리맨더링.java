import java.io.*;
import java.util.*;

public class Main {

	static int N, min=Integer.MAX_VALUE;
	static int[] cntArr,select,visit;
	static ArrayList<Integer> []list;
	static int bfs(int x,int op,int flagSum) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(x);
		visit[x]=2;
		int cnt=0;
		int sum=0;
		while(!q.isEmpty()) {
			int xx=q.poll();
			cnt++;
			sum+=cntArr[xx];
			for (Integer i: list[xx]) {
				if(visit[i]!=op)continue;
				visit[i]=2;
				q.add(i);
			}
		}
		return flagSum==cnt ? sum:-1;
	}
	static void dfs(int v) {
		
		if( v==N) {
			int aCnt=0;
			int bCnt=0;
			for(int i=0;i<N;i++) {
				if(select[i]==0)bCnt++;
				else aCnt++;
				visit[i+1]=select[i];
			}
			if(aCnt==0 || aCnt==N) return;
			int aBfsCnt=0;
			int bBfsCnt=0;
			
			for(int i=0;i<N;i++) {
				if(select[i]==0) {
					bBfsCnt=bfs(i+1,0,bCnt);
					break;
				}
			}
			
			for(int i=0;i<N;i++) {
				if(select[i]==1) {
					aBfsCnt=bfs(i+1,1,aCnt);
					break;
				}
			}
			if(aBfsCnt==-1 || bBfsCnt==-1) return;
			min=Math.min(min, Math.abs(aBfsCnt-bBfsCnt));
			return;
		}
		select[v]=1;
		dfs(v+1);
		select[v]=0;
		dfs(v+1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		cntArr=new int[N+1];
		select=new int[N];
		visit=new int[N+1];
		list=new ArrayList[N+1];
		st= new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
			cntArr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=Integer.parseInt(st.nextToken());j>0; j--) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		dfs(0);
		System.out.println(min==Integer.MAX_VALUE? -1:min);

	}
}
