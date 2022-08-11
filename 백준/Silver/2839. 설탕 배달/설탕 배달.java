import java.io.*;
import java.util.*;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		if(N<5) {
			System.out.println(N==3?1:-1);
			return;
		}
		int[] arr = new int[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = Integer.MAX_VALUE/2;
		arr[3] = arr[5] = 1;
		for (int i = 6; i <=N; i++)
			arr[i] = Math.min(arr[i - 3] + 1, arr[i - 5] + 1);

		System.out.println(arr[N]>=Integer.MAX_VALUE/2 ? -1:arr[N]);
	}
}