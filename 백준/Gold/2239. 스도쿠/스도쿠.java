
import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
	static int N, M, cnt, max;
	static int[] select, dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] arr, visit;
	static ArrayList<Point> list = new ArrayList<>();

	static void dfs(int a,int b) {
		
		for(int i=a;i<9;i++) {
			for(int j=b;j<9;j++) {
				
				if(arr[i][j]==0) {
					for(int k=1;k<=9;k++) {
						if(isValid(i,j,k)) continue;
						arr[i][j]=k;
						dfs(i,j);
						arr[i][j]=0;
					}
					if(arr[i][j]==0) return;
				}
				if(i==8&&j==8) {
				for (int []is : arr) {
					for (int l : is) {
						System.out.print(l);
					}
					System.out.println();
 					
				}System.exit(0);
			}
				
			}
			b=0;
			
		}

	}

	
	 static boolean isValid(int x, int y, int val) {
	        for (int i = 0; i < 9; i++) {
	            if (arr[x][i] == val) return true;
	            if (arr[i][y] == val) return true;
	        }
	        x = x / 3 * 3;
	        y = y / 3 * 3;
	        for (int i = x; i < x + 3; i++) {
	            for (int j = y; j < y + 3; j++) {
	                if (arr[i][j] == val) return true;
	            }
	        }
	        return false;
	    }
	 
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
	
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			arr[i]=Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		select = new int[list.size()];
		dfs(0,0);
		for (int []is : arr) {
			System.out.println(Arrays.toString(is));
		}

	}
}
