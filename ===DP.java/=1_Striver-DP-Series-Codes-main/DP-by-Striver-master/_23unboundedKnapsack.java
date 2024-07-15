/*
A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’
items of infinite supply. Its weight is given by the ‘wt’ array and its value by the ‘val’ array.
He can either include an item in its knapsack or exclude it but can’t partially have it as a fraction.
We need to find the maximum value of items that the thief can steal. He can take a single item any
number of times he wants and put it in his knapsack.
 */


public class _23unboundedKnapsack {
    public static void main(String[] args) {
        int[] w = {2,4,6};
        int[] v = {5,11,13};
        int n = w.length;
        int W = 10;

        System.out.println("rec : " + rec(w,v,n-1,W));
        int[][] dp = new int[n][W+1];
        System.out.println("Memo : "+ memo(w,v,n-1,W,dp));
        System.out.println("tabu : "+ tabu(w,v,n,W));
        System.out.println("space opti : "+ space(w,v,n,W));
    }

    public static int rec(int[] w, int[] v, int n, int W){
        if(n == 0){
            if(w[0] <= W) return v[0] * (W / w[0]);
            else return 0;
        }

        int stole = 0;
        if(w[n] <= W) stole = v[n] + rec(w,v,n, W-w[n]);
        int notStole = rec(w,v,n-1,W);

        return Math.max(stole, notStole);
    }

    public static int memo(int[] w, int[] v, int n, int W, int[][] dp){
        if(n == 0){
            if(w[0] <= W) return v[0] * (W / w[0]);
            else return 0;
        }
        if(dp[n][W] != 0) return dp[n][W];
        int stole = 0;
        if(w[n] <= W) stole = v[n] + memo(w,v,n, W-w[n], dp);
        int notStole = memo(w,v,n-1,W, dp);

        return dp[n][W] =  Math.max(stole, notStole);
    }
//   TC:-O(N*W)  and SC:-O(N*W)  similar more understanding method
    public static int helper(int n, int w, int[] profit, int[] weight, int[][] res) {
        // Return pre-computed value.
        if (res[w][n] != -1) {
            return res[w][n];
        } 
        if (n == 0 || w == 0) {
            return res[w][n] = 0;
        } 
        if (weight[n - 1] > w) {
            res[w][n] = helper(n - 1, w, profit, weight, res);
        } else {
             res[w][n] = Math.max(profit[n - 1] + helper(n, w - weight[n - 1], profit, weight, res),
                    helper(n - 1, w, profit, weight, res));
        } 
        return res[w][n];
    }
// IMP Code similar but tried some tricky and all worked   
    public static int memo2(int[] w, int[] v, int n, int W, int[][] dp) {
        // Base case
        if (n <0 || W == 0) {
            return 0;
        }
        // If the value is already calculated, return it
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // Recursive cases
        int stole = 0;
        if (w[n] <= W)
            stole = v[n] + memo(w, v, n, W - w[n], dp);
        int notStole = memo(w, v, n - 1, W, dp);

        // Memoize the result and return
        return dp[n][W] = Math.max(stole, notStole);
    }
    public static int tabu(int[] w, int[] v, int n, int W){
        int[][] dp = new int[n][W+1];

        for(int weight = w[0]; weight <= W; weight++){
            if(w[0] <= weight) dp[0][weight] = v[0] * (weight/ w[0]);
        }

        for(int i=1; i<n; i++){
            for(int weight = 0; weight<= W; weight++){
                int take = 0;
                if(w[i] <= weight) take = v[i] + dp[i][weight - w[i]];
                int not  = dp[i-1][weight];
                dp[i][weight] = Math.max(take, not);
            }
        }
        return dp[n-1][W];
    }

    public static int space(int[] w, int[] v, int n, int W){
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];

        for(int weight = w[0]; weight <=W; weight++ ){
            if(w[0] <= weight) prev[weight] = v[0] *( weight / w[0]);
        }

        for(int i=1; i<n; i++){
            for(int weight = 0; weight <= W; weight++){
                int take = 0;
                if(w[i] <=weight) take = v[i] + curr[weight - w[i]];
                int not = prev[weight];
                curr[weight] = Math.max(take, not);
            }
            prev = curr;
        }
        return curr[W];
    }
}
