// given an array which denotes we have diff rate in diff days
// we want to buy and sell the stock with maximum profit or the best time to buy and sell
// to get max profit we have to buy the stock in min price and sell it on high
public class Q35_Buy_and_sell_stock{
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        int min = arr[0];
        int profit = 0;
        // assume we have buy a stock in min price which is arr[0] and curr profit is 0 
        // now traverse in arr from 1 to n and find out profit and update min

        for(int i = 1; i < arr.length; i++){

            profit = Math.max(profit, arr[i] - min);
            min = Math.min(min, arr[i]);

        }
    }
}