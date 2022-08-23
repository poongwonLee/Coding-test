import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] depth;
	static boolean flag=false;
	
	static ArrayList<Integer> node[];
	static void dfs(int v,int cnt) {
		if(flag)return;
		if(cnt==4) {
			flag=true;
		}
		depth[v]=1;
		for (int i : node[v]) {
			if(depth[i]!=0)continue;
			
			dfs(i,cnt+1);
			
		}
		depth[v]=0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		node = new ArrayList[N];
		depth= new int[N];
		for(int i=0;i<N;i++)
			node[i]= new ArrayList<>();
		
		while (M-- != 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a].add(b);
			node[b].add(a);
		}
		for(int i=0;i<N;i++) {
			depth= new int [N];
			dfs(i,0);
		}
		
		System.out.println(flag ? 1:0);
	}
}
