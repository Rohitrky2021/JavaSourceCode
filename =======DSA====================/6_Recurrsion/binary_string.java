import java.util.Scanner;

public class binary_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(countStrings(n));
        }
    }

    static long countStrings(int n) {
        long[] a = new long[n];
        long[] b = new long[n];
        a[0] = b[0] = 1;
        
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        
        return a[n - 1] + b[n - 1];
    }
}

// M2 Now using 2D DP 
 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(countStrings(n));
        }
    }

    static long countStrings(int n) {
        long[][] dp = new long[n + 1][2];

        // Initialize the base cases
        dp[1][0] = 1; // One-digit binary string ending with 0
        dp[1][1] = 1; // One-digit binary string ending with 1

        for (int i = 2; i <= n; i++) {
            // Calculate the count of binary strings of length i ending with 0
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];

            // Calculate the count of binary strings of length i ending with 1
            dp[i][1] = dp[i - 1][0];
        }

        // The total count is the sum of binary strings of length n ending with 0 and 1
        return dp[n][0] + dp[n][1];
    }
}
