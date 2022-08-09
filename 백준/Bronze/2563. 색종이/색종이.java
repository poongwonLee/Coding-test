import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[102][102];
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		while(n--!=0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(arr[i][j]==0)cnt++;
					arr[i][j]=1;
				}
			}
		}
		System.out.println(cnt);
	}
}