
import java.util.*;
import java.io.*;

class Main {

	static int N, d, k, c;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[] flag = new int[3001];
		int cnt = 0;
		int max = 0;
		int tmp = 0;
		Queue<Integer> qTmp = new LinkedList<Integer>();
		while (( N-- >= 0 || !qTmp.isEmpty())) {
			if (N < 0) tmp = qTmp.poll();
			else {
				tmp = Integer.parseInt(br.readLine());
				if (qTmp.size() < k)
					qTmp.add(tmp);
			}
			q.add(tmp);
			if (flag[tmp] == 0) cnt++;
			flag[tmp]++;

			if (flag[c] == 0 && q.size() == k) max = Math.max(max, cnt + 1);
			max = Math.max(max, cnt);

			if (q.size() >= k) {
				tmp = q.peek();
				flag[tmp]--;
				if (flag[tmp] == 0) cnt--;
				q.poll();
			}

		}
		System.out.println(max);

	}


}
