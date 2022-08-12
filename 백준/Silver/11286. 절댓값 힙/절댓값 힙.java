import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n= Integer.parseInt(br.readLine());
		PriorityQueue< Integer>pq= new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				if(Math.abs(x)==Math.abs(y))return Integer.compare(x, y);
				return Integer.compare(Math.abs(x), Math.abs(y));
			}
		});
		while(n--!=0) {
			int tmp= Integer.parseInt(br.readLine());
			if(tmp==0)System.out.println(pq.isEmpty() ? 0: pq.poll());
			else pq.add(tmp);
		}
	}
}