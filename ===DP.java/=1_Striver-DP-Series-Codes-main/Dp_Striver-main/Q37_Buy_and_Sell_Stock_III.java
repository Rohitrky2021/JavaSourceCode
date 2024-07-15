// in Q36 we are required to buy and sell multiple stocks by using the rules that we cannot buy again if
// we already have one buy stock so BS BS property have to be followed (BS : Buy - Sell)
// in this ques we have to only 2 transactions allowed (means buy sell buy sell 2 times onlu) 
// so use one cap variable whenever cap become 0 
// stop buying the stocks and return max profit
// three variables we use
// buy (0/1) 0 means we can sell stock and 1 means we can buy
// cap (0-2) buy atmost 2 stocks
// idx (0 to n)
public class Q37_Buy_and_Sell_Stock_III {

    public static int f(int idx, int buy, int cap, int[] prices, int n) {

        if (idx == n || cap == 0)
            return 0;

        if (buy == 1) {
            return Math.max(-prices[idx] + f(idx + 1, 0, cap, prices, n),
                    0 + f(idx + 1, 1, cap, prices, n));
        }

        // when we sell than one transaction completed so decrease cap by 1
        return Math.max(prices[idx] + f(idx + 1, 1, cap - 1, prices, n),
                0 + f(idx + 1, 0, cap, prices, n));

    }

    public static void main(String[] args) {

        int[] prices = { 5, 4, 3, 2, 1 };

        int n = prices.length;

        // recursion
        // System.out.println(f(0, 1, 2, prices, n));

        // memoization
        // Integer[][][] dp = new Integer[n+1][2][3];
        // System.out.println(f2(0, 1, 2, prices, n, dp));

        // tabulation
        int[][][] dp = new int[n + 1][2][3];
        // in base case we wrote if (idx == n || cap == 0) then return 0 and by default
        // evry cell
        // have value 0 so no need to write base case again

        // we can solve this using dp[n+1][4] 2D array
        // n+1 is for idx and 4 for transaction we have to buy and sell atmost 2 stocks
        // so total
        // will be 4 : 0(buy) 1(sell) 2(buy) 3(sell)
        // buy is even and sell is odd so we can use if(trans % 2 == 0) do for buy
        // max(-price[idx] + f(idx+1, trans + 1), 0 + f(idx+1, trans)
        // same for sell

        for (int idx = n - 1; idx >= 0; idx--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap],
                                0 + dp[idx + 1][1][cap]);
                    }

                    else {
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap - 1],
                                0 + dp[idx + 1][0][cap]);
                    }

                }

            }

        }

        System.out.println(dp[0][1][2]);

    }

    public static int f2(int idx, int buy, int cap, int[] prices, int n, Integer[][][] dp) {

        if (idx == n || cap == 0)
            return 0;

        if (dp[idx][buy][cap] != null)
            return dp[idx][buy][cap];

        if (buy == 1) {
            return dp[idx][buy][cap] = Math.max(-prices[idx] + f2(idx + 1, 0, cap, prices, n, dp),
                    0 + f2(idx + 1, 1, cap, prices, n, dp));
        }

        return dp[idx][buy][cap] = Math.max(prices[idx] + f2(idx + 1, 1, cap - 1, prices, n, dp),
                0 + f2(idx + 1, 0, cap, prices, n, dp));

    }

}
