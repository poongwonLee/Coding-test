import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static TreeMap<Integer, Integer> tm = new TreeMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] arr = Arrays.stream(str.split("\\+|-")).mapToInt(Integer::parseInt).toArray();
		int[] ch= new int[arr.length];
		
		int idx = 0;
		int idx2=arr.length-1;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='+') {
				arr[idx+1]+=arr[idx];
				ch[idx]=1;
				idx++;
			}
			else if (str.charAt(i)=='-') {
				idx++;
			}	
		}
		int res=0;
		boolean flag=true;
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]==0 && flag) {
				res=arr[i];
				flag=false;
			}
			else if(ch[i]==0) {
				res-=arr[i];
			}
		}
		System.out.println(res);

	}
}