import java.io.*;
import java.util.*;

public class Main {
	static boolean []isPrime= new boolean[1000];
	static int n;
	public static boolean isPrime(int num) {
		if(num<2) return false;
		for(int i=2;i<=Math.sqrt(num);i++) 
			if(num%i==0)return false;
		return true;
	}
	public static void func(int v,int sum) {
		if(v==n) {
			System.out.println(sum);
			return;
		}
		for(int i=1;i<=9;i++) {
			if(isPrime(sum*10+i))
				func(v+1,sum*10+i);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		func(0,0);
	}
}