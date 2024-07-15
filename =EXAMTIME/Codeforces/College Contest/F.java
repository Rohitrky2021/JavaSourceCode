import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Number of signs
        long l = scanner.nextLong();  // Total distance between cities
        int k = scanner.nextInt();  // Maximum number of signs to remove

        long[] d = new long[n];  // Coordinates of signs
        long[] a = new long[n];  // Speed limits

        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        long[][] dp = new long[n][k + 1];

         for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

         dp[0][0] = 0;

         for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                 dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (d[i] - d[i - 1]) * a[i - 1]);

                 if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
       long check=Long.MAX_VALUE;
        // Find the minimum time to reach the destination
        long minTime = Long.MAX_VALUE;
        for (int j = 0; j <= k; j++) {
            check= Math.min(minTime, dp[n - 1][j] + (l - d[n - 1]) * a[n - 1]);
            if(check>-50) minTime = Math.min(minTime, dp[n - 1][j] + (l - d[n - 1]) * a[n - 1]);
            
        }


        System.out.println(minTime);
    }
}
