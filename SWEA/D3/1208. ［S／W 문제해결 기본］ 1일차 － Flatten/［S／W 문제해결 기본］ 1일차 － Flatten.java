import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int minIdx = 0;
			int maxIdx = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[minIdx] > arr[i]) {
					minIdx = i;
				}
				if (arr[maxIdx] < arr[i]) {
					maxIdx = i;
				}
			}
			
			while (n-- != 0 && (arr[maxIdx] - arr[minIdx]) > 1) {
				arr[maxIdx]--;
				arr[minIdx]++;
				for (int i = 0; i < 100; i++) {
					if (arr[minIdx] > arr[i]) {
						minIdx = i;
					}
					if (arr[maxIdx] < arr[i]) {
						maxIdx = i;
					}
				}
			}
			System.out.printf("#%d %d\n",test,arr[maxIdx] - arr[minIdx]);
		}
	}
}