import java.util.Arrays;
import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of TV sets
        int m = scanner.nextInt(); // Maximum number of TV sets Bob can carry

        int[] prices = new int[n]; // Array to store the prices of the TV sets

        // Read the prices of the TV sets
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Sort the array of prices in non-decreasing order
        Arrays.sort(prices);

        // Accumulate the prices of the m cheapest TV sets
        int maxMoney = 0;
        for (int i = 0; i < m; i++) {
            if (prices[i] < 0) {
                maxMoney -= prices[i]; // Add the absolute value of negative prices
            }
        }

        // Output the maximum sum of money Bob can earn
        System.out.println(maxMoney);

        scanner.close();
    }
}
