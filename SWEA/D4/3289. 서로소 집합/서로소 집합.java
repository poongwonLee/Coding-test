import java.util.*;
import java.io.*;

class Solution {
	static int[] unf;

	static int find(int x) {
		if(unf[x]==x)return x;
		else return unf[x]=find(unf[x]);
	}

	static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x!=y)
			unf[x]=y;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			sb.append("#").append(test).append(" ");
			st= new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			unf= new int[N+1];
			for(int i=1;i<=N;i++)
				unf[i]=i;
			while(M--!=0) {
				st= new StringTokenizer(br.readLine());
				int op=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				if(op==0) {
					union(a,b);
				}else {
					sb.append(find(a)==find(b) ? 1:0);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}