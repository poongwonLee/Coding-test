import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		int [][]stack= new int[n+1][2];
		int top=0;
		//[0] 높이 [1] 인덱스
		for(int i=1;i<=n;i++) {
			int num=Integer.parseInt(st.nextToken());
			while(top>0 && num>stack[top][0]) {
				top--;
			}
			
			if(top==0) {
				stack[++top][0]=num;
				stack[top][1]=i;
				sb.append(0).append(" ");
			}else {
				stack[++top][0]=num;
				stack[top][1]=i;
				sb.append(stack[top-1][1]).append(" ");
			}
			
		}
		System.out.println(sb);
		
		
	}
}