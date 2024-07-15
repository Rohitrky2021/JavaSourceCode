class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] max = new int[] { 0 };
        sol(0, 0, nums, dp, max);
        return max[0];
    }

    private int sol(int ind, int prev, int[] nums, int[][] dp, int[] max) {
        if (ind == nums.length) {
            return 0;
        }
        if (dp[ind][prev] != -1) {
            return dp[ind][prev];
        }
        int w = -1;
        int wo = -1;
        if (ind == prev) {
            w = 1 + sol(ind + 1, ind, nums, dp, max);
            wo = sol(ind + 1, ind + 1, nums, dp, max);
        } else {
            if (nums[ind] > nums[prev]) {
                w = 1 + sol(ind + 1, ind, nums, dp, max);
            }
            wo = sol(ind + 1, prev, nums, dp, max);
        }

        dp[ind][prev] = Math.max(w, wo);
        max[0] = Math.max(max[0], dp[ind][prev]);
        return dp[ind][prev];
    }
}

