import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Length of the array
            int[] arr = new int[n]; // Array representing the taste of food

            // Read the elements of the array
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            // Create two arrays for even and odd indexes
            int[] evenArray = new int[n];
            int[] oddArray = new int[n];
            int evenIndex = 0;
            int oddIndex = 0;

            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    evenArray[evenIndex++] = arr[j];
                } else {
                    oddArray[oddIndex++] = arr[j];
                }
            }

            // Check if all elements in either array have the same parity
            boolean allEvenInEvenArray = allSameParity(evenArray, evenIndex);
            boolean allOddInOddArray = allSameParity(oddArray, oddIndex);

            // Output the result
            if (allEvenInEvenArray && allOddInOddArray) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // Helper function to check if all elements in an array have the same parity
    private static boolean allSameParity(int[] arr, int length) {
        if (length == 0) {
            return true;
        }
        int parity = arr[0] % 2;
        for (int i = 1; i < length; i++) {
            if (arr[i] % 2 != parity) {
                return false;
            }
        }
        return true;
    }
}
