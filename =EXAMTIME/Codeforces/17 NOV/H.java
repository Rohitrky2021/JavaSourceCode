public class H {

    public static void main(String[] args) {
        int[] arr = {9, 9, 8, 8};
        int result = maxSubarraySum(arr);
        System.out.println("Maximum subarray sum: " + result);
    }

    public static int maxSubarraySum(int[] arr) {
        int n = arr.length;

        // dp[i][0] represents the maximum subarray sum ending at index i with the last element being even
        // dp[i][1] represents the maximum subarray sum ending at index i with the last element being odd
        int[][] dp = new int[n][2];

        dp[0][0] = arr[0] % 2 == 0 ? arr[0] : 0;
        dp[0][1] = arr[0] % 2 != 0 ? arr[0] : 0;

        int maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] % 2 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
                dp[i][0] = dp[i - 1][0];
            }

            maxSum = Math.max(maxSum, Math.max(dp[i][0], dp[i][1]));
        }

        return maxSum;
    }
}
