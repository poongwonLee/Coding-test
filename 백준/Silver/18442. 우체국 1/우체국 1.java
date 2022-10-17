import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M ;
	static long L,res;
	static long[] arr;
	static int[] select,resArr;
	static int[] visit;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int v,int cnt) { //조합으로 마을 갯수 M개고르기
		if(v==M) {
			long sum=0;
			for(int i=0;i<N;i++) {
				long min=Long.MAX_VALUE;
				for(int j=0;j<N;j++) { //경찰서마을을 고른 기준으로 다탐색하여 가장작은 거리를 min에 저장
					if(visit[j]==1) {
					min=Math.min(min, Math.min(Math.abs(arr[i]-arr[j]), L-Math.abs(arr[i]-arr[j])));
					}
				}
				sum+=min; //해당 마을 가까운 경찰서 거리 더하기
				
			}
			if(res>sum) {
				resArr=Arrays.copyOf(select, select.length);
				res=sum;
				
			}
			res=Math.min(res, sum); // 총 거리 합 갱신 가장 작은 거리합이 저장됨
			return;
		}
		for(int i=cnt;i<N;i++) {
			
				visit[i]=1;
				select[v]=i;
				dfs(v+1,i+1);
				visit[i]=0;
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
			res=Long.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			L = Long.parseLong(st.nextToken());

			arr = new long[N];
			select = new int[M];
			visit = new int[N];
			resArr=new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			dfs(0,0);
		System.out.println(res);
		for(int i=0;i<M;i++) {
			
			sb.append(arr[resArr[i]]).append(" ");
		}
		
		System.out.println(sb);

	}

}
