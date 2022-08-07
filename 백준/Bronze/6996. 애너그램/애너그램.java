import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		while(n--!=0) {
			st= new StringTokenizer(br.readLine());
			
			String atmp= st.nextToken();
			String btmp= st.nextToken();
			String []a= atmp.split("");
			String []b= btmp.split("");
			Arrays.sort(a);
			Arrays.sort(b);
			boolean flag=a.length==b.length;
			for (int i = 0; flag &&i <a.length; i++) 
				if (!a[i].equals(b[i])) flag=false;
			
			if(flag&& a.length==b.length)
				System.out.printf("%s & %s are anagrams.\n",atmp,btmp);
			else
				System.out.printf("%s & %s are NOT anagrams.\n",atmp,btmp);

		}
	}
}
