import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		while (n-- != 0)
			hm.put(br.readLine(), 1);
		int cnt = 0;
		while (m-- != 0) {
			String key = br.readLine();
			if (hm.get(key) != null)
				cnt++;
		}

		System.out.println(cnt);

	}
}