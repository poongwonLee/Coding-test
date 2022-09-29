import java.util.*;
class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int [][]arr=new int[2][3];
		for(int i=0;i<n;i++) {
			arr[0][0]=Math.min(arr[1][1], arr[1][2]);
			arr[0][1]=Math.min(arr[1][0], arr[1][2]);
			arr[0][2]=Math.min(arr[1][0], arr[1][1]);
			for(int j=0;j<3;j++) arr[1][j]=arr[0][j]+sc.nextInt();
		}
		System.out.println(Arrays.stream(arr[1]).min().getAsInt());
	}
}