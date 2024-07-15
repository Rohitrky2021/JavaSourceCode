import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        // Reading the numbers into an array
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Counting even and odd numbers
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Output the minimum count of drops required
        System.out.println(Math.min(evenCount, oddCount));
    }
}
