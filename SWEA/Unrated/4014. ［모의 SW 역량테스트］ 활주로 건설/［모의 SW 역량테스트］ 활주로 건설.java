
import java.util.*;
import java.io.*;


class Solution {

	static int N,X,res;
	static int [][]arr;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			res=0;
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			arr=new int[N][N];
			int [][]visit= new int[N][N];
			for(int i=0;i<N;i++) {
				boolean flag=true;
				arr[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for(int j=0;j<N-1;j++) {
					if(arr[i][j]!=arr[i][j+1]) {
						if(Math.abs(arr[i][j]-arr[i][j+1]) >1) {
							flag=false;
							break;
						}
						int left=j;
						int right=j+1;
						while(left>=0) {
							if(arr[i][j]!=arr[i][left]||visit[i][left]==1)break;
								left--;
						}
						
						while(right<N) {
							if(arr[i][j+1]!=arr[i][right]||visit[i][right]==1)break;
							right++;
						}
						 if(!((arr[i][j]>arr[i][j+1]&&(right-(j+1)) >=X ) || 
								(arr[i][j]<arr[i][j+1]&&(j-left)>=X) )){
							 flag=false;							
						}else {

						}
						 
						 if(arr[i][j]>arr[i][j+1]&&(right-(j+1)) >=X ) {
							 for(int k=j+1;k<j+1+X;k++)
								 visit[i][k]=1;
						 }
						 else if(arr[i][j]<arr[i][j+1]&&(j-left)>=X) {
							 for(int k=j;k>j-X;k--)
								 visit[i][k]=1;
						 }
						
					}
					
				}
				if(flag)res++;
			}
			
			visit= new int[N][N];

			for(int j=0;j<N;j++) {
				boolean flag=true;
				for(int i=0;i<N-1;i++) {
					if(arr[i][j]!=arr[i+1][j]) {
						if(Math.abs(arr[i][j]-arr[i+1][j]) >1) {
							flag=false;
							break;
						}
						int left=i;
						int right=i+1;
						while(left>=0) {
							if(arr[i][j]!=arr[left][j]||visit[left][j]==1)break;
								left--;
						}
						
						while(right<N) {
							if(arr[i+1][j]!=arr[right][j]||visit[right][j]==1)break;
							right++;
						}
						
						if(!((arr[i][j]>arr[i+1][j]&&(right-(i+1)) >=X ) || 
								(arr[i][j]<arr[i+1][j]&&(i-left)>=X) )){
							 flag=false;							
						}else {
							 

						}
						 if(arr[i][j]>arr[i+1][j]&&(right-(i+1)) >=X ) {
							 for(int k=i+1;k<i+1+X;k++)
								 visit[k][j]=1;
						 }
						 else if(arr[i][j]<arr[i+1][j]&&(i-left)>=X) {
							 for(int k=i;k>i-X;k--)
								 visit[k][j]=1;
						 }
						
					}
					
				}
				if(flag)res++;
			}
			
			
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
			
			
			
			
		}
		System.out.println(sb);

	}
	
}
