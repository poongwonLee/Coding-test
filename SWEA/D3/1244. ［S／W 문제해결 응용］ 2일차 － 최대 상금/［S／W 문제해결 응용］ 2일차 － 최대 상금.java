
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

	public static int n;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
			int cnt = Integer.parseInt(st.nextToken());

			n=arr.length;
			
			int cnt2 = 0; //몇번 스왑했는지.
			
			for (int i = 0; i < n; i++) {
				int idx = i;
				int idxcnt=0; // 최대값 idx의 중복횟수 
				int idxCntTmp=i; //중복횟수저장된 idx
				for (int j =n-1 ; j >= i+1; j--) {
					if (arr[idx] < arr[j]) {
						idx = j;
						idxcnt=1;
					}
					else if( arr[idx]==arr[j] &&idxcnt<cnt) { //중복횟수가 cnt를 넘어선 안됨
						idxcnt++;
						idxCntTmp=j;
					}
				}
				if (idx != i && cnt!=0) {
					if(idxcnt>1 )idx=idxCntTmp;
					int tmp = arr[i];
					arr[i] = arr[idx];
					arr[idx] = tmp;
					cnt--;
				}

			}
			boolean flag=true;
			for(int i=0;i<n-1;i++) 		// 최대값입 보장된 배열에서 연속된 수가 있을경우 서로 변경이 가능해 남은 cnt만큼 스왑안해도된다.
				if(arr[i]==arr[i+1])flag=false; 
			
			while(n!=1&& flag&&cnt--!=0) { // cnt만큼 못채울시 마지막 배열 2개끼리 스왑 최대값 최소화 보존
				int tmp=arr[n-1];
				arr[n-1]=arr[n-2];
				arr[n-2]=tmp;
			}
			sb.append("#").append(t).append(" ");
			for (int i : arr)
				sb.append(i);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
