package T19_Dynamic_Programming;

public class DP09_LCS {

    static int recursion(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n) == str2.charAt(m)) {
            return 1 + recursion(str1, str2, n - 1, m - 1);
        } else {
            int case1 = recursion(str1, str2, n - 1, m);
            int case2 = recursion(str1, str2, n, m - 1);
            return Math.max(case1, case2);
        }

    }

    static int memoization(String str1, String str2, int n, int m, int dp[][]) {

        if (n == 0 || m == 0) {
            dp[n][m] = 0;
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            dp[n][m] = 1 + memoization(str1, str2, n - 1, m - 1, dp);
            return dp[n][m];
        } else {
            int case1 = memoization(str1, str2, n - 1, m, dp);
            int case2 = memoization(str1, str2, n, m - 1, dp);
            dp[n][m] = Math.max(case1, case2);
            return dp[n][m];
        }
    }

    static void printDP(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void tabulation(String str1, String str2, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        printDP(dp);
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        // int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // dp[i][j] = -1;
        // }
        // }

        // int ans = memoization(str1, str2, str1.length(), str2.length(), dp);
        // System.out.println(ans);
        // printDP(dp);
        tabulation(str1, str2, str1.length(), str2.length());

    }
}
