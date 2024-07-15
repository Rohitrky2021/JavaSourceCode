import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of days
        int[] a = new int[n]; // Array to store the money made each day

        // Read the money made each day
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Initialize variables
        int maxLength = 1; // Maximum length of non-decreasing subsegment
        int currentLength = 1; // Current length of non-decreasing subsegment

        // Iterate through the array of money made each day
        for (int i = 1; i < n; i++) {
            // Check if the current day's money is greater than or equal to the previous day's money
            if (a[i] >= a[i - 1]) {
                // If so, increment the current length of non-decreasing subsegment
                currentLength++;
            } else {
                // Otherwise, update the maximum length found so far and reset the current length
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        // Update the maximum length found so far with the last non-decreasing subsegment
        maxLength = Math.max(maxLength, currentLength);

        // Output the maximum length of non-decreasing subsegment
        System.out.println(maxLength);

        scanner.close();
    }
}
