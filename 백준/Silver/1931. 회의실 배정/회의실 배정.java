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
		Collections.sort(list, (o1, o2) -> (o2.x - o1.x ==0 ? o2.y -o1.y : o2.x - o1.x));
		int last = list.get(0).x;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (last >= list.get(i).y) {
				last = list.get(i).x;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}