
    import java.util.Scanner;
    import java.util.Arrays;
    
    public class mod {
        static final int mod1 = (int)1e9 + 7;
    
        public static int find(int[] dp, int i, int n, int k) {
            if (i > n) return 0;
            if (dp[i] != -1) return dp[i];
            int sum = 0;
            for (int j = 1; j < k; j++) {
                if (i == 0) {
                    sum = (sum % mod1 + (find(dp, i + j, n, k) % mod1 * 26) % mod1) % mod1;
                } else {
                    sum = (sum % mod1 + (find(dp, i + j, n, k) % mod1 * 25) % mod1) % mod1;
                }
            }
            return dp[i] = sum % mod1;
        }
     
        public static void solve(int tc) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[n] = 1;
            System.out.println(find(dp, 0, n, k));
        }
    
        public static void main(String[] args) {
            int tc = 1; // You can change the number of test cases as needed
            solve(tc);
        }
            public static boolean isSorted(int[] arr) {
                int n = arr.length;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        return false;
                    }
                }
                return true;
            }
        
    }
    