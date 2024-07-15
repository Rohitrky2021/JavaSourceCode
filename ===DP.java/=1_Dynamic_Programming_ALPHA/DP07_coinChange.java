package T19_Dynamic_Programming;

public class DP07_coinChange {

    static int allWays(int arr[], int sum) {

        int dp[][] = new int[arr.length + 1][sum + 1];


        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = arr[i - 1];
                if (j >= v) {
                    dp[i][j] = dp[i][j - v] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int sum = 4;
        System.out.println(allWays(arr, sum));
    }
}
