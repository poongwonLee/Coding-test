import java.io.*;
import java.util.*;
 
 
class Solution {
     
    public static String []arr;
    public static boolean flag;
    public static void dfs(int v,int n) {
        if (v*2+1>n)return;
        dfs(v*2,n);
        dfs(v*2+1,n);
         
        if(v/2==0) return;
        if(!Character.isDigit(arr[v*2].charAt(0)) && !Character.isDigit(arr[v*2+1].charAt(0))) flag=false;
        arr[v]="1";
 
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int testCase = 10;
        for (int t = 1; t <= testCase; t++) {
            flag=true;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
             
            arr= new String[n+1];
            for (int i = 1; i <= n; i++) {
                String []str= br.readLine().split(" ");
                arr[i]=str[1];
            }
            dfs(1,n);
            sb.append("#").append(t).append(" ");
            sb.append(flag ? 1:0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}