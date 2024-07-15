import java.util.*;

/*
 * Given an array of ‘N’  positive integers, we need to return the maximum 
 * sum of the subsequence such that no two elements of the subsequence are 
 * adjacent elements in the array.
 */

public class _05sumOfNonAdjEle {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 5, 10, 8, 2);
        int n = list.size();
        int[] dp = new int[n];   // thats why in Below call hamesha (n-1) ko karna hai
        System.out.println("space optimization : " + solveSpaceOpti(list, n - 1));
        System.out.println("tabulation : " + solveTabu(list, n - 1, dp));
        System.out.println("memoization : " + solveMemo(list, n - 1, dp)); 
        System.out.println("recursive : " + solveRec(list, n - 1));
    }
// USING SIMPLE Recursion (TC - 0(2*N) ,SC - 0(N)) ***
    public static int solveRec(List<Integer> list, int i) {
        if (i == 0)
            return list.get(0);
        if (i < 0)
            return 0;
        int pick = list.get(i) + solveRec(list, i - 2);
        int nonpick = 0 + solveRec(list, i - 1);
        return Math.max(pick, nonpick);
    }
// USING DP + MEMORIZATION --(TC -0(N) , SC-0(N))
    public static int solveMemo(List<Integer> list, int i, int[] dp) {
        if (i == 0)
            return list.get(0);
        if (i < 0)
            return 0;
        if (dp[i] != 0)
            return dp[i];
        int pick = list.get(i) + solveMemo(list, i - 2, dp);
        int nonpick = 0 + solveMemo(list, i - 1, dp);
        return dp[i] = Math.max(pick, nonpick);
    }
 // USING Tabulation  - (TC -0(N) ,SC-0(N))
    public static int solveTabu(List<Integer> list, int n, int[] dp) {
        dp[0] = list.get(0);
        int getat1 = list.get(1);
        dp[1] = Math.max(dp[0], getat1);
        for (int i = 2; i <= n; i++) {
            int pick = list.get(i) + dp[i - 2];
            int nonpick = dp[i - 1] + 0;
            dp[i] = Math.max(pick, nonpick);// i index only require 2 index values
        }
        return dp[n];
    }
 // USING Tabulation + SPACE OPTIMIZATION - (TC -0(N) ,SC-0(1))
    public static int solveSpaceOpti(List<Integer> list, int n) {
        int two = list.get(0); //have doubt in this esliye below code i wrote  
        int one = Math.max(list.get(0), list.get(1));
        for (int i = 2; i <= n; i++) {
            int pick = list.get(i) + two;
            int nonpick = 0 + one;
            two = one;
            one = Math.max(pick, nonpick);
        }
        return one;
    }

    static int solve(int n, int[] arr) { // Pointer will move left to right and order will
         int prev = arr[0];             // :-  prev2 -> prev -> curr
        int prev2 = 0;
          for (int i = 1; i < n; i++) {
             int pick = arr[i];
             if (i > 1)
                pick += prev2;

              int nonPick = prev;

              int cur_i = Math.max(pick, nonPick);

            prev2 = prev;
            prev = cur_i;
        }

         return prev;
    }

    // For -value modify also dont take them 
    private int calculateNegativePick(int[] nums, int n) {
        int prev = nums[0] < 0 ? 0 : nums[0];
        int prev2 = 0;
        
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

    private long calculate(int[] nums, int n) { // Change return type to long
        if (nums.length == 0) return 0;
        if (nums.length == 1) return Math.max(0, nums[0]);
        long prev = Math.max(0, nums[0]);
        long prev2 = 0L; // Change prev2 to long
        for (int i = 1; i < n; i++) {
            long pick = nums[i] + prev2;
            
    
            long nonPick = prev; // Change nonPick to long
    
            long cur_i = Math.max(pick, nonPick);
    
            prev2 = prev;
            prev = cur_i;
        }
    
        return prev;
    }

}
