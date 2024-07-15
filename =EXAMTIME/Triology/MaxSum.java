import java.util.ArrayList;
import java.util.Arrays;

class MaxSum {
    static int maxCostSubsequence(int N, int A[], int B[]) {
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = B[i];
        }
        int maxCost = 0;
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(A[j] >= A[i] - 1){
                    dp[i] = Math.max(dp[i], dp[j] + B[i]);
                }
            }
            maxCost = Math.max(maxCost, dp[i]);
        }
        return maxCost;
    }

    public static void main(String[] args) {
        int N = 7;
        int A[] = {-1, -2, -3, 4, 3, 2, 1};
        int B[] = {4, 6, 2, 3, 8, 4, 5};

        int result = maxCostSubsequence(N, A, B);
        
        // Calculate the sum of B elements for the selected indexes from A
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                sum += B[i];
            }
        }
        
        System.out.println("Maximum cost of subsequence: " + result); // Output: 23
        System.out.println("Sum of B elements for selected indexes: " + sum); // Output: 20
    }
}
