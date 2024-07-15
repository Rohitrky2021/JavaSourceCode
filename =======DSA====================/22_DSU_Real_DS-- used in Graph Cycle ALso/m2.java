public class m2 {
    import java.util.*;

    public class math93 {
        static Scanner sc = new Scanner(System.in);
        static Set<Integer> set = new HashSet<>();
    
        static int gcd(int a, int b) {
            // Everything divides 0
            if (a == 0)
                return b;
    
            // a is greater
    
            return gcd(b % a, a);
        }
    
        public static void solve() {
            int n = sc.nextInt();
            int arr[][] = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int mat[][] = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][arr[i][j]] = arr[(i + 1) % 2][j];
                }
            }
            long ans = 0;
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                int turn = 0;
                int val = arr[0][i];
                if (set.contains(val))
                    continue;
                while (!set.contains(val)) {
                    set.add(val);
                    val = mat[turn][val];
                    // turn++;
                    // turn = turn % 2;
                }
                ans++;
            }
            
            long an = 1;
            for (int i = 0; i < ans; i++) {
                an = (an * 2) % (long) (1e9 + 7);
            }
            System.out.println(an);
        }
    
        public static void main(String[] args) {
            int t = sc.nextInt();
            // call();
            // System.out.println((3 | 5 | 6 | 2) ^ 15);
            while (t > 0) {
                t--;
                solve();
            }
            // sc.close();
    
        }
    }
    