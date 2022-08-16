
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
			int cnt2 = 0;
			int l=0;
			
			for (int i = 0; i < n; i++) {
				int idx = i;
				int idxcnt=0;
				int idxCntTmp=i;
				for (int j =n-1 ; j >= i+1; j--) {
					if (arr[idx] < arr[j]) {
						idx = j;
						idxcnt=1;
					}
					else if( arr[idx]==arr[j] &&idxcnt<cnt-cnt2) {
						idxcnt++;
						idxCntTmp=j;
					}
				}
				if (idx != i && cnt2<cnt) {


					if(idxcnt>1 )idx=idxCntTmp;
					int tmp = arr[i];
					arr[i] = arr[idx];
					arr[idx] = tmp;
					cnt2++;
				}

			}
			boolean flag=true;
			for(int i=0;i<n-1;i++) {
				if(arr[i]==arr[i+1])flag=false;
			}
			while(n!=1&& flag&&cnt2<cnt) {
				int tmp=arr[n-1];
				arr[n-1]=arr[n-2];
				arr[n-2]=tmp;
				cnt2++;

			}
			sb.append("#").append(t).append(" ");
			for (int i : arr) {
				sb.append(i);
			}
//			sb.append(maxNum).append(" ").append(max);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
