import java.util.Arrays;

/*
 * Given two values M and N, which represent a matrix[M][N]. 
 * We need to find the total unique paths from the top-left 
 * cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).
 * At any cell we are allowed to move in only two directions:- bottom and right.
 */



public class _08gridUniquePath {
    public static void main(String[] args) {
        // given size of matrix 
        int m = 30;
        int n = 10;

        System.out.println("space opti : "+ solveSpaceOpti(m, n));
        System.out.println("tabu sol : "+ solveTabu(m, n));
        System.out.println("memo sol : "+solveMemo(m, n, 0, 0, new int[m][n]));
        System.out.println("rec sol  : " + solveRec(m,n, 0, 0));
    }

    public static int solveRec(int m,int n, int r, int c) {
        if(r >= m || c >= n) return 0;
        if(r == m-1 && c == n-1){
            return 1;
        }
        return solveRec(m, n, r+1, c) + solveRec(m, n, r, c+1);
    }
// Simple Recursion -- Tc-0(2^N*M) ,SC-0(N+M)(path length)
  // Or One which best match with Tabulation code 
    static int countWaysUtil(int i, int j, int[][] dp) {
         if (i == 0 && j == 0)  return 1;
         if (i < 0 || j < 0)   return 0;
         if (dp[i][j] != -1)   return dp[i][j];  

         int up = countWaysUtil(i - 1, j, dp);
         int left = countWaysUtil(i, j - 1, dp);

         return dp[i][j] = up + left;
    }
// Memorization + DP--(TC - 0(N*M) ,SC-0(N*M)+0(N+M))
    public static int solveMemo(int m, int n, int r, int c, int[][] dp){
        if(r >= m || c >= n) return 0;
        if(r == m-1 && c == n-1){
            return 1;
        }
        if(dp[r][c] !=0) return dp[r][c];
        return dp[r][c] = solveMemo(m, n, r+1, c, dp) + solveMemo(m, n, r, c+1, dp);
    }
// Tabulation ---(TC-0(N*M) . sc - 0(N*M))
    public static int solveTabu(int m, int n){
        int [][] dp = new int[m][n];
        for(int i=0; i<n; i++){
            dp[0][i] = 1;
        }
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j =1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            } 
        }
        return dp[m-1][n-1];
    }
// Tabulation + Space Optimization --(TC-0(N*M) , SC-0(M))
    public static int solveSpaceOpti(int m, int n){
        int prev[]=new int[n];
        for(int i=0; i<m; i++){
            int temp[]=new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }               
                int up=0;  int left =0; 
                  
                if(i>0)  up = prev[j];
                   
                if(j>0) left = temp[j-1];
                                      
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
