import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] selected;
	static StringBuilder sb= new StringBuilder();
	static int[] ch;
	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M + 1];
		ch=new int[N+1];
	}

	static void rec_func(int k) {
		if (M + 1 == k) {
			for (int i = 1; i <= M; i++)
				sb.append(selected[i]+" ");
			sb.append("\n");
		} else {
			for (int i = selected[k-1]+1; i <= N; i++) {
					selected[k] = i;
					rec_func(k + 1);
				
				
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());

	}

}