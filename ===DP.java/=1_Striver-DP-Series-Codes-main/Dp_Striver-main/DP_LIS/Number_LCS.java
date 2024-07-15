package DP_LIS;

import java.util.Arrays;

public class Number_LCS {

    public static int findNumberOfLIS(int[] a) {
        int n = a.length;
        int ans = 0;
        int dp[] = new int[n];
        int count[] = new int[n]; // create a count array

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {

                    if (dp[i] == 1 + dp[j]) {

                        count[i] = count[i] + count[j]; // if equal fre
                    }

                    if (dp[i] < 1 + dp[j]) {

                        dp[i] = 1 + dp[j];
                        count[i] = count[j]; // if not equal 

                    }

                }

            }

            ans = Math.max(ans, dp[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (ans == dp[i]) {
                total += count[i];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int prices[] = new int [6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 3;
        prices[4] = 6;
        prices[5] = 4;
        
        System.out.println(findNumberOfLIS(prices));
    }
}
