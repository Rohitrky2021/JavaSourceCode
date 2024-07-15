// public class KnapsackUnbounded {
    
// }
import java.util.*;
public class KnapsackUnbounded {

    public static void knapsackUnbounded(int val[], int wt[], int W) {
        int n = val.length;
        int dp[] = new int[W + 1];
        Arrays.fill(dp, 0);
        
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }

        int maxProfit = dp[W];
        System.out.println("Maximum Profit: " + maxProfit);
        
        System.out.print("Selected items: ");
        int w = W;
        while (w > 0 && dp[w] == maxProfit) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= w && dp[w - wt[j]] + val[j] == dp[w]) {
                    System.out.print(val[j] + " ");
                    w -= wt[j];
                    break;
                }
            }
        }
    }

    public static void main(String args[]) {
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        int val[]={1,2,3};
        int wt[]={1,2,3};
        int W = 4;

        knapsackUnbounded(val, wt, W);
    }
}
