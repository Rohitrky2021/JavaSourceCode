package One_d_DP;

import java.util.*;

public class Sum_non_adj {

    // Similar question as - House Robber // max sum of not two consectuvide number
    // sub-seq

    // USING SIMPLE Recursion (TC - 0(2*N) ,SC - 0(N)) ***
    public static int sum(int in, int n, ArrayList<Integer> nums) {

        if (in == 0) {
            return nums.get(0);
        }

        if (in < 0) {
            return 0;
        }

        int pick = nums.get(in) + sum(in - 2, n, nums);
        int notpick = 0 + sum(in - 1, n, nums);
        int finalAns = Math.max(pick, notpick);
        return finalAns;
    }

    // USING DP + MEMORIZATION --(TC -0(N) , SC-0(N))
    public static int sumDp(int dp[], int in, int n, ArrayList<Integer> nums) {
        if (in == 0) {
            dp[0] = nums.get(0);
            return nums.get(0);
        }

        if (in < 0) {
            return 0;
        }

        int pick = nums.get(in);
        if (in > 1 && dp[in - 2] == -1) {
            pick = pick + sumDp(dp, in - 2, n, nums);
        } else {
            if (in > 1) {
                pick = pick + dp[in - 2];
            }

        }

        int notpick = 0;
        if (dp[in - 1] == -1) {
            notpick = 0 + sumDp(dp, in - 1, n, nums);
        } else {
            notpick = 0 + dp[in - 1];
        }

        int finalAns = Math.max(pick, notpick);
        dp[in] = finalAns;
        return finalAns;

    }

    // USING Tabulation + SPACE OPTIMIZATION - (TC -0(N) ,SC-0(1))

    public static int tab(int n, ArrayList<Integer> nums) {
        if (n == 0) {
            return 0;
        }
        int prev1 = nums.get(0);
        int prev2 = 0;
        for (int i = 1; i < nums.size(); i++) {
            int take = nums.get(i);
            if (i > 1) {
                take = take + prev2;
            }
            int notake = prev1;
            int max = Math.max(take, notake);
            prev2 = prev1;
            prev1 = max;
        }
        return prev1;
    }

    /****
     * FOLLOW UP QUESTION --- HERE ARRAY FIRST AND LAST ELEMENT IS ADJACMENT BECASUE
     * ARRAY IS CIRCULAR ARRAY --- QUESTION -- HOUSE ROBBER 2
     */

    // APPROACH - SAME WORK BUT TWO TIME ONE WITHOUT FIRST ELEMENT AND OTHER WITHOUT
    // LAST ELEMENT

    // Here not use last element ****
    public static int tab(int n, int nums[]) {
        if (n == 0) {
            return 0;
        }
        int prev1 = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int take = nums[i];
            if (i > 1) {
                take = take + prev2;
            }
            int notake = prev1;
            int max = Math.max(take, notake);
            prev2 = prev1;
            prev1 = max;
        }
        return prev1;
    }

    // Here not use first element ****
    public static int tab2(int n, int nums[]) {
        if (n == 1) {
            return nums[0];
        }
        int prev1 = nums[1];
        int prev2 = 0;
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i];
            if (i > 2) {
                take = take + prev2;
            }
            int notake = prev1;
            int max = Math.max(take, notake);
            prev2 = prev1;
            prev1 = max;
        }
        return prev1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> as = new ArrayList<>();
        as.add(10);
        as.add(3);
        as.add(9);
        as.add(12);
        int n = as.size();
        System.out.println(tab(n, as));

        // house robber 2
        int arr[] = { 50, 6, 3, 55 };
        int sum1 = tab(arr.length, arr);
        int sum2 = tab2(arr.length, arr);

        // After take two sum then reutrn max of two them
        int ans = Math.max(sum1, sum2);
        System.out.println(ans);
       

    }
}
