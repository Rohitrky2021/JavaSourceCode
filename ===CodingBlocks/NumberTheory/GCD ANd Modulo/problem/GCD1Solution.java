
    import java.util.*;

    public class GCD1Solution {
        static final int mxN = 100001;
        static final int mxA = 1000001;
        static List<Integer>[] p = new ArrayList[mxA + 1];
    
        @SuppressWarnings
        public static void main(String[] args) throws java.lang.Exception {
            for (int i = 0; i <= mxA; i++) {
                p[i] = new ArrayList<>();
            }
    
            for (int i = 2; i < mxA; i++) {
                if (!p[i].isEmpty()) {
                    continue;
                }
                for (int j = i; j < mxA; j += i) {
                    p[j].add(i);
                }
            }
    
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int ans = 0;
    
            int[] a = new int[n];
            int[] b = new int[m];
    
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
    
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }
    
            Map<Integer, Integer> ca = get(a);
            Map<Integer, Integer> cb = get(b);
    
            for (int i = 2; i < mxA; i++) {
                ans += ca.getOrDefault(i,0) * cb.getOrDefault(i,0) * ((p[i].size() & 1) == 1 ? 1 : -1);
            }
    
            System.out.println(ans);
        }
    
        static Map<Integer, Integer> get(int[] e) {
            Map<Integer, Integer> c = new HashMap<>();
            for (int x : e) {
                int m = p[x].size();
                for (int j = 0; j < (1 << m); j++) {
                    int k = 0;
                    int j1 = j;
                    int pd = 1;
                    while (j1 > 0) {
                        if ((j1 & 1) == 1) {
                            pd *= p[x].get(k);
                        }
                        j1 >>= 1;
                        k++;
                    }
                    c.put(pd, c.getOrDefault(pd, 0) + 1);
                }
            }
            return c;
        }
    }
    
