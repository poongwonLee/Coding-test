import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		int one = 0, two = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int l = i + 1, r = n - 1;
			int ans=n;
			while (l < r) {
				int mid=(l+r)/2;
				if( -arr[i] <= arr[mid]) {
					ans=mid;
					r=mid-1;
				}
				else
					l=mid+1;
			}
			if(ans!=n&& i < ans && min>Math.abs(arr[i]+arr[ans]) ) {
				min=Math.abs(arr[i]+arr[ans]);
				one=arr[i];two=arr[ans];
			}
			if(i< ans-1&& min>Math.abs(arr[i]+arr[ans-1]) ) {
				min=Math.abs(arr[i]+arr[ans-1]);
				one=arr[i];two=arr[ans-1];
			}
		}
		System.out.println(one+" "+two);
	}
}
