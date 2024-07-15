import java.io.*;
import java.util.*;

public class E {

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

    static final int MOD = 998244353;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            solve(scanner);
        }
    }

    public static void solve(FastReader scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (k == 0) {
            System.out.println(1);
            return;
        }

        int ans = power(2, n - 1);
        ans = power(ans, k);
        System.out.println(ans);
    }

    public static int power(int a, int b) {
        int result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= a;
                result %= MOD;
            }
            a *= a;
            a %= MOD;
            b >>= 1;
        }
        return result;
    }
}
