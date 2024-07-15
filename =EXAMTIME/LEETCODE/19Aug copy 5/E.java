import java.util.*;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int maxTotalReward = Arrays.stream(rewardValues).sum();
        int[][] dp = new int[n + 1][maxTotalReward + 1];
        
        Arrays.sort(rewardValues);
        // Reverse the sorted array
        for (int i = 0; i < n / 2; i++) {
            int temp = rewardValues[i];
            rewardValues[i] = rewardValues[n - i - 1];
            rewardValues[n - i - 1] = temp;
        }
      

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxTotalReward; j++) {
                dp[i][j] = dp[i - 1][j]; // Initialize with the value from the previous row
                if (rewardValues[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rewardValues[i - 1]] + rewardValues[i - 1]);
                }
            }
        }

        return dp[n][maxTotalReward];
    }
}

public class E {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage
        int[] rewardValues = {1, 2, 3, 4, 5};
        int maxTotalReward = solution.maxTotalReward(rewardValues);
        System.out.println("Maximum total reward: " + maxTotalReward);
        int[] rewardValues1 = {1, 1, 3, 3};
        System.out.println("Maximum Total Reward for rewardValues1: " + solution.maxTotalReward(rewardValues1));

        int[] rewardValues2 = {1, 6, 4, 3, 2};
        System.out.println("Maximum Total Reward for rewardValues2: " + solution.maxTotalReward(rewardValues2));

    }
}
class Solution {
    public int maxTotalReward(int[] rewards) {
        Arrays.sort(rewards);
        int max = rewards[rewards.length - 1];
        boolean[] dp = new boolean[max+1];
        dp[0] = true;
        for(int i = 0; i < rewards.length-1; i++) {
            for(int j = rewards[i]; j <= max && j-rewards[i] < rewards[i]; j++) {
                // System.out.println(j+" "+rewards[i]);
                dp[j] = dp[j] || (dp[j-rewards[i]]);
            }  
        }
        for(int i = max - 1; i >= 0; i--) {
            if(dp[i]) return  max + i;
        }
        return max;
    }
}