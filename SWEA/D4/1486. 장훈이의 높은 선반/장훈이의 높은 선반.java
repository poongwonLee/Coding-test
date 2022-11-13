
import java.util.*;
import java.io.*;

class Solution {
	static int[] arr; // 점원 담기
	static int N, B; // 점원 수 , 탑의 높이
	static int min;

	static void comb(int start, int sum) {
		
		if(min<=sum) return ;
		
		if (sum >= B) {
			min = Math.min(min, sum);		
			return;
		}
		if (start == N) {
			return;
		}
		

		for (int i = start; i < N; i++) {
				comb(i + 1, sum + arr[i]);
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= t; tt++) {
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			comb(0, 0);
			
			System.out.println("#"+tt+" "+ (min-B) );
		}

	}
}
