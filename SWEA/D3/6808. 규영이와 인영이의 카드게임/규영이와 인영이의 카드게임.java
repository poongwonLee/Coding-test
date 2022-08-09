import java.io.*;
import java.util.*;

class Solution {
	public static int []arr;
	public static int[]arr2;
	public static int[]select;
	public static int[]visit;
	public static int sum;
	public static void dfs(int v,int cnt) {
		
		if (v==9) {
			int a=0;
			int b=0;
			for(int i=0;i<9;i++) {
				if(arr[i]>select[i])a+=arr[i]+select[i];
				else if(arr[i]<select[i]) b+=arr[i]+select[i];
			}
			if (a>b) sum++;
			return;
		}
		for(int i=0;i<9;i++) {
			
			if(visit[i]==0) {
				select[v]=arr2[i];
				visit[i]=1;
				dfs(v+1,cnt);
				visit[i]=0;
			}
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			arr= new int[9];
			arr2= new int[9];
			select= new int[9];
			visit= new int[9];
			sum=0;
			int []num= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				num[arr[i]]=0;
			}
			
			int idx=0;
			for(int i=1;i<=18&&idx<9;i++) {
				if(num[i]!=0)
					arr2[idx++]=i;
			}
			dfs(0,0);
			sb.append("#").append(t).append(" ");
			sb.append(sum).append(" ").append(362880-sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

