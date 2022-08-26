import java.util.*;
import java.awt.Point;
import java.io.*;

class Solution {

	
	static void rotate(ArrayList<Integer> list,int op) {
		if(op==1) {
			list.add(0,list.remove(list.size()-1));
		}
		else {
			list.add(list.remove(0));
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			sb.append("#").append(test).append(" ");
			
			int k= Integer.parseInt(br.readLine());
			
			//2 오 6 왼 0 위
			ArrayList<Integer> arr[]= new ArrayList[4];
			for(int i=0;i<4;i++) {
				arr[i]= new ArrayList<>();
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++)
					arr[i].add(Integer.parseInt(st.nextToken()));
			}
			while(k--!=0) {
				st= new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken())-1;
				int op=Integer.parseInt(st.nextToken());
				
				int op2=op;
				int op3=op;
				int tmp=arr[s].get(2);
				for(int i=s;i<3;i++) {
					
					if(tmp!=arr[i+1].get(6)) {
						tmp=arr[i+1].get(2);
						rotate(arr[i+1],op*-1);
						op*=-1;
					}
					else break;
				}
				
				tmp=arr[s].get(6);
				for(int i=s;i>=1;i--) {
					if(tmp!=arr[i-1].get(2)) {
						tmp=arr[i-1].get(6);
						rotate(arr[i-1],op2*-1);
						op2*=-1;
					}
					else break;
				}
				rotate(arr[s],op3);
				
			}
			
			int res=0;
			for(int i=0;i<4;i++) {
				if(arr[i].get(0)==1) {
					res+=(1<<i);
				}
			}
			sb.append(res);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}