import java.util.*;

public class PerfectSquare {
    public int numSquares(int n) {
        // Create an array to store the minimum number of perfect squares needed for each number up to n
        int[] dp = new int[n + 1];
        
        // Initialize the array with a maximum value
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;
        
        // Fill the array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {  //  j is recurssion waaala loop 
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        PerfectSquare solution = new PerfectSquare();
        int n = 12; // Example value, you can set any integer within the constraints
        
        System.out.println("The minimum number of perfect squares for " + n + " is: " + solution.numSquares(n));
    }
}
