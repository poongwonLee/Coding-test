import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dp[][] = new int[31][31];
        dp[0][0] = 1;
        for (int i = 1; i <= 30; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        int T=Integer.parseInt(br.readLine());
        while(T--!=0) {
        	st= new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());;
        	System.out.println(dp[m][n]);
        }
      
	}
}