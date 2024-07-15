// unlimited transaction and a fee on selling a stock.

public class _40BuyAndSell_6 {
    public static void main(String[] args) {
        int [] arr = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println("space : " + space(arr, arr.length, fee));
    }

    public static int space(int[] arr, int n, int fee) {
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    curr[j] = Math.max(ahead[0], -arr[i] + ahead[1]);
                } else {
                    curr[j] = Math.max(arr[i] + ahead[0] - fee, ahead[1]);
                }
            }
            ahead = curr;
        }
        return ahead[0];
    }
 //  Give time and of this Solutoin 
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}
