public class Q50_Evaluate_boolean_expression_to_true {
    // static int mod = 1000000007;
    static int mod = 1003;

    public static int f(int i, int j, String s, int isTrue, Integer[][][] dp) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if (dp[i][j][isTrue] != null)
            return dp[i][j][isTrue];

        int ways = 0;

        for (int idx = i + 1; idx <= j - 1; idx += 2) {
            int lt = f(i, idx - 1, s, 1, dp);
            int lf = f(i, idx - 1, s, 0, dp);
            int rt = f(idx + 1, j, s, 1, dp);
            int rf = f(idx + 1, j, s, 0, dp);

            if (s.charAt(idx) == '&') {
                if (isTrue == 1)
                    ways += (lt * rt) % mod;
                else
                    ways += (lf * rf) % mod + (lt * rf) % mod + (lf * rt) % mod;
            } else if (s.charAt(idx) == '|') {
                if (isTrue == 1)
                    ways += (lt * rt) % mod + (lt * rf) % mod + (lf * rt) % mod;
                else
                    ways += (lf * rf) % mod;
            } else {
                if (isTrue == 1)
                    ways += (lt * rf) % mod + (lf * rt) % mod;
                else
                    ways += (lt * rt) % mod + (lf * rf) % mod;
            }
        }

        return dp[i][j][isTrue] = ways;
    }

    public static void main(String[] args) {
        String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        int j = s.length();

        // recursion & memoization
        // Integer[][][] dp = new Integer[j][j][2];
        // System.out.println(f(0, j-1, s, 1, dp));

        // tabulation
        int[][][] dp = new int[j][j][2];

        for (int i = 0; i < j; i++) {
            dp[i][i][1] = s.charAt(i) == 'T' ? 1 : 0;
            dp[i][i][0] = s.charAt(i) == 'F' ? 1 : 0;
        }

        for (int i = j - 1; i >= 0; i--) {
            for (int jj = 0; jj <= j - 1; jj++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {

                    int ways = 0;

                    for (int idx = i + 1; idx <= jj - 1; idx += 2) {
                        int lt = dp[i][idx - 1][1];
                        int lf = dp[i][idx - 1][0];
                        int rt = dp[idx + 1][jj][1];
                        int rf = dp[idx + 1][jj][0];

                        if (s.charAt(idx) == '&') {
                            if (isTrue == 1)
                                ways += (lt * rt) % mod;
                            else
                                ways += (lf * rf) % mod + (lt * rf) % mod + (lf * rt) % mod;
                        } else if (s.charAt(idx) == '|') {
                            if (isTrue == 1)
                                ways += (lt * rt) % mod + (lt * rf) % mod + (lf * rt) % mod;
                            else
                                ways += (lf * rf) % mod;
                        } else {
                            if (isTrue == 1)
                                ways += (lt * rf) % mod + (lf * rt) % mod;
                            else
                                ways += (lt * rt) % mod + (lf * rf) % mod;
                        }
                    }

                    dp[i][jj][isTrue] = ways;

                }
            }
        }
        System.out.println(dp[0][j-1][1]); 
    }
}
