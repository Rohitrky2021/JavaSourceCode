 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class makeSubSequence_Diff_from_LCS {

    public static void main(String[] args) {
        new makeSubSequence_Diff_from_LCS().run();
    }

    private void run() {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc, out);
        }
        out.close();
    }

    private void solve(FastReader sc, PrintWriter out) {
        String a = sc.next();
        String b = sc.next();

        int result = Integer.MAX_VALUE;
        int sum = a.length() + b.length();

        for (int i = 0; i < b.length(); ++i) {
            int common = getCommon(a, b, i);   // Check from the Each start is it the substring 
            result = Math.min(result, sum - common);
        }

        out.println(result);
    }

    private int getCommon(String a, String b, int bIdx) {
        int count = 0;

        for (char c : a.toCharArray()) {
            if (bIdx < b.length() && b.charAt(bIdx) == c) {
                ++bIdx;
                ++count;
            }
        }

        return count;
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
