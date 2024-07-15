import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/1569081/java-simple-clean-dp-solutions-for-all-6-buy-sell-stock-questions-on-leetcode/
public class s {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
    public int maxProfitIV(int k, int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(0, true, 0, k, prices, cache);
    }

    private int dfs(int currIdx, boolean canBuy, int numTxns, int k, int[] prices, Map<String, Integer> cache) {
        if (numTxns >= k || currIdx == prices.length) {
            return 0;
        }

        String key = currIdx + "-" + canBuy + "-" + numTxns;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // do nothing
        int nothing = dfs(currIdx + 1, canBuy, numTxns, k, prices, cache);

        // buy
        int action;
        if (canBuy) {
            action = dfs(currIdx + 1, false, numTxns, k, prices, cache) - prices[currIdx];
        }
        // sell
        else {
            action = dfs(currIdx + 1, true, numTxns + 1, k, prices, cache) + prices[currIdx];
        }

        int best = Math.max(nothing, action);
        cache.put(key, best);
        return best;
    }

    public int maxProfitIII(int[] prices) {
        int k = 2; // Hardcoded value for at most two transactions
        return maxProfitIV(k, prices);
    }

    public int maxProfitII(int[] prices) {
        return maxProfitIV(0, prices);
    }

    public int maxProfitCooldown(int[] prices) {
        int cooldown = 1; // Cooldown period is 1 day
        return maxProfitWithCooldown(cooldown, prices);
    }

    private int maxProfitWithCooldown(int cooldown, int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return dfsWithCooldown(0, true, 0, cooldown, prices, cache);
    }

    private int dfsWithCooldown(int currIdx, boolean canBuy, int numTxns, int cooldown, int[] prices, Map<String, Integer> cache) {
        if (currIdx == prices.length) {
            return 0;
        }

        String key = currIdx + "-" + canBuy + "-" + numTxns;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // do nothing
        int nothing = dfsWithCooldown(currIdx + 1, canBuy, numTxns, cooldown, prices, cache);

        // buy
        int actionBuy;
        if (canBuy) {
            actionBuy = dfsWithCooldown(currIdx + 1, false, numTxns, cooldown, prices, cache) - prices[currIdx];
        } else {
            actionBuy = 0; // Cannot buy on consecutive days
        }

        // sell
        int actionSell = dfsWithCooldown(currIdx + cooldown, true, numTxns + 1, cooldown, prices, cache) + prices[currIdx];

        int best = Math.max(Math.max(nothing, actionBuy), actionSell);
        cache.put(key, best);
        return best;
    }

    public int maxProfitTransactionFee(int[] prices, int fee) {
        Map<String, Integer> cache = new HashMap<>();
        return dfsWithTransactionFee(0, true, 0, prices, fee, cache);
    }

    private int dfsWithTransactionFee(int currIdx, boolean canBuy, int numTxns, int[] prices, int fee, Map<String, Integer> cache) {
        if (currIdx == prices.length) {
            return 0;
        }

        String key = currIdx + "-" + canBuy + "-" + numTxns;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // do nothing
        int nothing = dfsWithTransactionFee(currIdx + 1, canBuy, numTxns, prices, fee, cache);

        // buy
        int actionBuy;
        if (canBuy) {
            actionBuy = dfsWithTransactionFee(currIdx + 1, false, numTxns, prices, fee, cache) - prices[currIdx] - fee;
        } else {
            actionBuy = 0; // Cannot buy on consecutive days
            
        }
        // sell
        int actionSell = dfsWithTransactionFee(currIdx + 1, true, numTxns + 1, prices, fee, cache) + prices[currIdx];

        int best = Math.max(Math.max(nothing, actionBuy), actionSell);
        cache.put(key, best);
        return best;
    }

    public static void main(String[] args) {
        s solution = new s();

        // Example for Best Time to Buy and Sell Stock IV
        int k = 2;
        int[] pricesIV = {2, 4, 1};
        int resultIV = solution.maxProfitIV(k, pricesIV);
        System.out.println("Max Profit IV: " + resultIV);

        // Example for Best Time to Buy and Sell Stock III (using maxProfitIV method)
        int[] pricesIII = {3, 3, 5, 0, 0, 3, 1, 4};
        int resultIII = solution.maxProfitIII(pricesIII);
        System.out.println("Max Profit III: " + resultIII);

        // Example for Best Time to Buy and Sell Stock II (using maxProfitIV method)
        int[] pricesII = {1, 2, 3, 4, 5};
        int resultII = solution.maxProfitII(pricesII);
        System.out.println("Max Profit II: " + resultII);

        // Example for Best Time to Buy and Sell Stock with Cooldown
        int[] pricesCooldown = {1, 2, 3, 0, 2};
        int resultCooldown = solution.maxProfitCooldown(pricesCooldown);
        System.out.println("Max Profit with Cooldown: " + resultCooldown);

        // Example for Best Time to Buy and Sell Stock with Transaction Fee
        int[] pricesFee = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int resultFee = solution.maxProfitTransactionFee(pricesFee, fee);
        System.out.println("Max Profit with Transaction Fee: " + resultFee);
    }
}
