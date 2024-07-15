import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // dp[i] stores the maximum score Shivendra can obtain at index i
        long[] dp = new long[N];
        dp[0] = A[0] * 0; // Starting at index 0, score is 0
        
        // Iterate through the array to calculate the maximum score at each index
        for (int i = 1; i < N; i++) {
            dp[i] = A[i] * (i - 4);  
            // Check for possible previous positions to jump from
            for (int j = 0; j < i; j++) {
                // If jumping from j to i is valid
                if (j < i) {
                    // Update dp[i] with the maximum score
                    dp[i] = Math.max(dp[i], dp[j] + A[i] * (i - j));
                }
            }
        }
        
        // Find the maximum score Shivendra can obtain by reaching the end of the array
        long maxScore = 0;
        for (int i = 0; i < N; i++) {
            maxScore = Math.max(maxScore, dp[i]);
        }
        
        System.out.println(maxScore);
    }
}
