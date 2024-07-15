import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        int n = nums.length;
        int ans = 0;
        
        // Calculate answer for each query
        for (int[] query : queries) {
            int posi = query[0];
            int xi = query[1];
            
            // Update nums[posi]
            nums[posi] = xi;
            
       
            
            // Calculate maximum sum of subsequence for the current query
            ans += calculate(nums, n);
            ans %= MOD; // Keep the sum within modulo 10^9 + 7
        }
        
        return ans;
    }
    
    private int calculate(int[] nums, int n) {
        int prev = nums[0] < 0 ? 0 : nums[0];
        int prev2 = 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return Math.max(0, nums[0]);
        for (int i = 1; i < n; i++) {
            int pick = nums[i] < 0 ? 0 : nums[i]; // If nums[i] is negative, consider it as 0
            pick += prev2;
    
            int nonPick = prev;
    
            int cur_i = Math.max(pick, nonPick);
    
            prev2 = prev;
            prev = cur_i;
        }
    
        return prev;
    }
    
}

public class D {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {3, 5, 9};
        int[][] queries1 = {{1, -2}, {0, -3}};
        System.out.println("Test case 1: " + solution.maximumSumSubsequence(nums1, queries1)); // Output: 21

        // Test case 2
        int[] nums2 = {0, -1};
        int[][] queries2 = {{0, -5}};
        System.out.println("Test case 2: " + solution.maximumSumSubsequence(nums2, queries2)); // Output: 0
    }
}
