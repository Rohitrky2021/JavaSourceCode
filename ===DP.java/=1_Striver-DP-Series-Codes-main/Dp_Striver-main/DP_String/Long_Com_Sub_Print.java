package DP_String;

public class Long_Com_Sub_Print {

    // Question --- Longest Common Sub-String Print
    // Follow Up - Longest Common Sub-Sequence Print


    
    // Tabulation ---- TC-0(N*M) ,SC-0(N*M)
    public static String lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;
        int row = 0;
        int col = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    int match = 1 + dp[i - 1][j - 1];
                    dp[i][j] = match;
                    // Every time calculate max
                    if (ans < match) {
                        row = i;
                        col = j;
                        ans = match;
                    }
                } else {
                    // In LCS here modify but here sub-string in continious manner so if not match 0
                    dp[i][j] = 0;
                }
            }
        }

        StringBuffer st = new StringBuffer();

        int i = row;
        int j = col;
        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                st.append(s1.charAt(i - 1));
                i--;
                j--;
            }

            if (dp[i][j] == 0) {
                break;
            }

        }

        return st.reverse().toString();
    }

    public static void main(String[] args) {

    }
}
