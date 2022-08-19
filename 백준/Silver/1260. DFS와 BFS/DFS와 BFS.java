import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> []list ;
	static int[]visit;
	static StringBuilder sb= new StringBuilder();
	static void dfs(int v) {
		sb.append(v).append(" ");
		visit[v]=1;
		for (int i : list[v]) {
			if(visit[i]!=0)continue;
			dfs(i);
		}
	}
	static void bfs(int s) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(s);
		visit[s]=1;
		while(!q.isEmpty()) {
			int x=q.poll();
			sb.append(x).append(" ");
			for (int i : list[x]) {
				if(visit[i]!=0)continue;
				q.add(i);
				visit[i]=1;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken())
				,start=Integer.parseInt(st.nextToken());
		
		list= new ArrayList[n+1];
		for (int i = 0; i < list.length; i++) {
			list[i]= new ArrayList<>();
		}
		
		while(m--!=0) {
			st= new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0;i<list.length;i++)
			Collections.sort(list[i]);
		visit= new int[n+1];
		dfs(start);
		sb.append("\n");
		visit= new int[n+1];
		bfs(start);
		
		System.out.println(sb);
	}
}