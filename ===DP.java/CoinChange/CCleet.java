public class CCleet {
    
// class Solution {

//     int  dp[]=new int[1005];

// 	public int coinChange(int[] coins, int amount) {
//         if(amount==0) return 0;
//         if(dp[amount]!=-1) return dp[amount];
//         int cc=Integer.MAX_VALUE;
//         int coin=0;
//         for(int i=0;i<coins.length;i++) {
//             if(amount-coins[i]>=0)
//                  cc=Math.min(cc,coinChange(coins, amount-coins[i])+1 );

//         }
//         return dp[amount]=cc;
//     }

// }

// public class Solution {
// public int coinChange(int[] coins, int amount) {
//     return coinChangeRecursive(coins, amount);
// }

// private int coinChangeRecursive(int[] coins, int amount) {
//     if (amount < 0) return -1;
//     if (amount == 0) return 0;
    
//     int minCoins = Integer.MAX_VALUE;
    
//     for (int i = 0; i < coins.length; i++) {
//         int coinCount = coinChangeRecursive(coins, amount - coins[i]);
//         if (coinCount >= 0 && coinCount < minCoins) {
//             minCoins = coinCount + 1;
//         }
//     }
    
//     return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
// }


// public int coinChange(int[] coins, int amount) {
//     int[] dp = new int[amount + 1];
//     Arrays.fill(dp, amount + 1); // Initialize with a value greater than the maximum possible amount
    
//     dp[0] = 0; // Zero coins needed to make change for zero amount
    
//     for (int coin : coins) {
//         for (int i = coin; i <= amount; i++) {
//             dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//         }
//     }
    
//     return dp[amount] > amount ? -1 : dp[amount];
// }


// }

class Solution {

    int[] cache;

    public int coinChange(int[] coins, int amount) {
        cache = new int[amount + 1];
        Arrays.fill(cache, -1); // Initialize cache with -1

        int res = solve(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        if (cache[amount] != -1)
            return cache[amount];

        int minVal = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin <= amount) {
                int temp = solve(coins, amount - coin);
                // if (temp != Integer.MAX_VALUE && temp + 1 < minVal) minVal = temp + 1;
								if (temp != Integer.MAX_VALUE )
									 minVal=	Math.min( minVal,temp + 1);
                  
            }
        }

        cache[amount] = minVal;
        return minVal;
    }
}



// public class Solution {
//     public int coinChange(int[] coins, int amount) {
//         // if (coins == null || coins.length == 0)   
// 		// 	return -1;   

// 		if (amount <= 0)
// 			return 0;

// 		int dp[] = new int[amount + 1];
// 		for (int i = 1; i < dp.length; i++) {
// 			dp[i] = Integer.MAX_VALUE;
// 		}

// 		for (int am = 1; am < dp.length; am++) {
// 			for (int i = 0; i < coins.length; i++) {
// 				if (coins[i] <= am) {
// 					int sub = dp[am - coins[i]];
// 					if (sub != Integer.MAX_VALUE)
// 						dp[am] = Math.min(sub + 1, dp[am]);
// 				}
// 			}
// 		}
// 		return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
//     }
// }
