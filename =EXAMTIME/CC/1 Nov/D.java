import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        int testIndex = 0;
        while (testIndex < T) {
            int N = scanner.nextInt(); // Length of the array
            int K = scanner.nextInt(); // Subarray size
            int[] A = new int[N]; // Array elements

            int elementIndex = 0;
            while (elementIndex < N) {
                A[elementIndex] = scanner.nextInt();
                elementIndex++;
            }

            int count = 0;
            int subarrayIndex = 0;
            while (subarrayIndex <= N - K) {
                boolean oddFound = false;
                int subIndex = subarrayIndex;
                while (subIndex < subarrayIndex + K) {
                    if (A[subIndex] % 2 == 1) {
                        oddFound = true;
                        break;
                    }
                    subIndex++;
                }
                if (oddFound) {
                    count++;
                }
                subarrayIndex++;
            }

            System.out.println(count);
            testIndex++;
        }
    }
}
