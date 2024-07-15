package T19_Dynamic_Programming;

public class DP05_targetSum {

    static void tabulation(int numbers[], int target) {

        boolean dp[][] = new boolean[numbers.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = numbers[i - 1];
                if (j >= v) {
                    dp[i][j] = (j == v) || dp[i-1][j-v] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // return dp[numbers.length][target];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {

                    System.out.print(1 + " ");
                } else {

                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
    static void tabulation2(int numbers[], int target) {

        int dp[][] = new int[numbers.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = numbers[i - 1];
                if (j >= v) {
                    if((j == v)){
                        dp[i][j] = 1 + dp[i-1][j-v] + dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i-1][j-v] + dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // return dp[numbers.length][target];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
               

                    System.out.print(dp[i][j] + " ");
    
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numbers[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        tabulation(numbers, target);
    }
}
