package striverIMPLEET;

// https://leetcode.com/problems/coin-change-ii/

public class CoinChange2 {
    
}
class Solution {
    static int[][] tmp = new int[6000][6000];
    public int change(int amount, int[] coins) {
                for (int[] row : tmp) {
            Arrays.fill(row, -1);
        }
        System.gc();
        return subsetCount(coins,amount,coins.length);
    }

    public static int subsetCount(int[] arr, int sum, int n) {
        
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (tmp[n][sum] != -1)
            return tmp[n][sum];
        else {
            if (arr[n - 1] > sum)
                return tmp[n][sum] = subsetCount(arr, sum, n - 1);
            else {
                return tmp[n][sum] = subsetCount(arr, sum, n - 1) + subsetCount(arr, sum - arr[n - 1], n);
            }
        }
    }

}