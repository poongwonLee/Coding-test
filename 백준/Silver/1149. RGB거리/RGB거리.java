import java.util.*;

class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int [][]arr=new int[3][3];

		
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) 
				arr[1][j]=sc.nextInt();
			arr[0][0]=Math.min(arr[2][1], arr[2][2]);
			arr[0][1]=Math.min(arr[2][0], arr[2][2]);
			arr[0][2]=Math.min(arr[2][0], arr[2][1]);
			
			for(int j=0;j<3;j++) 
				arr[2][j]=arr[1][j]+arr[0][j];
			
		}
		System.out.println(Arrays.stream(arr[2]).min().getAsInt());
	
		
	}
}