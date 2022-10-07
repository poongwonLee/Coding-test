import java.util.*;
import java.io.*;

class Solution {
	static final int INF=Integer.MAX_VALUE/2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			sb.append("#").append(test).append(" ");
			st= new StringTokenizer(br.readLine());
			int N=Int(st.nextToken());
			st= new StringTokenizer(br.readLine());
			int M=Int(st.nextToken());
			
			int [][]arr=new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				Arrays.fill(arr[i], INF);
				arr[i][i]=0;
			}
			for(int i=0;i<M;i++) {
				st= new StringTokenizer(br.readLine());
				int a=Int(st.nextToken());
				int b=Int(st.nextToken());
				arr[a][b]=1;
				
			}
			
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						if(arr[i][j] > arr[i][k] +arr[k][j]) {
							arr[i][j]= arr[i][k] +arr[k][j];
						}
					}
				}
			}
			int res=0;
			for(int i=1;i<=N;i++) {
				int cnt=0;
				for(int j=1;j<=N;j++) {
					if(arr[i][j]!=INF ||arr[j][i]!=INF)
						cnt++;
				}
				if(cnt==N)res++;
			}
			
			sb.append(res).append("\n");
		}

		System.out.println(sb);
	}
	static int Int(String i) {
		return Integer.parseInt(i);
	}
}