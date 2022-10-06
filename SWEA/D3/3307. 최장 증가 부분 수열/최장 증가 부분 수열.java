
import java.util.*;
import java.io.*;


class Solution {

	static int S;
	static int []tree;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int [][]arr= new int[N][2];
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i][0]=i+1;
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr,new Comparator<int[]>() {

				@Override
				public int compare(int[] x, int[] y) {
					
					return Integer.compare(x[1],y[1]);
				}
			});

			
			for(S=1;S<N;S*=2);
			tree=new int[S*2];
			
			for(int i=0;i<N;i++) 
				updateBU(arr[i][0],maxBU(1,arr[i][0]));
		
			sb.append("#").append(test_case).append(" ");
			sb.append(tree[1]).append("\n");
		}
		System.out.println(sb);

	}
	static void updateBU(int idx,int val) {
		int x=idx+S-1;
		tree[x]=val;
		x/=2;
		while(x>0) {
			tree[x]=Math.max(tree[x*2],tree[x*2+1]);
			x/=2;
		}
	}
	static int maxBU(int left,int right) {
		int leftPos=left+S-1;
		int rightPos=right+S-1;
		
		int res=0;
		while(leftPos<=rightPos) {
			if(leftPos%2!=0) {
				res=Math.max(res,tree[leftPos++]);
			}
			if(rightPos%2==0) {
				res=Math.max(res,tree[rightPos--]);
			}
			rightPos/=2;
			leftPos/=2;

		}
		return res+1;
		
	}
}
