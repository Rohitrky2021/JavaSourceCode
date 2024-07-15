import java.util.Scanner;

public class C {

    public static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = arr[0];
        boolean isEvenParity = (arr[0] % 2 == 0);

        int currentSum = arr[0];

        for (int i = 1; i < n; i++) {
            boolean currentParity = (arr[i] % 2 == 0);

             if (currentParity != isEvenParity && currentSum>=0) {
                currentSum += arr[i];
             } else {
                maxSum = Math.max(maxSum, currentSum);
                currentSum = arr[i];
             }

             maxSum = Math.max(maxSum, currentSum);
 
             isEvenParity = currentParity;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Size of the array
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            int result = maxSubarraySum(arr);
            System.out.println(result);
        }
    }
}
