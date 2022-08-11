import java.io.*;
import java.util.*;

public class Main {
	static int N, x, y, cnt;
	private static void dfs(int v, int xx, int yy) {
		if (v==1&&xx==x&&yy==y) {
			System.out.println(cnt);
			return;
		}

		if (xx <= x && x < xx + v && yy <= y && y < yy + v) {
			v /= 2;
			dfs(v, xx, yy);
			dfs(v, xx, yy + v);
			dfs(v, xx + v, yy);
			dfs(v, xx + v, yy + v);
		} else
			cnt += v * v;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N);

		dfs(N, 0, 0);

	}
}