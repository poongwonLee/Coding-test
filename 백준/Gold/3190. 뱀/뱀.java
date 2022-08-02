import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int k = Integer.parseInt(br.readLine());
		Deque<Option> q = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Option(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		Deque<Point> dq = new ArrayDeque<>();
		HashMap<Point, Integer> hm = new HashMap<>();
		hm.put(new Point(1, 1), 1);
		dq.add(new Point(1, 1));
		int x = 1, y = 1;
		int cnt = 0;
		int idx = 1;
		while (!dq.isEmpty() ) {
			x = dq.peek().x;
			y = dq.peek().y;
			int xx=x+dx[idx];
			int yy=y+dy[idx];
			cnt++;
			if(!(1 <= xx && xx <= n && 1 <= yy && yy <= n&& hm.get(new Point(xx,yy))==null)) break;
			
			if(!q.isEmpty() &&q.peek().time==cnt) {
				if(q.peek().op.equals("D")) {
					idx=(idx+1)%4;
				}else {
					idx = (idx-1) < 0 ? 3:idx-1; 
				}
				q.pop();
			}
			dq.addFirst(new Point(xx,yy));
			hm.put(new Point(xx,yy),1);
		
			if(arr[xx][yy]!=1) {
				hm.remove(new Point(dq.peekLast()));
				dq.pollLast();
			}
			arr[xx][yy]=0;
			
		}
		System.out.println(cnt);
	}

	public static class Option {
		int time;
		String op;

		public Option(int time, String op) {
			super();
			this.time = time;
			this.op = op;
		}

	}
}
