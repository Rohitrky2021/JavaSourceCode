import java.util.Arrays;
import java.util.Scanner;

public class C_minGreaterMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] coins = new int[n];
        
        // Read the coin values
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Sort the coin values in non-decreasing order
        Arrays.sort(coins);

        int sum = 0;
        int takenCoins = 0;

        // Calculate the total sum of all coins
        for (int coin : coins) {
            sum += coin;
        }
        int check=0;

        // Iterate through the sorted coins array to find the minimum number of coins needed
        for (int i = n - 1; i >= 0; i--) {
            takenCoins++;
            sum -= coins[i];
            check+=coins[i];
            // If the current sum is greater than the remaining sum, break the loop
            if (sum < check) {
                break;
            }
        }

        System.out.println(takenCoins);

        scanner.close();
    }

    // Helper function to calculate the sum of remaining coins
 
}
