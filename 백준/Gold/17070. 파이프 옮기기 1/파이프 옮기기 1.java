import java.io.*;
import java.util.*;

public class Main {
	
	static int [][]arr;
	static int n,cnt;
	
	static boolean check(int x,int y) {
		return 0<=x && x<n && 0<=y && y<n&& arr[x][y]==0;
	}
	static void dfs(int x,int y) {
		if(x==n-1&&y==n-1)cnt++;
		if(arr[x][y]==1) return;
		
		if(arr[x][y]==2 || arr[x][y]==4) {
			if(check(x,y+1)) {
				arr[x][y+1]=2;
				dfs(x,y+1);
				arr[x][y+1]=0;
			}
		}
		if(arr[x][y]==3 || arr[x][y]==4) {
			if(check(x+1,y)) {
				arr[x+1][y]=3;
				dfs(x+1,y);
				arr[x+1][y]=0;

			}
		}
		
		if(arr[x][y]==2 || arr[x][y]==3 || arr[x][y]==4) {
			if(check(x+1,y+1)&&check(x+1,y)&&check(x,y+1)) {
				arr[x+1][y+1]=4;
				arr[x+1][y]=1;
				arr[x][y+1]=1;

				dfs(x+1,y+1);
				arr[x+1][y+1]=0;
				arr[x+1][y]=0;
				arr[x][y+1]=0;

			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		arr= new int[n][n];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				arr[i][j]=Integer.parseInt(st.nextToken());
		}
		arr[0][1]=2;
		dfs(0,1);
		System.out.println(cnt);
		
	}
}
