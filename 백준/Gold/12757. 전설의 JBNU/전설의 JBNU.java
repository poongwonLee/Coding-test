import java.io.*;
import java.util.*;

public class Main {
	static TreeMap<Integer, Integer> tm = new TreeMap<>();
	static int k;

	static int getKey(int key) {

		Integer l = tm.lowerKey(key);
		Integer r = tm.higherKey(key);
		int res = key;
		if (l == null && r == null)
			return res;
		else if (l == null )
			res = r;
		else if (r == null )
			res = l;
		else if ((key - l == r - key) && key - l <= k)
			return -2; // 두개이상
		else
			res= key - l > r - key ?  r :l;

		return Math.abs(res - key) > k ? -1 : res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		while (n-- != 0) {
			st = new StringTokenizer(br.readLine());
			tm.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		while (m-- != 0) {
			int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (num[0] == 1)
				tm.put(num[1], num[2]);
			else if (num[0] == 2) {
				if (tm.get(num[1]) != null)
					tm.put(num[1], num[2]);
				else {
					int tmp = getKey(num[1]);
					if (tmp != -2 && tmp != -1)
						tm.put(tmp, num[2]);
				}
			} else {
				
				if(tm.get(num[1])!=null) 
					System.out.println(tm.get(num[1]));
				else {
					int tmp = getKey(num[1]);
					System.out.println(tmp == -1 ? -1 : tmp == -2 ? "?" : tm.get(tmp));
				}
			}

		}

	}
}