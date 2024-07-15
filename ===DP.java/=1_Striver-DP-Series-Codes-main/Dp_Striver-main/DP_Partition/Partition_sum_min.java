package DP_Partition;

public class Partition_sum_min {

    // memorization
    public int rec(int i, int k, int arr[], int dp[]) {
        if (i == arr.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int max = 0;
        int ans = 0;
        int length = 0;

        for (int ind = i; ind < i + k; ind++) {
            length++;
            max = Math.max(max, arr[ind]);
            int sum = (max * length) + rec(ind + 1, k, arr, dp);
            ans = Math.max(ans, sum);
            if (ind == arr.length - 1) {
                break;
            }
        }
        dp[i] = ans;
        return ans;
    }

    // tabulation
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length + 1];

        for (int i = arr.length - 1; i >= 0; i--) {

            int max = 0;
            int ans = 0;
            int length = 0;

            for (int ind = i; ind < i + k; ind++) {
                length++;
                max = Math.max(max, arr[ind]);
                int sum = (max * length) + dp[ind + 1];
                ans = Math.max(ans, sum);
                if (ind == arr.length - 1) {
                    break;
                }
            }
            dp[i] = ans;
        }

        return dp[0];
    }

    public static void main(String[] args) {

    }
}
