import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        int[] arr = new int[N];
        ArrayList<Long> res = new ArrayList<>();
        long sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        int y = rd.nextInt();
        for (int i = 0; i < N; i++) {
            if (GCD(arr[i], y)) {
                sum += arr[i];
                cnt++;
            }
        }
        System.out.printf("%.6f", sum / (double) cnt);
    }


    public static boolean GCD(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        if (x == 1) return true;
        return false;
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
