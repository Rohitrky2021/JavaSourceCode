import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of days
            int[] profit = new int[n]; // Array to store daily profits

            for (int i = 0; i < n; i++) {
                profit[i] = scanner.nextInt();
            }

            int maxProfit = Integer.MAX_VALUE;
            int totalProfit = 0;
            int maxProfitWithSkip = Integer.MIN_VALUE;
            

            for (int i = 0; i < n; i++) {
                maxProfit=Math.min(maxProfit, profit[i]);
                totalProfit+=profit[i];
                 

            }
            

            // int result = Math.max(maxProfit, maxProfitWithSkip);
            System.out.println(totalProfit-maxProfit);
        }

        scanner.close();
    }
}
