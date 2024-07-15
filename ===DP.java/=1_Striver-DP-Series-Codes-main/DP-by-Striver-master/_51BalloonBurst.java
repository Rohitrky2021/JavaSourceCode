

public class _51BalloonBurst {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        int size = arr.length;
        int[] bal = new int[size + 2];
        int i = 1;
        for (int e : arr) bal[i++] = e;
        bal[0] = bal[i] = 1;
        int n = bal.length;
        int[][] dp = new int[n][n];
        System.out.println("memo : " + burst(bal, 0, n - 1, dp));
    }

    public static int burst(int[] arr, int left, int right, int[][] dp) {
        if (left > right) return 0;
        if (dp[left][right] > 0) return dp[left][right];
        int maxi = 0;
        for (int i = left + 1; i < right; i++) {
            int temp = arr[i] * arr[left] * arr[right] + burst(arr, left, i, dp) + burst(arr, i, right, dp);
            maxi = Math.max(maxi, temp);
        }
        return dp[left][right] = maxi;
    }
}
