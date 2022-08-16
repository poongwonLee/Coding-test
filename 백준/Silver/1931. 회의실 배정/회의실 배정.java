import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, (o1, o2) -> (o1.y - o2.y ==0 ? o1.x -o2.x : o1.y - o2.y));
		
		int last = list.get(0).y;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (last <= list.get(i).x) {
				last = list.get(i).y;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}