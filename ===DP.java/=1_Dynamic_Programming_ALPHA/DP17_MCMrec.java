//Matrix chain maltiplication
package T19_Dynamic_Programming;

import java.util.Arrays;

public class DP17_MCMrec {
    static int recursion(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = recursion(arr, i, k);
            int cost2 = recursion(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            if (ans > finalCost) {
                ans = finalCost;
            }
        }
        return ans;
    }

    static int memo(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = memo(arr, i, k, dp);
            int cost2 = memo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            if (ans > finalCost) {
                ans = finalCost;
            }
        }
        dp[i][j] = ans;

        return dp[i][j] = ans;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        // System.out.println(recursion(arr, 1, arr.length-1));
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(memo(arr, 1, arr.length - 1, dp));
    }
}
