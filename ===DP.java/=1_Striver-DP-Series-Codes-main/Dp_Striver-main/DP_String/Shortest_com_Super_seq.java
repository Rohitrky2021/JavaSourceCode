package DP_String;

public class Shortest_com_Super_seq {

    // Question --- Shortes Common Super-Sequence
    // Foloow Up - LCS

    public static String shortestSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        // //--------------Tabulation--------------(lowest common sub - sequence)
        for (int i1 = 1; i1 <= n; i1++) {

            for (int i2 = 1; i2 <= m; i2++) {

                // Matching
                int match = 0;
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    match = 1;
                    if (i1 - 1 >= 0 && i2 - 1 >= 0) {
                        match = 1 + dp[i1 - 1][i2 - 1];
                    }

                    dp[i1][i2] = match;
                } else {

                    // Not Matching
                    int one = 0;
                    int two = 0;
                    if (i1 - 1 >= 0 && i2 - 1 >= 0) {
                        one = 0 + dp[i1 - 1][i2];
                        two = 0 + dp[i1][i2 - 1];
                    }

                    int max = Math.max(one, two);

                    dp[i1][i2] = max;
                }

            }
        }

        // Add here extra work
        StringBuffer a = new StringBuffer();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                a.append(s1.charAt(i - 1));
                i--;
                j--;
            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {

                a.append(s1.charAt(i - 1));

                i--;
            } else {

                a.append(s2.charAt(j - 1));

                j--;
            }

        }

        while (i > 0) {
            a.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            a.append(s2.charAt(j - 1));
            j--;
        }

        return a.reverse().toString();

    }

    public static void main(String[] args) {

        String s1 = "brute";
        String s2 = "groot";

        System.out.println(shortestSupersequence(s1, s2));
    }
}
