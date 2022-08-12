import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static HashMap<String, String> write = new HashMap<>();
	static HashMap<String, String> writeRe = new HashMap<>();

	static HashMap<String, String> read = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str, r, w;
		while (!(str = br.readLine()).equals("EXIT")) {
			String[] tmp = str.split(" ");
			r = tmp[1];
			if (tmp[0].equals("WRITE")) {
				w = tmp[3];

				if (read.get(w)!=null ||writeRe.get(w) != null || writeRe.get(r) != null) {
					System.out.println("WAIT");
					write = new HashMap<>();
					read = new HashMap<>();
					writeRe = new HashMap<>();
				}
				if (write.get(w) != null  || writeRe.get(r) != null) {
					System.out.println("WAIT");
					write = new HashMap<>();
					read = new HashMap<>();
					writeRe = new HashMap<>();
				}

				write.put(r, w);
				writeRe.put(w, r);
			} else {
				if (writeRe.get(r) != null) { // 쓸려하는데 read가 되어있어 READ with Write
					System.out.println("WAIT");
					write = new HashMap<>();
					read = new HashMap<>();
					writeRe = new HashMap<>();
				}
				read.put(r, "-1");
			}
			System.out.println(str);
//			
		}
		System.out.println("EXIT");
	}
}