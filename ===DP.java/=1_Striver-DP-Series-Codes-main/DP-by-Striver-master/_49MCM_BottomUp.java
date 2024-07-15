//1. copy the base case of recursion
//2. for loops for changing states (here i and j in this quesiton)
//3. copy the recursive part

public class _49MCM_BottomUp {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int n = arr.length;
        System.out.println("tabu : "+ tabu(arr, n));
    }

    public static int tabu(int[] arr, int n){
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) dp[i][i] = 0;

        for(int i=n-1; i>=1; i--){
            for(int j=i+1; j<n; j++){ // i < j always
                int mini = Integer.MAX_VALUE;
                for(int k = i; k<j; k++){
                    int temp = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini, temp);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
}
