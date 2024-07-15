import java.io.*;
import java.util.*;
import java.lang.*;

public class KQueriry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new Solver().solve(br, out);
        out.close();
    }

    static class Solver {
        final int MOD = 1000000007;
        final double EPS = 1e-9;

        int gcd(int a, int b) {
            return (b == 0) ? a : gcd(b, a % b);
        }

        int lcm(int a, int b) {
            return a * (b / gcd(a, b));
        }

        int mod_exp(int b, int p, int m) {
            int x = 1;
            while (p > 0) {
                if ((p & 1) == 1) x = (x * b) % m;
                b = (b * b) % m;
                p >>= 1;
            }
            return x;
        }

        int invFermat(int a, int p) {
            return mod_exp(a, p - 2, p);
        }

        int exp(int b, int p) {
            int x = 1;
            while (p > 0) {
                if ((p & 1) == 1) x = (x * b);
                b = (b * b);
                p >>= 1;
            }
            return x;
        }

        void solve(BufferedReader br, PrintWriter out) throws IOException {
            io = new InputReader(br);
            int n = io.nextInt();
            int[] a = new int[n];
            int sqrtn = (int) Math.sqrt(n);

            List<Integer>[] b = new ArrayList[(n + sqrtn - 1) / sqrtn];

            for (int i = 0; i < b.length; i++) {
                b[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
                b[i / sqrtn].add(a[i]);
            }

            int numBlocks = (int) Math.ceil((double) n / sqrtn);

            for (int i = 0; i < numBlocks; i++)
                Collections.sort(b[i]);

            int q = io.nextInt();
            int answer = 0;

            while (q-- > 0) {
                int l = io.nextInt() ^ answer;
                int r = io.nextInt() ^ answer;
                int x = io.nextInt() ^ answer;

                if (l < 1) l = 1;
                if (r > n) r = n;
                l--;
                r--;

                answer = 0;

                if (r >= l) {
                    int leftBlock = l / sqrtn;
                    int rightBlock = r / sqrtn;

                    if (leftBlock == rightBlock) {
                        for (int i = l; i <= r; i++) {
                            if (a[i] > x)
                                answer++;
                        }
                    } else {
                        if (l % sqrtn != 0) {
                            leftBlock++;
                        }

                        int i;
                        for (i = l; i < leftBlock * sqrtn; i++) {
                            if (a[i] > x)
                                answer++;
                        }

                        while (i + sqrtn - 1 <= r) {
                            int bb = i / sqrtn;
                            answer += b[bb].size() - upperBound(b[bb], x);
                            i += sqrtn;
                        }

                        while (i <= r) {
                            if (a[i] > x)
                                answer++;
                            i++;
                        }
                    }
                }

                out.println(answer);
            }
        }

        int upperBound(List<Integer> list, int x) {
            int low = 0, high = list.size();
            while (low < high) {
                int mid = (low + high) / 2;
                if (list.get(mid) <= x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    static InputReader io;

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(BufferedReader reader) {
            this.reader = reader;
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
