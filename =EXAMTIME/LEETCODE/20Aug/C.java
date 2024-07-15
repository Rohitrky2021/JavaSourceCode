import java.util.Vector;

class Solution {
    long inf = 1000000000L; // Specify as a long integer

    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        Vector<Vector<Integer>> dp = new Vector<Vector<Integer>>();

        // Initialize dp 2D vector with dimensions (n+1) x 3, filled with inf
        for (int i = 0; i <= n; i++) {
            Vector<Integer> row = new Vector<Integer>();
            for (int j = 0; j < 3; j++) {
                row.add((int) inf);
            }
            dp.add(row);
        }

        // Initialize dp[0][0] to 0
        dp.get(0).set(0, 0);

        for (int i = 1; i <= n; ++i) {
            if (s1.charAt(i - 1) == s2.charAt(i - 1)) {
                // Case where characters are equal
                dp.get(i).set(0, Math.min(dp.get(i).get(0), dp.get(i - 1).get(0)));
                dp.get(i).set(1, Math.min(dp.get(i).get(1), dp.get(i - 1).get(1)));
                dp.get(i).set(2, Math.min(dp.get(i).get(2), Math.min(dp.get(i - 1).get(1) + x, dp.get(i - 1).get(2) + 1)));
            } else {
                // Case where characters are not equal
                dp.get(i).set(0, Math.min(dp.get(i).get(0), Math.min(dp.get(i - 1).get(1) + x, dp.get(i - 1).get(2) + 1)));
                dp.get(i).set(1, Math.min(dp.get(i).get(1), dp.get(i - 1).get(0)));
                dp.get(i).set(2, Math.min(dp.get(i).get(2), dp.get(i - 1).get(0)));
            }

            for (int j = i - 1; j >= 1; j--) {
                if (s1.charAt(j - 1) != s2.charAt(j - 1)) {
                    dp.get(i).set(0, Math.min(dp.get(i).get(0), dp.get(j - 1).get(0) + i - j));
                    dp.get(i).set(1, Math.min(dp.get(i).get(1), dp.get(j - 1).get(1) + i - j));
                    break;
                }
            }
        }

        return dp.get(n).get(0) == (int) inf ? -1 : dp.get(n).get(0);
    }
}
