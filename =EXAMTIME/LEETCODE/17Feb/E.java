import java.util.*;

public class E {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1]; // Memoization array
        Arrays.fill(dp, -1); // Initialize with -1

        // Make a copy of nums and increment the first element by 1
        int[] check = Arrays.copyOf(nums, nums.length);
        check[0]++;

        // return  tabu(nums);
        return longestConsecutiveHelper(nums, 0, -1, dp,1);
    }

    public static int longestConsecutiveHelper(int[] arr, int i, int prev, int[] dp ,int k) {
        if (i == arr.length)
            return 0;
        if (dp[prev + 1] != -1)
            return dp[prev + 1];

        int not = longestConsecutiveHelper(arr, i + 1, prev, dp , );
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev] || arr[i] == arr[prev] + 1) {
            take = 1 + longestConsecutiveHelper(arr, i + 1, i, dp);
        }
        return dp[prev + 1] = Math.max(take, not);
    }

    public static int tabu(int[] arr) {
        int ans = 1;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 1};
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums)); // Output should be 4
    }
}
