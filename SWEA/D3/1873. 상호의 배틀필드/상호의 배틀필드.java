import java.util.*;
import java.io.*;
class Solution {
	public static int []dx= {-1,0,1,0};
	public static int []dy= {0,1,0,-1};
 	public static HashMap<String, Integer> hm= new HashMap<>(); 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		hm.put("S", 4);hm.put("U", 0);hm.put("D", 2);hm.put("L", 3);hm.put("R", 1);
		hm.put("^", 0);hm.put("v", 2);hm.put("<", 3);hm.put(">", 1);
		String []ch= {"^",">","v","<"};
		
		int testcase= Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());

			int idx=0;
			int x = 0,y=0;
			String[][] arr = new String[n][m];
			for(int i=0;i<n;i++){
				String []str=br.readLine().split("");
				for(int j=0;j<m;j++) {
					arr[i][j]=str[j];
					if(hm.get(arr[i][j])!=null) {
						idx=hm.get(arr[i][j]);
						x=i;y=j;
					}
				}
			}
			br.readLine();
			String []op=br.readLine().split("");
			for (String o: op) {
				if(hm.get(o)==4) {
					int xx=x;
					int yy=y;
					while( 0<=(xx+dx[idx]) && (xx+dx[idx])<n && 0<=(yy+dy[idx]) && (yy+dy[idx])<m&& !arr[xx+dx[idx]][yy+dy[idx]].equals("#") ) {
						xx+=dx[idx];
						yy+=dy[idx];
						if(arr[xx][yy].equals("*")) {
							arr[xx][yy]=".";
							break;
						}
					}
				}else {
					idx=hm.get(o);							
					if(0<=x+dx[idx]&& x+dx[idx]<n && 0<=y+dy[idx] && y+dy[idx]<m && arr[x+dx[idx]][y+dy[idx]].equals(".")) {
						arr[x][y]=".";
						x+=dx[idx];
						y+=dy[idx];
					}
				}
			}
			arr[x][y]=ch[idx];
			System.out.printf("#%d ",test);
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) 
					System.out.print(arr[i][j]);
				System.out.println();
			}
		}
	}
}
