package DP_Partition;

public class Matrix_chain_multi {

    // Recursion
    public static int rec(int i, int j, int arr[]) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int t = (arr[i - 1] * arr[k] * arr[j]) + rec(i, k, arr) +
                    rec(k + 1, j, arr);
            min = Math.min(min, t);
        }
        // System.out.println(min);
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    // memorization - time = 0(N^3) . space- 0(N^2)
    public static int rec(int i, int j, int arr[], int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int t = (arr[i - 1] * arr[k] * arr[j]) + rec(i, k, arr, dp) +
                    rec(k + 1, j, arr, dp);
            min = Math.min(min, t);
        }

        if (min == Integer.MAX_VALUE) {
            dp[i][j] = min;
            return 0;
        }
        dp[i][j] = min;
        return min;
    }


    // Tabulation -- time = 0(N^3) . space- 0(N^2)
    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int [N][N];
        for(int i=0;i<N;i++){
           dp[i][i] = 0;
        }
        
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                int min =Integer.MAX_VALUE;
       
                for(int k=i;k<=j-1;k++){
                    int t = (arr[i-1]*arr[k]*arr[j])+ dp[i][k]+
                    dp[k+1][j];
                    min = Math.min(min,t);
                }
                
                if(min==Integer.MAX_VALUE){
                    dp[i][j] = min;
                    return 0;
                }
                dp[i][j] = min;
            }
        }
        
        return dp[1][N-1];
       
    }

    public static void main(String[] args) {

    }
}