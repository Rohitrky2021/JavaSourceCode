/*
 * You  are  given  an  array prices where prices[i] is  the  price  of  a  given  stock  on  the ith day.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class exercise3 {
   public static int maxProfit(int[] prices) {
    if(prices.length<2) {
        return 0;
    }
    int minPrice = prices[0];
    int maxProfit = 0;
    for(int i=1;i<prices.length;i++) {
        //update the minimum price seen so far
        minPrice = Math.min(minPrice, prices[i]);
        //update the max profit by comparing the current profit to the previous max profit
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    }
    return maxProfit;
   }
   public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
   }
}
