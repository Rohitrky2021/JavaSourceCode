// this is similar like zero one knapsack but here for every weights we have 
// infinite supply so we can use same idx many times
public class Q23_Unbounded_knapsack {
    public static int f(int idx, int W, int[] wt, int[] val) {

        if (idx == 0)
            return (W / wt[idx]) * val[idx];

        int nottake = 0 + f(idx - 1, W, wt, val);

        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W)
            take = val[idx] + f(idx, W - wt[idx], wt, val);

        return Math.max(take, nottake);

    }

    public static void main(String[] args) {

        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // recursion
        // System.out.println(f(n-1, W, wt, val));

        // memoizationd
        // int[][] dp = new int[n][W + 1];

        // for (int tar = 0; tar <= W; tar++)
        //     dp[0][tar] = (tar / wt[0]) * val[0];

        // for (int idx = 1; idx < n; idx++) {

        //     for (int tar = 0; tar <= W; tar++) {

        //         int nottake = 0 + dp[idx - 1][tar];

        //         int take = Integer.MIN_VALUE;
        //         if (wt[idx] <= tar)
        //             take = val[idx] + dp[idx][tar - wt[idx]];

        //         dp[idx][tar] = Math.max(take, nottake);

        //     }

        // }

        // System.out.println(dp[n - 1][W]);

        // space optimization

        int[] prev = new int[W+1];
        int[] curr = new int[W+1];

        for (int tar = 0; tar <= W; tar++)
            prev[tar] = (tar / wt[0]) * val[0];

        for (int idx = 1; idx < n; idx++) {

            for (int tar = 0; tar <= W; tar++) {

                int nottake = 0 + prev[tar];

                int take = Integer.MIN_VALUE;
                if (wt[idx] <= tar)
                    take = val[idx] + curr[tar - wt[idx]];

                curr[tar] = Math.max(take, nottake);

            }

            prev = curr;

        }

        System.out.println(prev[W]);

    }

    public static int f2(int idx, int W, int[] wt, int[] val) {

        if (idx == 0)
            return (W / wt[idx]) * val[idx];

        int nottake = 0 + f2(idx - 1, W, wt, val);

        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W)
            take = val[idx] + f2(idx, W - wt[idx], wt, val);

        return Math.max(take, nottake);

    }
}
