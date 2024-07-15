import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // Number of elements in the array
            int[] array = new int[n]; // Array to store the elements

            // Input array elements
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            // Brute force approach to find the minimum number of operations
            int minOperations = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int operations = 0;
                for (int j = 0; j < n; j++) {
                    operations += Math.abs(array[i] - array[j]);
                }
                minOperations = Math.min(minOperations, operations);
            }

            System.out.println(minOperations);
        }

        scanner.close();
    }
}
