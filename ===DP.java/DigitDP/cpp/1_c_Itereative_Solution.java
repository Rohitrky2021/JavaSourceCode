import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Input sc = new Input();
        int t = sc.nextInt();
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long leftCount = solve(l - 1 + "");
            long rightCount = solve(r + "");
            System.out.println(rightCount - leftCount);
        }

        sc.close();
    }

    static long solve(String s) {
        int[][][] dp = new int[20][2][20];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        for (int idx = s.length() - 1; idx >= 0; idx--) {
            int nonZeroDigit = 0;
            for (int flag = 0; flag <= 1; flag++) {
                long limit = (flag == 1) ? (s.charAt(idx) - '0') : 9L;
                for (int i = 0; i <= limit; i++) {
                    int t = flag;
                    int ans = 0;
                    int temp = (i != 0) ? nonZeroDigit + 1 : nonZeroDigit;
                    if (temp <= 3) {
                        ans += (idx == s.length() - 1) ? 1 : dp[idx + 1][t][temp];
                    }
                    dp[idx][flag][nonZeroDigit] += ans;
                }
                nonZeroDigit++;
            }
        }
        return dp[0][1][0];
    }

    static class Input {
        BufferedReader br;
        StringTokenizer st;

        Input() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Input(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }

        void close() throws IOException {
            br.close();
        }
    }
}
