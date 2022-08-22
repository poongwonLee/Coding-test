import java.io.*;
import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int[] maxCnt;
	static int[][] arr;

	static void fill_0(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = 0;
			}
		}
	}

	static void fill_1(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = 1;
			}
		}
	}

	static boolean check(int x, int y, int size) {

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void dfs(int x, int y, int s, int cnt) {
//		if(x>=9 && y>=9) {
//			return;
//		}
//		boolean flag = true;
//		for (int i = 0; flag&&i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
////				System.out.print(arr[i][j]+" ");
//				if (arr[i][j] == 1)
//					flag = false;
//			}
////			System.out.println();
//		}
//		if(cnt>=min) return;
////		System.out.println(x+" "+y);
////		System.out.println(cnt + " " + flag+" "+s+" "+maxCnt[s]);
//		
//		if (flag)
//			min = Math.min(min, cnt);
		boolean flag = true;
		for (;  x < 10; x++) {
			for (; y < 10; y++) {
				
				if (x == 9 && y == 9&&arr[x][y]==0)
					min = Math.min(min, cnt);
				if (arr[x][y] == 1) {
					flag = false;
					break;

				}
				
			}
			if(!flag) break;
			y=0;
		}
		
		
		for (int size = 5; size >= 1; size--) {
			if (maxCnt[size] <= 4 && x + size <= 10 && y + size <= 10) {
				if (check(x, y, size)) {
					fill_0(x, y, size);
					maxCnt[size]++;
					dfs(x, y , size, cnt + 1);
					fill_1(x, y, size);
					maxCnt[size]--;
				}

			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		maxCnt = new int[6];
		arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0, 0);
		boolean flag = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 1)
					flag = false;
			}
		}
		System.out.println(min==Integer.MAX_VALUE ? -1: min);

	}
}