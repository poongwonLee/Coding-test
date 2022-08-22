import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] select, visit;
	static int[][] arr;
	static int cnt = 0,max=0;

	static void dfs(int v) {
		if (v == 3)
			v++;
		if (v == 9) {
			
			int i = 0;
			int outCnt = 0;
			int cur = 0;
			int NSum = 0;
			int[] ru = new int[9];
			while (i < N) {
				outCnt=0;
				ru = new int[9];
				while (outCnt != 3) {
					
					if(arr[i][select[cur]]==4) {
						for(int j=1;j<=3;j++) {
							NSum+=ru[j];
							ru[j]=0;
						}
						NSum+=1;
//						System.out.println(NSum);
					}
					else if (arr[i][select[cur]] == 0)
						outCnt++;
					else {
						for (int j = 6; j >= 0; j --) {
							if(j-arr[i][select[cur]] >=1) {
								ru[j]=ru[j-arr[i][select[cur]]];
								ru[j-arr[i][select[cur]]]=0;
							}
						}
						for(int j=4;j<=6;j++) {
							NSum+=ru[j];
							ru[j]=0;
						}
						ru[arr[i][select[cur]]]=1;

					}
					
					cur=(cur+1)%9;
//					System.out.println("outCnt"+" " +outCnt);
				}
				
				
				i++;
			}
//			System.out.println(NSum);
//			System.out.println(Arrays.toString(select));
			max=Math.max(max, NSum);
			return;
		}
		for (int i = 0; i < 8; i++) {
			int t = i+1;

			if (visit[t] == 0) {
				visit[t] = 1;

				select[v] = t;
				dfs(v + 1);
				visit[t] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N과 M 입력 맵의 크기
		arr = new int[N][9];
		visit = new int[9];
		select = new int[9];
		select[3] = 0;
		for (int i = 0; i < N; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dfs(0);
		System.out.println(max);
	}
}