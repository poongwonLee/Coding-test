
import java.awt.Point;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

	static int n,min;
	static int[] visit;
	static Point []arr;

	static void dfs(int v,int x,int y,int dist) {
		if(v==n) {
			min=Math.min(min, dist + Math.abs(x-arr[1].x) +Math.abs(y-arr[1].y));
			return;
		}
		for(int i=2;i<n+2;i++) {
			int nextDist=dist + Math.abs(x-arr[i].x) +Math.abs(y-arr[i].y);

			if(visit[i-2]==0 &&nextDist < min ) {
				visit[i-2]=1;
				dfs(v+1,arr[i].x,arr[i].y,nextDist);
				visit[i-2]=0;

			}
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			min=Integer.MAX_VALUE;
			n= Integer.parseInt(br.readLine());
			arr= new Point[n+2];
			visit= new int[n];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<n+2;i++)
				arr[i]=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			dfs(0,arr[0].x,arr[0].y,0);
			
			sb.append("#").append(t).append(" ");
			sb.append(min);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
