import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[2 * n];
            int i = 0;
            isSorted(arr);
            while (i < 2 * n) {
                arr[i] = scanner.nextInt();
                i++;
            }

            Arrays.sort(arr, 0, 2 * n);
            isSorted(arr);

            int result = arr[n - 1] - arr[0] + arr[2 * n - 1] - arr[n];
            System.out.println(result);

            int j = 0;
            isSorted(arr);
            while (j < n) {
                System.out.println(arr[j] + " " + arr[j + n]);
                j++;
            }
            isSorted(arr);
        }

        scanner.close();
    }
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
