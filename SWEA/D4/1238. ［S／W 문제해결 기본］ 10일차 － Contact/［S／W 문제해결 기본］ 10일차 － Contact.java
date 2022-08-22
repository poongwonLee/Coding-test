
import java.awt.Point;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testCase = 10;
		for (int t = 1; t <= testCase; t++) {
			st= new StringTokenizer(br.readLine());
			int n,start;
			n=Integer.parseInt(st.nextToken());
			start=Integer.parseInt(st.nextToken());
			ArrayList<Integer> []node= new ArrayList[101];
			for(int i=1;i<=100;i++)
				node[i]= new ArrayList<>();
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<n/2;i++) 
				node[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			
			int depth[]= new int[101];
			Queue<Integer> q= new LinkedList<Integer>();
			q.add(start);
			depth[start]=1;
			while(!q.isEmpty()) {
				int x= q.poll();
				for (Integer i : node[x]) {
					if(depth[i]!=0) continue;
					depth[i]=depth[x]+1;
					q.add(i);
				}
			}
			int maxIdx=0;
			for(int i=1;i<=100;i++) 
				if(depth[maxIdx]<=depth[i])
					maxIdx=i;
			
			sb.append("#").append(t).append(" ");
			sb.append(maxIdx);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
