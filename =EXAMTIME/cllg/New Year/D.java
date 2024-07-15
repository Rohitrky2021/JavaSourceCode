import java.util.Arrays;
import java.util.Scanner;

public class HanumanSouvenirs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int[] baseCosts = new int[n];
        for (int i = 0; i < n; i++) {
            baseCosts[i] = scanner.nextInt();
        }

        // Solve the problem
        int k = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            int currentCost = baseCosts[i] + (i + 1) * k;
            if (totalCost + currentCost <= s) {
                totalCost += currentCost;
                k++;
            } else {
                break;
            }
        }

        // Print the result
        System.out.println(k + " " + totalCost);
    }
}
