package striverIMPLEET;
public class targetSumoffulllength {
    


    public static int i=0;
public static  int findTargetSumWays(int[] nums, int target) {

    if (i == nums.length) {
        if (target == 0) {
            return 1;
        } else {
            return 0;
        }
    }

  int r=  findTargetSumWays(nums, target + nums[i++]);
  i--;
   int l= findTargetSumWays(nums, target - nums[i++]);

   return l+r;

}


public static int findTargetSumWays(int[] nums, int target) {
    return calculateWays(nums, target, 0);
}

private static int calculateWays(int[] nums, int target, int i) {
    if (i == nums.length) {
        if (target == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    int sumWithAddition = calculateWays(nums, target - nums[i], i + 1);
    int sumWithSubtraction = calculateWays(nums, target + nums[i], i + 1);

    return sumWithAddition + sumWithSubtraction;
}

public static void main(String[] args) {
    int num[]={1,1,1,1,1};
    int target=3;
    System.out.println(findTargetSumWays(num, target));
}
}


class Solution {

    private int total = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        for (int num : nums) {
            total += num;
        }
        if (total < Math.abs(target) || (total + target) % 2 != 0) {
            return 0;
        }
        target = (total + target) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        for (int num : nums) {
            total += num;
        }
        if (total < Math.abs(target) || (total + target) % 2 != 0) {
            return 0;
        }
        target = (total + target) / 2;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][target];
    }

    // A - B = target, A + B = total
    // A = (total + target) / 2

    //   0 1 2 3 4
    // 0 1 0 0 0 0
    // 1 1 1 0 0 0
    // 1 1 2 1 0 0
    // 1 1 3 3 1 0
    // 1 1 4 6 4 1
    // 1 1 5 10 10 5
    
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            total += num;
        }
        total += Math.abs(target);
        return helper(nums, 0, target, new Integer[nums.length][total * 2 + 1]);
    }

    private int helper(int[] nums, int index, int target, Integer[][] dp) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        if (dp[index][target + total] != null) {
            return dp[index][target + total];
        }
        int positive = helper(nums, index + 1, target - nums[index], dp);
        int negative = helper(nums, index + 1, target + nums[index], dp);
        dp[index][target + total] = positive + negative;
        return dp[index][target + total];
    }
}