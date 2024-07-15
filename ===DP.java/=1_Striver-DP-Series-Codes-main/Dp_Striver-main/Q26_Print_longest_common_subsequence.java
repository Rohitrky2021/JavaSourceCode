public class Q26_Print_longest_common_subsequence {

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int idx2 = 0; idx2 <= m; idx2++)
            dp[0][idx2] = 0;

        for (int idx1 = 0; idx1 <= n; idx1++)
            dp[idx1][0] = 0;

        for (int idx1 = 1; idx1 <= n; idx1++) {

            for (int idx2 = 1; idx2 <= m; idx2++) {

                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {

                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];

                }

                else {

                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);

                }

            }

        }

        // now dp[n][m] stores the length of longest common subsequence so create a
        // string ans
        // whose size will be dp[n][m] create a idx also which wil point to dp[n][m]
        // - 1
        // run a loop till idx1 and idx2 is greater than 0 bcoz 0 is our base case
        // and we are using
        // shift based indexing
        // if s1[idx1 - 1] == s2[idx2 - 1] that means here we added 1 into length and
        // called idx1-1
        // and idx2 -1 so print the idx1-1 char and decrese both
        // else check whose value is max (idx1-1, idx2) or (idx1, idx2-1) bcoz we
        // store max of both of
        // them so if idx1-1 is greater then make idx1 as idx1-1

        // int len = dp[n][m];
        String ans = "";
        int i = n, j = m;

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                ans = s1.charAt(i - 1) + ans;
                i--;
                j--;

            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {

                i--;

            }

            else {

                j--;

            }

        }

        System.out.println(ans);

    }
}
