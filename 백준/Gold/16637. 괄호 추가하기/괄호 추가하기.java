import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int n,max=Integer.MIN_VALUE;
	static String[] arr;
	static int[]visit;
	static int oper(int x,int y,String op) {
		if(op.equals("+"))
			return x+y;
		if(op.equals("-"))
			return x-y;
		return x*y;
	}
	static void dfs(int v,int cnt) {
		if(v>=(n)/2) {
			
			int []select= new int[n];
			int []res= new int[n];
			
			for(int i=0;i<n;i++) {
				if(Character.isDigit(arr[i].charAt(0)))
					res[i]=Integer.parseInt(arr[i]);
			}
			for(int i=0;i<n;i++) {
				if(visit[i]==1) {
					select[i-1]=1;
					select[i]=1;
					res[i+1]=oper(res[i-1],res[i+1],arr[i]);
				}
			}
			int curSum=0;
			for(int i=0;i<n;i++) {
				if(select[i]==0) {
					curSum=res[i];
					select[i]=1;
					break;
				}
			}
			
			for(int i=0;i<n;i++) {
				if(select[i]==0) {
					for(int j=i+1;j<n;j++) {
						if(select[j]==0) {
							curSum=oper(curSum,res[j],arr[i]);
							i=j;
							break;
						}
					}
				}
			}
			max=Math.max(max, curSum);
			return;
		}
		visit[v*2+1]=1;
		dfs(v+2,cnt+1);
		visit[v*2+1]=0;
		dfs(v+1,cnt);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		visit=new int[n];
		arr= br.readLine().split("");
		dfs(0,0);
		System.out.println(max);
	}
}
