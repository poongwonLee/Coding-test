import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	static int N,min;
	static int arr[][],select[];
	static ArrayList<Point> list= new ArrayList<>();
	static Point p[];
	
	static void dfs(int v) {
		if(v==list.size()) {
			PriorityQueue<Integer> pq= new PriorityQueue<>();
			PriorityQueue<Integer> pq2= new PriorityQueue<>();
			Queue<Integer> q= new LinkedList<Integer>();
			Queue<Integer> q2= new LinkedList<Integer>();
			
			for(int i=0;i<list.size();i++) {
				if(select[i]==0) {
					pq.add(Math.abs(p[0].x - list.get(i).x) + Math.abs(p[0].y - list.get(i).y) );
				}
				else {
					pq2.add(Math.abs(p[1].x - list.get(i).x) + Math.abs(p[1].y - list.get(i).y) );

				}
			}
			
			int time=0;
			while( !pq.isEmpty() || !pq2.isEmpty() || !q.isEmpty()|| !q2.isEmpty() ) {
				while(!q.isEmpty() && time >=q.peek())
					q.poll();
				
				while(!q2.isEmpty() && time >=q2.peek())
					q2.poll();
				
				while(q.size()<3 && !pq.isEmpty() && time>=pq.peek()) {
					q.add(arr[p[0].x][p[0].y]+time);
					pq.poll();
				}
				while(q2.size()<3 && !pq2.isEmpty()&&time>=pq2.peek()) {
					q2.add(arr[p[1].x][p[1].y]+time);
					pq2.poll();
				}
				
				time++;
			}
			
			min=Math.min(min, time);
			return;
		}
		select[v]=1;
		dfs(v+1);
		select[v]=0;
		dfs(v+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		int t=Integer.parseInt(st.nextToken());
		for(int test=1;test<=t ;test++) {
			list= new ArrayList<>();
			min=Integer.MAX_VALUE;
			
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			p= new Point[2];
			int idx=0;
			for(int i=0;i<N;i++) {
				arr[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for(int j=0;j<N;j++) {
					if(arr[i][j]==1)
						list.add(new Point(i,j));
					if(arr[i][j]>1)
						p[idx++]= new Point(i,j);
						
				}
			}
			
			select= new int[list.size()];
			dfs(0);
			System.out.println("#"+test+" "+min);
			
		}
	}
}