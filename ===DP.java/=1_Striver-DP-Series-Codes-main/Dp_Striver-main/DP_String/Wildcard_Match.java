package DP_String;

import java.util.Arrays;

public class Wildcard_Match {

    // Question --- Wild Card Matching
    // Follow up - String Match / Distinct sub-sequence

    // Memorization ----Tc-0(i*j) , Sc - 0(i*j)
    public static boolean DP(int i, int j, String s1, String s2, int dp[][]) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (i == 0) {
            return false;
        }

        if (j == 0) {
            for (int k = 1; k <= i; k++) {
                if (s1.charAt(k - 1) != '*') {
                    dp[i][j] = 0;
                    return false;
                }
            }

            dp[i][j] = 1;
            return true;
        }

        if (dp[i][j] != -1) {
            if (dp[i][j] == 1) {
                return true;
            }
            return false;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {

            boolean t = DP(i - 1, j - 1, s1, s2, dp);
            if (t) {
                dp[i][j] = 1;
                return true;
            }
            dp[i][j] = 0;
            return false;
        }

        if (s1.charAt(i - 1) == '*') {
            boolean non = DP(i - 1, j, s1, s2, dp);
            boolean rem = DP(i, j - 1, s1, s2, dp);
            if (non || rem) {
                dp[i][j] = 1;
                return true;
            }

        }

        dp[i][j] = 0;
        return false;

    }

    // Tabulation --- Tc-0(i*j) ,Sc-0(J)
    public static boolean wildcardMatching(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 1;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= i; k++) {
                if (s1.charAt(k - 1) != '*') {
                    dp[i][0] = 0;
                }
            }
            if (dp[i][0] == -1) {
                dp[i][0] = 1;
            }

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {

                    int t = dp[i - 1][j - 1];
                    if (t == 1) {
                        dp[i][j] = 1;

                    } else {
                        dp[i][j] = 0;
                    }

                } else if (s1.charAt(i - 1) == '*') {
                    int non = dp[i - 1][j];
                    int rem = dp[i][j - 1];
                    if (non == 1 || rem == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }

                } else {
                    dp[i][j] = 0;
                }

            }
        }

        if (dp[n][m] == 1) {
            return true;
        }
        return false;
    }

    // Space Optimization ----Tc-0(i*j) ,Sc-0(J)
    public static boolean space(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[] = new int[m + 1];

        for (int j = 1; j <= m; j++) {
            dp[j] = 0;
        }
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            int curr[] = new int[m + 1];
            Arrays.fill(curr, -1);
            for (int k = 1; k <= i; k++) {
                if (s1.charAt(k - 1) != '*') {
                    curr[0] = 0;

                }
            }

            if (curr[0] == -1) {
                curr[0] = 1;
            }

            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {

                    int t = dp[j - 1];
                    if (t == 1) {
                        curr[j] = 1;

                    } else {
                        curr[j] = 0;
                    }

                } else if (s1.charAt(i - 1) == '*') {
                    int non = dp[j];
                    int rem = curr[j - 1];
                    if (non == 1 || rem == 1) {
                        curr[j] = 1;
                    } else {
                        curr[j] = 0;
                    }

                } else {
                    curr[j] = 0;
                }

            }

            dp = curr;
        }

        if (dp[m] == 1) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

    }
}
