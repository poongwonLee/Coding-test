import java.io.*;
import java.util.*;

public class Main {
	static TreeMap<Integer, Integer> tm = new TreeMap<>();

	static int getDepth(int key) {

		Integer l = tm.lowerKey(key);
		Integer r = tm.higherKey(key);
		int res = key;
		if (l == null)
			res = tm.get(r);
		else if (r == null)
			res = tm.get(l);
		else
			res = tm.get(r) > tm.get(l) ? tm.get(r) : tm.get(l);
		return res + 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		sb.append(0).append("\n");
		int n = Integer.parseInt(st.nextToken()) - 1;
		long cnt = 0;
		
		tm.put(Integer.parseInt(br.readLine()), 0);
		while (n-- != 0) {
			int key = Integer.parseInt(br.readLine());
			int depth=getDepth(key);
			
			tm.put(key, depth);
			cnt+=depth;
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}