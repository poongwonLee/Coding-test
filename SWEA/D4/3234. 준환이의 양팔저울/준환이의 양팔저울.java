import java.util.*;
import java.io.*;

class Solution {

	static int[] arr, visit,select,visit2;
	static int n, cnt, arrSum;
	static void dfs2(int v,int sum,int sum2) {
		if(sum<sum2)return;
		if(v==n) {
			
			cnt++;
			return;
			
		}
		
		dfs2(v+1,sum+select[v],sum2);
		visit2[v]=0;
		dfs2(v+1,sum,sum2+select[v]);
		
		
	}
	static void dfs(int v) {
		 
		if (v == n) {
			visit2=new int[n];
			dfs2(1,select[0],0);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visit[i]==0) {
				visit[i]=1;
				select[v]=arr[i];
				dfs(v+1);
				visit[i]=0;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			arrSum = cnt = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			visit = new int[n];
			select= new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				arrSum += arr[i];
			}
			dfs(0);
			
			sb.append("#").append(test).append(" ");
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

}
