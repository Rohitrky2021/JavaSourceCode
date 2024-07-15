import java.util.*;

public class D {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // Dimension of the matrix
            int[][] A = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }
            System.out.println(countStrangeMatrices(A, n));
        }
        scanner.close();
    }

    static int countStrangeMatrices(int[][] A, int n) {
        int[][] dp = new int[n + 1][(n * n) + 1];
        dp[0][0] = 1;

        // Count the number of filled elements
        int filledCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    filledCount++;
                }
            }
        }

        // Loop through each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] newDP = new int[n + 1][(n * n) + 1];
                for (int k = 0; k <= n; k++) {
                    for (int x = 0; x <= (n * n); x++) {
                        newDP[k][x] = dp[k][x];
                    }
                }
                for (int k = 0; k < n; k++) {
                    for (int x = 0; x <= (n * n); x++) {
                        if (dp[k][x] > 0) {
                            int newSum = x + (1 << (i * n + j));
                            if (A[i][j] == 0) {
                                newDP[k + 1][newSum] = (newDP[k + 1][newSum] + dp[k][x]) % MOD;
                            } else {
                                newDP[k][x] = (newDP[k][x] + dp[k][x]) % MOD;
                            }
                        }
                    }
                }
                dp = newDP;
            }
        }

        // Count the number of ways to fill the remaining zeros
        int result = 0;
        for (int x = 0; x <= (n * n); x++) {
            int remainingSum = (n * n) - x;
            if (remainingSum >= filledCount) {
                result = (result + dp[n][x]) % MOD;
            }
        }
        return result;
    }
}
