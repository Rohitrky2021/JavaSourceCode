import java.util.Arrays;

class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        
        long[] dpIncl = new long[n];
        long[] dpExcl = new long[n];
        
        dpIncl[0] = Math.max(0, nums[0]);
        dpExcl[0] = 0;
        
        for (int i = 1; i < n; i++) {
            dpIncl[i] = Math.max(0, nums[i] + dpExcl[i - 1]);
            dpExcl[i] = Math.max(dpIncl[i - 1], dpExcl[i - 1]);
        }
        
        long maxSum = Math.max(dpIncl[n - 1], dpExcl[n - 1]);
        long totalSum = 0; // Initialize totalSum to 0
        
        for (int[] query : queries) {
            int pos = query[0];
            int newVal = query[1];
            
            nums[pos] = newVal;
            
            if (pos == 0) {
                dpIncl[0] = Math.max(0, nums[0]);
                dpExcl[0] = 0;
            }
            
            for (int i = Math.max(1, pos); i < n; i++) {
                if (i == pos) {
                    dpIncl[i] = Math.max(0, nums[i] + (i > 0 ? dpExcl[i - 1] : 0));
                } else {
                    dpIncl[i] = Math.max(0, nums[i] + dpExcl[i - 1]);
                }
                dpExcl[i] = Math.max(dpIncl[i - 1], dpExcl[i - 1]);
            }
            
            maxSum = Math.max(dpIncl[n - 1], dpExcl[n - 1]);
            totalSum = (totalSum + maxSum) % MOD; // Only add the maximum sum after each query
        }
        
        return (int) totalSum;
    }
}
