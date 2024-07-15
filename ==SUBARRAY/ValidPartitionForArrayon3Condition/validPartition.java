// class Solution {
    // https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/
        public class validPartition {
        boolean check(int nums[], int dp[], int i,int n){
            if(i==n) return true;
            if(dp[i]!=0) return dp[i]==1;
            if(i<n-1 && nums[i]==nums[i+1]) {
                if(check(nums,dp,i+2,n)) {
                    dp[i] = 1;
                    return true;
                }
            } 
            if(i<n-2 && nums[i]==nums[i+1] && nums[i]==nums[i+2]){
                if(check(nums,dp,i+3,n)) {
                    dp[i] = 1;
                    return true;
                }
            }
            if(i<n-2 && nums[i]+1==nums[i+1] && nums[i]+2==nums[i+2]) {
                if(check(nums,dp,i+3,n)) {
                    dp[i] = 1;
                    return true;
                }
            }
            dp[i] = -1;
            return false;
    
        }
        public boolean validPartition(int[] nums) {
            int arr[] = new int[nums.length];
            return check(nums,arr,0,nums.length);
        }
    }
    
    

// class Solution {
//     public boolean validPartition(int[] nums) {
//         return recur(nums, 0, new Boolean[nums.length]);
//     }

    public boolean recur(int[] nums, int i, Boolean[] dp){
        if(i == nums.length) return true;
        if(dp[i] != null) return dp[i];

        if((i + 1) < nums.length && (nums[i] == nums[i+1]))
            if(recur(nums, i+2, dp)) return dp[i] = true;
        if((i + 2) < nums.length && nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
            if(recur(nums, i+3, dp)) return dp[i] = true;
        if((i + 2) < nums.length && ((nums[i] + 1) == nums[i+1]) && ((nums[i] + 2) == nums[i+2]))
            if(recur(nums, i+3, dp)) return dp[i] = true;

        return dp[i] = false;
    }
}

public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;

        if (n == 1) return false;

        boolean[] dp = new boolean[]{true, false, n > 1 && nums[0] == nums[1]};

        for (int i = 2; i < n; i++) {
            boolean current_dp = false;

            if (nums[i] == nums[i-1] && dp[1]) {
                current_dp = true;
            }
            else if (nums[i] == nums[i-1] && nums[i] == nums[i-2] && dp[0]) {
                current_dp = true;
            }
            else if (nums[i] - nums[i-1] == 1 && nums[i-1] - nums[i-2] == 1 && dp[0]) {
                current_dp = true;
            }

            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = current_dp;
        }

        return dp[2];
    }
}

// Code - Combine True

public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        boolean[] dp = {true, false, n > 1 ? nums[0] == nums[1] : false};
        for (int i = 2; i < n; i++) {
            boolean current_dp = (nums[i] == nums[i-1] && dp[1]) || 
                                 (nums[i] == nums[i-1] && nums[i] == nums[i-2] && dp[0]) ||
                                 (nums[i] - nums[i-1] == 1 && nums[i-1] - nums[i-2] == 1 && dp[0]);
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = current_dp;
        }
        return dp[2];
    }
}

