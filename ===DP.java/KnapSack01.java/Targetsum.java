import java.util.Arrays;

public class Targetsum {
    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        int ans[][] = new int[n + 1][sum + 1];
        int deep[][] = new int[n + 1][sum + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];

                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                    ans[i][j]++;
                    deep[i][j] += deep[i - 1][j - v] + v;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                    ans[i][j]++;
                    deep[i][j] += deep[i - 1][j];
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------->");

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                System.out.print(deep[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(deep[n][sum]);
        return dp[n][sum];
    }

    public static void main(String args[]) {
        int arr[] = { 1,2,3 };
        int sum = 4;
        System.out.println(targetSum(arr, sum));
    }
}
