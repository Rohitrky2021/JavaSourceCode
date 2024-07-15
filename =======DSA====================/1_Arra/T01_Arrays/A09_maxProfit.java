package T01_Arrays;

public class A09_maxProfit {
    static int maxProfit(int prices[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = maxProfit > profit ? maxProfit : profit;
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
