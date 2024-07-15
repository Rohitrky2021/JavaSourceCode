// this is same ques like Q37 the diff is that in last ques we have to buy and sell atmost 2 stocks
// here we have given k so simply while creating array create k+1 
// in this ques we use second approach in which we use two parameters idx and transaction no
// total transaction will be 2 * k so create dp array of [n+1, 2*k + 1]
// even transaction : buy
// odd transaction : sell
public class Q38_Buy_And_Sell_Stock_IV {

    public static int f(int idx, int transNo, int[] prices, int n, int k) {

        if (idx == n || transNo == 2 * k)
            return 0;

        if (transNo % 2 == 0) {

            return Math.max(-prices[idx] + f(idx + 1, transNo + 1, prices, n, k),
                    0 + f(idx + 1, transNo, prices, n, k));

        }

        return Math.max(prices[idx] + f(idx + 1, transNo + 1, prices, n, k),
                0 + f(idx + 1, transNo, prices, n, k));

    }

    public static void main(String[] args) {
        int[] prices = { 8, 5, 1, 3, 10 };
        int k = 2;

        int n = prices.length;

        // recursion
        // System.out.println(f(0, 0, prices, n, k));

        // memoization
        // Integer[][] dp = new Integer[n+1][2*k+1];
        // System.out.println(f2(0, 0, prices, n, k, dp));

        // tabulation
        int[][] dp = new int[n+1][2*k+1];

        for(int idx = n - 1; idx >= 0; idx--){

            for(int transNo = 2 * k - 1; transNo >= 0; transNo--){

                if (transNo % 2 == 0) {

                    dp[idx][transNo] = Math.max(-prices[idx] + dp[idx + 1][transNo + 1], 
                                                0 + dp[idx + 1][transNo]);
        
                }
        
                else dp[idx][transNo] = Math.max(prices[idx] + dp[idx + 1][transNo + 1],
                        0 + dp[idx + 1][transNo]);

            }

        }

        System.out.println(dp[0][0]);

    }

    public static int f2(int idx, int transNo, int[] prices, int n, int k, Integer[][] dp) {

        if (idx == n || transNo == 2 * k)
            return 0;

        if(dp[idx][transNo] != null) return dp[idx][transNo];    

        if (transNo % 2 == 0) {

            return dp[idx][transNo] = Math.max(-prices[idx] + f2(idx + 1, transNo + 1, prices, n, k, dp),
                    0 + f2(idx + 1, transNo, prices, n, k, dp));

        }

        return dp[idx][transNo] = Math.max(prices[idx] + f2(idx + 1, transNo + 1, prices, n, k, dp),
                0 + f2(idx + 1, transNo, prices, n, k, dp));

    }

}
