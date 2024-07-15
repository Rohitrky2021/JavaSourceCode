// given two strings s1 and s2 we have to return the longest common subsequence of both string
// brute force approch will be like find all subsequence of s1 then s2 and compare so it will
// be too long bcoz 2^n is the possible subsequences so in this approach we use two indexes 
// idx1 and idx2 for s1 and s2, compare both characters if matched then call fir idx1-1 and idex2-1
// if not matched then we have two options either we can go with idx1-1 and idx2 same or idx1 same and 
// idx2-1 so return max of both
// whenever any index become negetive return 0

public class Q25_Longest_common_subsequence {

    public static int f(int idx1, int idx2, String s1, String s2) {

        if (idx1 < 0 || idx2 < 0)
            return 0;

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + f(idx1 - 1, idx2 - 1, s1, s2);
        }

        return Math.max(f(idx1 - 1, idx2, s1, s2), f(idx1, idx2 - 1, s1, s2));

    }

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int n = s1.length();
        int m = s2.length();

        // recursion
        // System.out.println(f(n-1, m-1, s1, s2));

        // memoization
        // Integer[][] dp = new Integer[n][m];
        // System.out.println(f2(n-1, m-1, s1, s2, dp));
        // in base case we are dealing with negetive indexes that may be little tough
        // here in tabulation
        // so do shifting of array
        // create dp[n+1][m+1] assume ith index as i-1 and jth as j-1
        // Integer[][] dp = new Integer[n+1][m+1];
        // System.out.println(f3(n, m, s1, s2, dp));

        // tabulation
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
    
        System.out.println(dp[n][m]);

        // space optimization can also be done using prev[] and curr[]

    }

    public static int f3(int idx1, int idx2, String s1, String s2, Integer[][] dp) {

        if (idx1 == 0 || idx2 == 0)
            return 0;

        if (dp[idx1][idx2] != null)
            return dp[idx1][idx2];

        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + f3(idx1 - 1, idx2 - 1, s1, s2, dp);
        }

        return dp[idx1][idx2] = Math.max(f3(idx1 - 1, idx2, s1, s2, dp), f3(idx1, idx2 - 1, s1, s2, dp));

    }

    public static int f2(int idx1, int idx2, String s1, String s2, Integer[][] dp) {

        if (idx1 < 0 || idx2 < 0)
            return 0;

        if (dp[idx1][idx2] != null)
            return dp[idx1][idx2];

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + f2(idx1 - 1, idx2 - 1, s1, s2, dp);
        }

        return dp[idx1][idx2] = Math.max(f2(idx1 - 1, idx2, s1, s2, dp), f2(idx1, idx2 - 1, s1, s2, dp));

    }

}
