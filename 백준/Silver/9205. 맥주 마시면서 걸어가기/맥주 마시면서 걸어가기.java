
import java.util.*;
import java.io.*;


class Main {

	static int sX,sY,eX,eY;
	static int []visit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			sX=Integer.parseInt(st.nextToken());
			sY=Integer.parseInt(st.nextToken());
			ArrayList<int[]> list= new ArrayList<>();
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			st= new StringTokenizer(br.readLine());
			eX=Integer.parseInt(st.nextToken());
			eY=Integer.parseInt(st.nextToken());
			
			visit= new int[N];
			Queue<Integer> q= new LinkedList<Integer>();
			q.add(sX);
			q.add(sY);
			boolean flag=false;
			while(!q.isEmpty()) {
				int x=q.poll();
				int y=q.poll();
				if(isRange(x,y,eX,eY)) flag=true;
				for(int i=0;i<list.size();i++) {
					int xx=list.get(i)[0];
					int yy=list.get(i)[1];
					if(!isRange(x, y, xx, yy) || visit[i]==1) continue;
					q.add(xx);
					q.add(yy);
					visit[i]=1;
				}
			}
			sb.append((flag ? "happy":"sad")).append("\n");
		}
		System.out.println(sb);

	}
	static boolean isRange(int x,int y, int xx,int yy) {
		return (Math.abs(x-xx)+Math.abs(y-yy)) <=1000;
	}
	
}
