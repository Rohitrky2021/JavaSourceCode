// this is similar type of question like target sum
// here we have given a bag of some capacity and given two arrays weight and value
// we have to collect some weights and add it into bag so we get max value and capacity will not break
// otherwise bag will be destroyed
// use same approach of not take and take
// if not take then capacity will be same and idx will be reduces
// if take then firstly check that the weight[idx] <= cap then only we can take the weight
// when we take then cap will be cap - weight[idx] and add value of idx 
// now return max 
public class Q19_Zero_One_Knapsack {
    public static int f(int idx, int capacity, int[] wt, int[] val) {

        if (idx == 0) {
            if (wt[idx] <= capacity)
                return val[idx];
            return 0;
        }

        int nottake = 0 + f(idx - 1, capacity, wt, val);

        int take = Integer.MIN_VALUE;
        if (wt[idx] <= capacity)
            take = val[idx] + f(idx - 1, capacity - wt[idx], wt, val);

        return Math.max(take, nottake);

    }

    public static void main(String[] args) {
        int wt[] = { 1, 2, 4, 5 };
        int val[] = { 5, 4, 8, 6 };
        int W = 5; // capacitty of bag

        int n = wt.length;

        // recursion
        // System.out.println(f(n-1, W, wt, val));

        // memoization
        // Integer[][] dp = new Integer[n][W+1];
        // System.out.println(f2(n-1, W, wt, val, dp));

        // tabulation
        // int[][] dp = new int[n][W + 1];
        // if (wt[0] <= W)
        //     dp[0][wt[0]] = val[0];

        // for (int idx = 1; idx < n; idx++) {

        //     for (int capacity = 0; capacity <= W; capacity++) {

        //         int nottake = 0 + dp[idx - 1][capacity];

        //         int take = Integer.MIN_VALUE;
        //         if (wt[idx] <= capacity)
        //             take = val[idx] + dp[idx - 1][capacity - wt[idx]];

        //         dp[idx][capacity] = Math.max(take, nottake);

        //     }

        // }

        // System.out.println(dp[n-1][W]);

        // space optimization
        // int[] dp = new int[W + 1];
        // if (wt[0] <= W)
        //     dp[wt[0]] = val[0];

        // for (int idx = 1; idx < n; idx++) {
        //     int[] curr = new int[W + 1];
        //     for (int capacity = 0; capacity <= W; capacity++) {

        //         int nottake = 0 + dp[capacity];

        //         int take = Integer.MIN_VALUE;
        //         if (wt[idx] <= capacity)
        //             take = val[idx] + dp[capacity - wt[idx]];

        //         curr[capacity] = Math.max(take, nottake);

        //     }
        //     dp = curr;
        // }

        // System.out.println(dp[W]);

        // in space optimization we use two 1D array, we can optimize this also by using one 1D array only
        // we can see in dp[] we are using dp[cap - wt[idx]] so we are using left side of prev row only
        // no use of right side
        // so we can start traversing from end and putting values at end 
        // so here we'll put values in same array
        int[] dp = new int[W + 1];
        if (wt[0] <= W)
            dp[wt[0]] = val[0];

        for (int idx = 1; idx < n; idx++) {
            
            for (int capacity = W; capacity >= 0; capacity--) {

                int nottake = 0 + dp[capacity];

                int take = Integer.MIN_VALUE;
                if (wt[idx] <= capacity)
                    take = val[idx] + dp[capacity - wt[idx]];

                dp[capacity] = Math.max(take, nottake);

            }
            
        }

        System.out.println(dp[W]);
    }

    public static int f2(int idx, int capacity, int[] wt, int[] val, Integer[][] dp) {

        // now when we reach at idx 0 that means we have only one element and we have
        // capacity so
        // we check that the weight of 0th idx is less then or equal to cap or not if
        // yes then return val
        // of idx else return 0;
        if (idx == 0) {
            if (wt[idx] <= capacity)
                return val[idx];
            return 0;
        }

        if (dp[idx][capacity] != null)
            return dp[idx][capacity];

        int nottake = 0 + f2(idx - 1, capacity, wt, val, dp);

        int take = Integer.MIN_VALUE;
        if (wt[idx] <= capacity)
            take = val[idx] + f2(idx - 1, capacity - wt[idx], wt, val, dp);

        return dp[idx][capacity] = Math.max(take, nottake);

    }
}
