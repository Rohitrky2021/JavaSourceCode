import java.util.Arrays;

public class C {

    public static int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int[][] dp = new int[n][n + 1];  // dp array to store results of subproblems
        for (int[] row : dp) {
            Arrays.fill(row, -1);  // Initialize dp array with -1
        }
        Arrays.sort(rewardValues);  // Sort the rewardValues array\
        return solve(rewardValues, 0, -1, dp,0);
    }

    private static int solve(int[] arr, int i, int prev, int[][] dp) {
        if (i == arr.length) return 0;  // Base case: If we reach the end of the array
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];  // Check memoization table

        int notTake = solve(arr, i + 1, prev, dp);  // Option to skip the current reward
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = arr[i] + solve(arr, i + 1, i, dp);  // Option to take the current reward
        }

        dp[i][prev + 1] = Math.max(take, notTake);  // Store the result in memoization table
        return dp[i][prev + 1];
    }

    public static void main(String[] args) {
        int[] rewardValues1 = {1, 1, 3, 3};
        System.out.println(maxTotalReward(rewardValues1));  // Output: 4

        int[] rewardValues2 = {1, 6, 4, 3, 2};
        System.out.println(maxTotalReward(rewardValues2));  // Output: 11
    }
}
