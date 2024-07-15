package Subsequence_DP;

public class Sub_Set_Sum_equal_k {

    // Question ---- if any sub-set / sub-sequence is equal to target *******(VVIP)

    // Recursion --TC -0(2^N) , Sc-0(N)
    public static boolean rec(int i, int n, int k, int arr[]) {

        if (k == 0) {

            return true;
        }

        if (i == 0) {
            if (arr[i] == k) {

                return true;
            }

            return false;
        }

        boolean take = false;
        if (k >= arr[i]) {
            take = rec(i - 1, n, k - arr[i], arr);
        }

        boolean nontake = rec(i - 1, n, k, arr);

        if (take || nontake) {

            return true;
        }

        return false;
    }

    // Memorization --(TC--- 0(N*target) ,SC -0(N*target)+0(N))
    public static boolean DP(int i, int n, int k, int arr[], int dp[][]) {

        if (k == 0) {
            dp[i][k] = 1;
            return true;
        }

        if (i == 0) {
            if (arr[i] == k) {
                dp[i][k] = 1;
                return true;
            }
            dp[i][k] = 0;
            return false;
        }

        if (dp[i][k] != -1) {
            if (dp[i][k] == 0) {
                return false;
            }
            return true;
        }

        boolean take = false; // take
        if (k >= arr[i]) {
            take = DP(i - 1, n, k - arr[i], arr, dp);
        }

        boolean nontake = DP(i - 1, n, k, arr, dp); // non take

        // If anyone give true return true ****
        if (take || nontake) {
            dp[i][k] = 1;
            return true;
        }
        dp[i][k] = 0;
        return false;
    }

    // Tabulation ----(TC--- 0(N*target) ,SC -0(N*target) )
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean dp[][] = new boolean[n][k + 1];

        // ***********TABULATION****************

        // Base Case *
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Nested loop = how many parametter change
        for (int i = 1; i < n; i++) {

            for (int target = 1; target <= k; target++) {

                boolean take = false;
                if (target >= arr[i]) {
                    take = dp[i - 1][target - arr[i]];
                }

                boolean nontake = dp[i - 1][target];

                if (take || nontake) {
                    dp[i][target] = true;
                } else {
                    dp[i][target] = false;
                }
            }
        }

        return dp[n - 1][k];

    }

    // Space Optimization ----(TC--- 0(N*target) ,SC -0(target) )
    public static boolean Space(int n, int k, int arr[]) {
        boolean dp[] = new boolean[k + 1];

        // ***********TABULATION****************

        // Base Case *
        for (int i = 0; i < n; i++) {
            dp[0] = true;
        }

        if (arr[0] <= k) {
            dp[arr[0]] = true;
        }

        // Nested loop = how many parametter change
        for (int i = 1; i < n; i++) {
            boolean curr[] = new boolean[k + 1];
            for (int target = 1; target <= k; target++) {

                boolean take = false;
                if (target >= arr[i]) {
                    take = dp[target - arr[i]];
                }

                boolean nontake = dp[target];

                if (take || nontake) {
                    curr[target] = true;
                } else {
                    curr[target] = false;
                }
            }
            dp = curr;
        }

        return dp[k];

    }

    public static void main(String[] args) {
        int arr[] = { 1, 45, 6, 7, 9 };
        int target = 14;
        System.out.println(Space(arr.length, target, arr));
    }
}
