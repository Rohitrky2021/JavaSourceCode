package DP_Stocks;

public class Buy_Sell_Stock_1 {
    public static void main(String[] args) {
        // Approach = for every element find smaller element in LEFT side then get maxi profit
        
        int prices[] = new int [6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 3;
        prices[4] = 6;
        prices[5] = 4;

        int n = prices.length;
        //First price [store here minimum price ]
        int min = prices[0];

        int total =0;

        for(int i=1;i<n;i++){
            total = Math.max(prices[i]-min,total);
            min = Math.min(min,prices[i]);
        }

        System.out.println("Maximum Profit -> "+total);
    }
}
