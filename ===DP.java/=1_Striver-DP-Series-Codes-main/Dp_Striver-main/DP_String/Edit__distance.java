package DP_String;

public class Edit__distance {

    // Question --- Edit Distance
    // Follow up --- String Matching

    // Memorization ---(Tc - 0(i*j) ,Sc - 0(i*j)+0(i*j))
    public static int rec(int i, int j, String s1, String s2, int dp[][]) {

        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        // Not Match

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int match = 0;
        if (s1.charAt(i) != s2.charAt(j)) {

            int replace = 1 + rec(i - 1, j - 1, s1, s2, dp);
            int remove = 1 + rec(i - 1, j, s1, s2, dp);
            int insert = 1 + rec(i, j - 1, s1, s2, dp);
            match = Math.min(replace, Math.min(remove, insert));
            dp[i][j] = match;
            return match;
        }

        // Match
        int nonmatch = rec(i - 1, j - 1, s1, s2, dp);
        dp[i][j] = nonmatch;
        return nonmatch;
    }

    // Tabulation -----(Tc - 0(i*j) ,Sc - 0(i*j))
    public static int editDistance(String str, String sub) {

        int n = str.length();
        int m = sub.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (str.charAt(i - 1) != sub.charAt(j - 1)) {

                    int rep = 1 + dp[i - 1][j - 1];
                    int rem = 1 + dp[i - 1][j];
                    int insert = 1 + dp[i][j - 1];
                    int match = Math.min(rep, Math.min(rem, insert));
                    dp[i][j] = match;

                } else {
                    // Match
                    int nonmatch = dp[i - 1][j - 1];
                    dp[i][j] = nonmatch;
                }
            }
        }

        return dp[n][m];

    }

    // Space Optimization ---- (Tc - 0(i*j) ,Sc - 0(j))
    public static int space(String str, String sub) {

        // Your code goes here
        int n = str.length();
        int m = sub.length();
        int dp[] = new int[m + 1];

        for (int j = 1; j <= m; j++) {
            dp[j] = j;
        }
       

        for (int i = 1; i <= n; i++) {
            int curr[] = new int[m + 1];
            curr[0] = i;

            for (int j = 1; j <= m; j++) {

                if (str.charAt(i - 1) != sub.charAt(j - 1)) {

                    int rep = 1 + dp[j - 1];
                    int rem = 1 + dp[j];
                    int insert = 1 + curr[j - 1];
                    int match = Math.min(rep, Math.min(rem, insert));
                    curr[j] = match;

                } else {
                    // Match
                    int nonmatch = dp[j - 1];
                    curr[j] = nonmatch;
                }
            }

            dp = curr;
        }

        return dp[m];
    }

    public static void main(String[] args) {

    }
}
