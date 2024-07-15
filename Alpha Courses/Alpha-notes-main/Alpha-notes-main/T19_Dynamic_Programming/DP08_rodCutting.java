package T19_Dynamic_Programming;

public class DP08_rodCutting {

    static void rodCutting(int price[], int leng[], int rodLength) {
        int dp[][] = new int[price.length + 1][rodLength + 1];
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = price[i - 1]; // ith item value
                int w = leng[i - 1]; // jth item weight
                if (w <= j) {
                    int incProfit = v + dp[i][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        printDP(dp);
    }

    static void printDP(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int leng[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,12,10,17,17,20};
        rodCutting(price, leng, 8);

    }
}