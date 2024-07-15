/*
We are given an array ‘ARR’ with N positive integers. We need to partition the array
into two subsets such that the absolute difference of the sum of elements of the subsets is minimum.

We need to return only the minimum absolute difference of the sum of elements of the two partitions.
 */

/*
THIS PROBLEM IS EXACTLY SIMILAR TO SUBSET SUM EQUAL TO TARGET.
TABULATION DP CAN TELL US IF A TARGET IS POSSIBLE IN ARRAY OR NOT.
SO WE ARE JUST GONNA FIND ONE SUBSET SUM BECAUSE SECOND SET SUM CAN BE ACHIEVED BY SUBTRACTING
FIRST SUBSET SUM FROM TOTAL SUM OF ARRAY.
NOW ITERATE THROUGH THE LAST ROW OF TABULATION DP TO FIND IF A TARGET IS PRESENT OR NOT.
 */

public class _16partitionSetWithMinAbsDiff {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        int sum = 0;
        for (int i : arr)
            sum += i;
        boolean[][] dp = new boolean[n][sum + 1];
        solve(arr, n, sum, dp);
        for (int target = 0; target <= sum / 2; target++) {
            if (dp[n - 1][target]) {
                int sec = sum - target;
                ans = Math.min(ans, Math.abs(target - sec));
            }
        }
        System.out.println("MIN ABS DIFFERENCE IS : " + ans);
    }
//Time Complexity:O(N*totSum->Sum/2) +O(N)+O(N)   Space Complexity: O(N*totSum) + O(N)
    public static void solve(int[] arr, int n, int sum, boolean[][] dp) {
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean take = false;
                if (arr[i] <= j)
                    take = dp[i - 1][j - arr[i]];
                boolean not = dp[i - 1][j];
                dp[i][j] = take | not;
            }
        }
    }
}
