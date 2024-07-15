import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> memo = new HashMap<>();
        
        return dp(0, nums, memo, n);
    }
    
    private long dp(int i, int[] nums, Map<Integer, Long> memo, int n) {
        if (i >= n) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        long maxCost = Long.MIN_VALUE;
        long currentCost = 0;
        
        for (int j = i; j < n; j++) {
            currentCost += nums[j] * (j % 2 == i % 2 ? 1 : -1);
            maxCost = Math.max(maxCost, currentCost + dp(j + 1, nums, memo, n));
        }
        
        memo.put(i, maxCost);
        return maxCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, -2, 3, 4};
        System.out.println(solution.maximumTotalCost(nums1));  // Output: 10
        
        int[] nums2 = {1, -1, 1, -1};
        System.out.println(solution.maximumTotalCost(nums2));  // Output: 4
        
        int[] nums3 = {0};
        System.out.println(solution.maximumTotalCost(nums3));  // Output: 0
        
        int[] nums4 = {1, -1};
        System.out.println(solution.maximumTotalCost(nums4));  // Output: 2
    }
}
