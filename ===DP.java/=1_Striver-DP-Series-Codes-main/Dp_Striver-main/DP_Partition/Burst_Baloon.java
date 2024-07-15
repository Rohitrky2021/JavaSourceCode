package DP_Partition;

import java.util.ArrayList;

public class Burst_Baloon {
    // same as MCM

    // Memorization ----> Time - O(N*N*N) , Space -  O(N*N)
    public int rec(int i, int j, ArrayList<Integer> arr, int dp[][]) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = 0;
        for (int ind = i; ind <= j; ind++) {
            int t = (arr.get(i - 1) * arr.get(ind) * arr.get(j + 1)) +
                    rec(i, ind - 1, arr, dp) + rec(ind + 1, j, arr, dp);
            max = Math.max(max, t);
        }
        dp[i][j] = max;
        return max;
    }

    // Tabulation ----> Time - O(N*N*N) , Space -  O(N*N)
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int v : nums) {
            arr.add(v);
        }

        arr.add(0, 1);
        arr.add(1);
        int n = arr.size();
        int dp[][] = new int[n][n];

       

        for (int i = n - 2; i >= 1; i--) {

            for (int j = 1; j <= n - 2; j++) {
                int max = 0;
                for (int ind = i; ind <= j; ind++) {
                    int t = (arr.get(i - 1) * arr.get(ind) * arr.get(j + 1)) + dp[i][ind - 1] + dp[ind + 1][j];

                    max = Math.max(max, t);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n - 2];
    }

    public static void main(String[] args) {

    }
}
