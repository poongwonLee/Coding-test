import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import javax.sound.midi.Soundbank;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> q= new LinkedList<>(); 
		
		st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) 
			q.add(i+1);
		
		System.out.print("<");
		
		while(q.size()!=1) {
			
			for (int i = 0; i < m-1; i++) 
				q.add(q.poll());
			
			System.out.print(q.poll()+", ");
		}
		
		System.out.println(q.poll()+">");
		
		
		
	}
}
