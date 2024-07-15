
    import java.io.*;
    import java.util.*;
    
    public class dsu2 {
        static class TaskA {
            static long mod = (long) 998244353;
    
            public void solve(int testNumber, InputReader in, PrintWriter out) {
                int t = 1;
                t = in.nextInt();
                while (t-- > 0) {
                    int n = in.nextInt();
                    int[] v = new int[51];
                    Queue<Integer>[] vt = new Queue[51];
                    Queue<Integer>[] q = new Queue[51];
                    for (int i = 0; i < 51; i++) {
                        vt[i] = new ArrayDeque<>();
                    }
                    for (int i = 0; i < n; i++) {
                        q[i] = new ArrayDeque<>();
                        int x = in.nextInt();
                        for (int j = 0; j < x; j++) {
                            int a = in.nextInt();
                            q[i].add(a);
                            v[a]++;
                            vt[a].add(i);
                        }
                    }
                    int x = 0;
                    for (int i = 0; i <= 50; i++) {
                        if (v[i] > 0)
                            x++;
                    }
                    int sum = x;
                    for (int i = 1; i <= 50; i++) {
                        if (v[i] > 0) {
                            int[] c = new int[51];
                            for (Integer integer : vt[i]) {
                                for (Integer i1 : q[integer]) {
                                    c[i1]++;
                                }
                            }
                            int cnt = 0;
                            for (int j = 0; j <= 50; j++) {
                                if (c[j] > 0) {
                                    if (c[j] == v[j])
                                        cnt++;
                                }
                            }
                            x = Math.min(x, cnt);
                        }
                    }
                    System.out.println(sum - x);
                }
            }
        }
    
        public static void main(String[] args) {
            TaskA task = new TaskA();
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            task.solve(1, in, out);
            out.close();
        }
    
        static class InputReader {
            BufferedReader br;
            StringTokenizer st;
    
            public InputReader(InputStream is) {
                br = new BufferedReader(new InputStreamReader(is));
                st = null;
            }
    
            public String next() {
                while (st == null || !st.hasMoreTokens()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return st.nextToken();
            }
    
            public int nextInt() {
                return Integer.parseInt(next());
            }
        }
    }
    