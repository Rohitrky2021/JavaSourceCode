package DP_String;

public class Long_Com_seq_print {

    
    //Question -- **Print Longest  Common sub-seqence String ****
    //Follow up question by  Longest  Common sub-seqence

    // Tabulation (Tc -0(M*N) Sc - 0(N*M))
    public static String lcs(String s1, String s2) {
       
       
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        // //--------------Tabulation--------------
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
                    // max = Math.max(match,max);
                    dp[i1][i2] = max;
                }

            }
        }


        // For print LCS use 2D DP table here DP table create by Tabulation also created by memorization */
        // //*************FOR PRINT LCS string (FOLLOW UP QUESTION) ****
        int lcs = dp[n][m];
        StringBuffer st = new StringBuffer();

        int i = n;
        int j = m;
        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                st.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println(st.reverse());
        return st.reverse().toString();

    }

    public static void main(String[] args) {

    }
}
