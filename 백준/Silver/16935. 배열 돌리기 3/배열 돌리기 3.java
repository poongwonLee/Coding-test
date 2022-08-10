import java.io.*;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int[][] arrCopy;
	public static int N, M;
	public static Stack<Integer> stack = new Stack<>();

	public static void copy() {
		arrCopy= new int[N+1][M+1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				arrCopy[i][j] = arr[i][j];
	}

	public static void func1() {
		for (int j = 1; j <= M; j++) {
			for (int i = 1; i <= N; i++)
				stack.add(arr[i][j]);
			for (int i = 1; i <= N; i++)
				arr[i][j] = stack.pop();
		}
	}

	public static void func2() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				stack.add(arr[i][j]);
			for (int j = 1; j <= M; j++)
				arr[i][j] = stack.pop();
		}
	}

	public static void func3() {
		copy();
		arr = new int[M + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				arr[j][N - i + 1] = arrCopy[i][j];
		}
		int tmp = N;
		N = M;
		M = tmp;
	}

	public static void func4() {
		copy();
		arr = new int[M + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				arr[M - j + 1][i] = arrCopy[i][j];
		}
		int tmp = N;
		N = M;
		M = tmp;
	}

	public static void func5() {
		copy();
		int x = N / 2, y = M / 2;
		for (int i = 1; i <= x; i++) 
			for (int j = 1; j <= y; j++)
				arr[i][y + j] = arrCopy[i][j];
		
		for (int i = 1 ; i <= x; i++) 
			for (int j = y+1; j <= M; j++)
				arr[x + i][j] = arrCopy[i][j];
		
		for (int i = x+1; i <= N; i++) {
			int idx=1;
			for (int j = y+1; j <= M; j++)
				arr[i][idx++] = arrCopy[i][j];
		}
		
		int idx=1;
		for (int i = x+1; i <= N; i++) {
			for (int j = 1; j <= y; j++)
				arr[idx][j] = arrCopy[i][j];
			idx++;
		}
	}
	
	public static void func6() {
		copy();
		int x = N / 2, y = M / 2;
		for (int i = 1; i <= x; i++) 
			for (int j = 1; j <= y; j++)
				arr[x+i][j] = arrCopy[i][j];
		
		for (int i = 1 ; i <= x; i++) {
			int idx=1;
			for (int j = y+1; j <= M; j++)
				arr[i][idx++] = arrCopy[i][j];
		}
		int idx=1;
		for (int i = x+1; i <= N; i++) {
			for (int j = y+1; j <= M; j++)
				arr[idx][j] = arrCopy[i][j];
			idx++;
		}
		
		for (int i = x+1; i <= N; i++) {
			for (int j = 1; j <= y; j++)
				arr[i][j+y] = arrCopy[i][j];
			idx++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		arrCopy = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (r-- != 0) {
			String op = st.nextToken();
			if (op.equals("1"))
				func1();
			if (op.equals("2"))
				func2();
			if (op.equals("3"))
				func3();
			if (op.equals("4"))
				func4();
			if (op.equals("5"))
				func5();
			if (op.equals("6"))
				func6();
			
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}