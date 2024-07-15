package Subsequence_DP;

public class Partition_Sum_Min_diff {

    //***   THIS QUESTION FOLLOW UP QUESTION OF ( SUB-SET SUM EQUAL K ) */

    //Question --- Array partition with minimum difference

    //your task-is to-partition-this-array-into-two-subsets-such-that-the-absolute-difference-between-subset-sums-is-minimum


    //SIMILAR QUESTION -- 1) Minimum sum partition , 2)Array partition with minimum difference
    
    // THIS FUNCTION OF SUB-SET EQUAL TO K (MEMORIZATION METHOD)
    public static boolean subsetSumToK(int n, int k, int arr[], boolean dp[][]) {

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

    public static void main(String[] args) {

        int arr[] = { 3,9,7,3 };
        int n = arr.length;

        //TOTAL SUM 
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int ans = Integer.MAX_VALUE;

        boolean dp[][] = new boolean[n][sum + 1];

        subsetSumToK(n, sum, arr, dp);

        //HERE THIS EXTRA WORK CHECK HOW MANY SUM IS PARTITION THESE ARE S1 AND THEN GET S2 AND THEN CALCULATE DIFFERENCE 
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n - 1][i]) {
                int s1 = i;
                int s2 = sum - s1;
                int t = Math.abs(s1 - s2);

                ans = Math.min(t, ans);

            }
        }

        System.out.println(ans);
    }
}
