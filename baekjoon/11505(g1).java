import java.util.*;

import java.io.*;

public class Main {

	static int N, M, K, S;
	static int arr[];
	static long tree[];
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (S = 1; S < N; S *= 2)
			;
		arr = new int[N + 1];
		tree = new long[S * 2];
		for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		initDU();
		
		for(int i=0;i<M+K;i++) {
			st= new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(a==1) {
				updateDU(b,c);
			}else {
				queryDU(b, c);
			}
		}
		System.out.println(sb);

	}
	static void updateDU(int idx,int val) {
		int X=idx+S-1;
		tree[X]=val;
		X/=2;
		while(X>0) {
			tree[X]=(tree[X*2]*tree[X*2+1])%1000000007;
			X/=2;
		}
		
	}
	static void queryDU(int left,int right) {
		left+=S-1;
		right+=S-1;
		long sum=1;
		while(left<=right) {
			if(left%2==1) {
				sum=(sum*tree[left++])%1000000007;
			}
			if(right%2==0) {
				sum=(sum*tree[right--])%1000000007;
			}
			left/=2;
			right/=2;
		}
		sb.append(sum+"\n");
	}
	static void initDU() {
		for(int i=S;i<S+N;i++) {
			tree[i]=arr[i-S+1];
		}
		for(int i=S-1;i>=1;i--) {
			tree[i]=(tree[i*2]*tree[i*2+1])%1000000007;
		}
	}
}
