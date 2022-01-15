import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int M = rd.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        long sum = 0;
        long max = 0;
        int maxCnt = 1;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = M; i < N; i++) {
            sum = sum - arr[i - M] + arr[i];
            if (max < sum) {
                max = sum;
                maxCnt=1;
            } else if (max == sum) {
                maxCnt++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max + "\n" + maxCnt);
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
