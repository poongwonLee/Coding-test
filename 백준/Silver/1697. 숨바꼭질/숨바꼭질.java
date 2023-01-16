import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
		
		Queue<Integer> q= new LinkedList<Integer>();
		int []arr= new int [100001];
		int []dx= {-1,1,2};
		
		arr[n]=1;
		q.add(n);
		while(!q.isEmpty()) {
			int x= q.poll();
			for(int i=0;i<3;i++) {
			
				int xx=x+dx[i];
				if(i==2)xx=x*2;
				if(0<=xx && xx<=100000&& arr[xx]==0) {
					arr[xx]=arr[x]+1;
					q.add(xx);
				}
			}
		}
		
		System.out.println(arr[k]-1);

	}
}
