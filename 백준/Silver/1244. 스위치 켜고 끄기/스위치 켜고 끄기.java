import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //n
		int[] arr = new int[n + 1];  				//n+1 배열 할당 인덱스 접근 편리 n+1
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) 				//배열 초기값 입력
			arr[i] = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		while (m-- != 0) {							//m번 반복
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a==1) { 
				for(int i=b;i<=n;i+=b) 			//a가 1일경우 남학생 >> b배수 스위치 온오프 전환
					arr[i]= 1^arr[i];
			}else {
				int idx=0;
				while(1<=(b-idx) && (b+idx)<=n && arr[b-idx]==arr[b+idx] ) {
					arr[b-idx]=1^arr[b-idx];
					arr[b+idx]=arr[b-idx++];
				}
			}
		}
		for(int i=1;i<=n;i++) {
			sb.append(arr[i]).append(" ");
			if (i%20==0)sb.append("\n");
		}
		System.out.println(sb);
	}
}
