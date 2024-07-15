import java.util.*;
import java.io.*;

public class e {
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

    public static void solve(int ttc, FastReader sc, PrintWriter out) {
        while (ttc-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Group elements based on their modulo k
            Map<Integer, Set<Integer>> mp = new HashMap<>();
            for (int x : a) {
                int mod = x % k;
                if (!mp.containsKey(mod)) {
                    mp.put(mod, new HashSet<>());
                }
                mp.get(mod).add(x);
            }

            // Calculate the number of operations needed
            int cnt = 0;
            long ans = 0;
            boolean multipleOdd = false;
            int val = -1;

            for (Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
                int rem = entry.getKey();
                int sz = entry.getValue().size();
                
                if (sz % 2 == 1) {
                    cnt++;
                    val = rem;
                }
                
                ans += (long) entry.getValue().size() / 2;
            }

            if (cnt > 1) {
                out.println("-1");
                continue;
            }

            if (cnt == 0) {
                out.println(ans * k);
                continue;
            }

            List<Integer> v = new ArrayList<>(mp.get(val));
            int m = v.size();
            if (m == 1) {
                out.println(ans * k);
                continue;
            }

            int[] pref = new int[m];
            int[] suf = new int[m];

            pref[1] = v.get(1) - v.get(0);
            for (int i = 2; i < m; i++) {
                pref[i] = v.get(i) - v.get(i - 1) + pref[i - 2];
            }

            suf[m - 2] = v.get(m - 1) - v.get(m - 2);
            for (int i = m - 3; i >= 0; i--) {
                suf[i] = v.get(i + 1) - v.get(i) + suf[i + 2];
            }

            long ta = Long.MAX_VALUE;
            for (int i = 0; i < m; i += 2) {
                int x = 0;
                if (i > 0) {
                    x += pref[i - 1];
                }
                if (i + 1 < m) {
                    x += suf[i + 1];
                }
                ta = Math.min(ta, x);
            }

            out.println(ans * k + ta);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int ttc = sc.nextInt();
        solve(ttc, sc, out);
        out.close();
    }
}
