
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
		
		int testcase= Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());

			int idx=0;
			int x = 0,y=0;
			char last='\0';
			char[][] arr = new char[n][m];
			for(int i=0;i<n;i++){
				String []str=br.readLine().split("");
				for(int j=0;j<m;j++) {
					arr[i][j]=str[j].charAt(0);
					if(arr[i][j]=='^') {
						idx=0;
						x=i;y=j;
						last='^';
					}
					else if(arr[i][j]=='v') {
						idx=2;
						x=i;y=j;
						last='v';
					}
					else if(arr[i][j]=='<') {
						idx=3;
						x=i;y=j;
						last='<';
					}
					else if(arr[i][j]=='>') {
						idx=1;	
						x=i;y=j;
						last='>';
					}
					
				}
			}
			
			int k= Integer.parseInt(br.readLine());
			String []op=br.readLine().split("");
			for (String o: op) {
				int f=hm.get(o);
				if(f==4) {
					int xx=x;
					int yy=y;
					while( 0<=(xx+dx[idx]) && (xx+dx[idx])<n && 0<=(yy+dy[idx]) && (yy+dy[idx])<m ) {
						xx+=dx[idx];
						yy+=dy[idx];
						if(arr[xx][yy]=='#')break;
						else if((arr[xx][yy]=='*')) {
							arr[xx][yy]='.';
							break;
						}
					}
				}else {
					idx=f;
					if(idx==0)last='^';
					else if(idx==1)last='>';
					else if(idx==2)last='v';
					else if(idx==3)last='<';
							
					if(0<=x+dx[idx]&& x+dx[idx]<n && 0<=y+dy[idx] && y+dy[idx]<m && arr[x+dx[idx]][y+dy[idx]]=='.') {
						arr[x][y]='.';
						x+=dx[idx];
						y+=dy[idx];
						arr[x][y]=last;
					}
				}
			}
			System.out.printf("#%d ",test);
			arr[x][y]=last;
		
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
