import java.io.*;
import java.util.*;

class Solution {

	public static int[][] arr;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int n;
	
	public static int bfs(int a, int b) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		q.add(b);
		int cnt=1;
		while(!q.isEmpty()) {
			int x=q.poll();
			int y=q.poll();
			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(0<=xx && xx<n && 0<=yy && yy<n&& arr[x][y]+1 == arr[xx][yy]) {
					cnt++;
					q.add(xx);
					q.add(yy);
				}
			}
		}
		return cnt;

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			int max = 0;
			int maxNum = n * n + 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = bfs(i, j);
					if (max < tmp) {
						max = tmp;
						maxNum=arr[i][j];
					}else if(max == tmp && maxNum > arr[i][j]) {
						maxNum = arr[i][j];
					}
				}
			}
			sb.append("#").append(t).append(" ");
			sb.append(maxNum).append(" ").append(max);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
