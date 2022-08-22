import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static String[] str;
	static int[] select,visit;
	static StringBuilder sb= new StringBuilder();
	static void dfs(int v,int idx,int ja,int mo) {
		
		if (v == m&&mo>=1 && ja>=2) {
			for (int i = 0; i < m; i++) 
				sb.append(str[select[i]]);
			sb.append("\n");
			return;
		}
		if(v==m) return;
		for (int i = idx ; i < n; i++) {
			if (visit[i] == 0) {
				visit[i]=1;
				select[v] = i;
				if(str[i].equals("a") ||str[i].equals("e") ||str[i].equals("i") ||
						str[i].equals("o") ||str[i].equals("u") )
					dfs(v + 1,i+1,ja,mo+1);
				else
					dfs(v + 1,i+1,ja+1,mo);
				visit[i]=0;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		visit= new int[n];
		select= new int[m];
		
		str = br.readLine().split(" ");
		Arrays.sort(str);
		dfs(0,0,0,0);
		System.out.println(sb);

	}
}