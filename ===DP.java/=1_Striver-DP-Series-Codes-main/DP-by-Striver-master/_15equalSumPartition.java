import java.util.Arrays;

public class _15equalSumPartition {
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        if (canPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }

    static boolean canPartition(int n, int[] arr) {
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1) return false;

        else {
            int k = totSum / 2;
            int dp[][] = new int[n][k + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);
            return subsetSumUtil(n - 1, k, arr, dp);
        }
    }
    // Here u can use any Subset Methods used in Previous Question.....
// Time Complexity: O(N*K)  Space Complexity: O(N*K) + O(N) 
    static boolean subsetSumUtil(int ind, int target, int arr[], int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
}
