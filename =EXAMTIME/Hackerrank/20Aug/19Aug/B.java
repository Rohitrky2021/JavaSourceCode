import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        // Reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine().trim());

        // The modulo value
        final int MOD = 1000000007;

        // DP array where dp[i][j] means number of ways to make sum i using j 4's
        int[][] dp = new int[S + 1][3];

        // Initializing the base case
        dp[0][0] = 1;

        // Iterate through each number 1, 2, 4, 6
        for (int i = 1; i <= S; i++) {
            for (int j = 0; j <= 2; j++) {
                // Adding 1
                if (i - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                // Adding 2
                if (i - 2 >= 0) dp[i][j] = (dp[i][j] + dp[i - 2][j]) % MOD;
                // Adding 6
                if (i - 6 >= 0) dp[i][j] = (dp[i][j] + dp[i - 6][j]) % MOD;
                // Adding 4
                if (j > 0 && i - 4 >= 0) dp[i][j] = (dp[i][j] + dp[i - 4][j - 1]) % MOD;
            }
        }

        // The result is the sum of ways to form S using at most 2 fours
        int result = 0;
        for (int j = 0; j <= 2; j++) {
            result = (result + dp[S][j]) % MOD;
        }

        // Output the result
        System.out.println(result);
    }
}
