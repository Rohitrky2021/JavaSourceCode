
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;
    
    public class CollectingOneInMinTime {
        static final int nn = 20;
        static int ans;
        static int n, m;
        static int[] l = new int[nn];
        static int[] r = new int[nn];
        static String[] s = new String[nn];
    
        public static void bitmask(boolean tight, int pos, int val) {
            if (pos == n - 1) {
                if (tight)
                    ans = Math.min(ans, val + r[pos]);
                else
                    ans = Math.min(ans, val + l[pos]);
                return;
            }
    
            if (tight) {
                bitmask(false, pos + 1, val + m + 2);
                bitmask(true, pos + 1, val + 2 * r[pos] + 1);
            } else {
                bitmask(false, pos + 1, val + 2 * l[pos] + 1);
                bitmask(true, pos + 1, val + m + 2);
            }
        }
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
    
            for (int i = n - 1; i >= 0; i++) {
                s[i] = br.readLine();
            }
    
            int tmp = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (s[i].charAt(j) == '1')
                        l[i] = Math.max(j, l[i]);
                    if (s[i].charAt(m + 1 - j) == '1')
                        r[i] = Math.max(r[i], j);
                }
                if (l[i] != 0)
                    tmp = i;
            }
            n = tmp + 1;
    
            if (n == 0) {
                System.out.println(0);
                return;
            }
            if (n == 1) {
                System.out.println(l[0]);
                return;
            }
            ans = Integer.MAX_VALUE;
            bitmask(false, 1, 2 * l[0] + 1);
            bitmask(true, 1, m + 2);
            System.out.println(ans);
        }
    }
    
