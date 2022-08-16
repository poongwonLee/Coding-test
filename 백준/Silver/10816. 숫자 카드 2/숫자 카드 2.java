import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			if (hm.get(key) != null)
				hm.put(key, hm.get(key) + 1);
			else
				hm.put(key, 1);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			while (st.hasMoreTokens()) {
				int key = Integer.parseInt(st.nextToken());
				if (hm.get(key) != null)
					sb.append(hm.get(key)).append(" ");
				else
					sb.append(0).append(" ");
			}
		}
		System.out.println(sb);

	}
}