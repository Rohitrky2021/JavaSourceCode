import java.util.Arrays;

public class _54PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("rec : " + f(arr, 0, k));
        System.out.println("memo : " + memo(arr, 0, k, dp));
        System.out.println("tabu : " + tabu(arr, n, k));
        System.out.println("space : " + space(arr, n, k));
    }


    public static int f(int[] arr, int ind, int k) {
        if (ind == arr.length) return 0;

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for (int j = ind; j < ind + k && j < arr.length; j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + f(arr, j + 1, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

    public static int memo(int[] arr, int ind, int k, int[] dp) {
        if (ind == arr.length) return 0;

        if (dp[ind] != -1) return dp[ind];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for (int j = ind; j < ind + k && j < arr.length; j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + memo(arr, j + 1, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }

    public static int tabu(int[] arr, int n, int k) {
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = 0;
            int maxAns = 0;
            for (int j = ind; j < ind + k && j < n; j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }

    public static int space(int[] arr, int n, int k) {
        int[] dp = new int[k];

        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = 0;
            int maxAns = 0;
            for (int j = ind; j < ind + k && j < n; j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[(j + 1) % k];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind % k] = maxAns;
        }
        return dp[0];
    }
}


