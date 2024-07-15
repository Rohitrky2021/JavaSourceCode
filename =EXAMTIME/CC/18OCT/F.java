import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            int[] B = constructArrayB(N, M, A);

            // Print the result for this test case
            for (int i = 0; i < N; i++) {
                System.out.print(B[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static int[] constructArrayB(int N, int M, int[] A) {
        int[] B = new int[N];
        int[] frequency = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int[] availableNumbers = new int[M];
            int index = 0;
            for (int j = 1; j <= M; j++) {
                if (frequency[j] == 0) {
                    availableNumbers[index] = j;
                    index++;
                }
            }

            if (A[i] <= availableNumbers[index - 1]) {
                B[i] = A[i];
                frequency[A[i]]++;
            } else {
                B[i] = availableNumbers[index - 1];
                frequency[availableNumbers[index - 1]]++;
            }
        }

        return B;
    }
}
