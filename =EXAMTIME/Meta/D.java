import java.util.Arrays;

public class D {
    public static void printCoinsUsed(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    lastCoin[i] = coin;
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            System.out.println("No solution found");
        } else {
            System.out.println("Coins used to make " + amount + " cents:");
            while (amount > 0) {
                int coin = lastCoin[amount];
                System.out.print(coin + " ");
                amount -= coin;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,7,17,17}; // Example coin denominations
        int amount = 41; // Example desired change amount
        printCoinsUsed(coins, amount);
    }
}
