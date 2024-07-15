//Two matrices A1 and A2 of dimensions [p x q] and [r x s] can only be multiplied if and only if q == r.
//The total number of multiplications required to multiply A1 and A2 are: p * q * s

//Pattern Identification:
//
//        Whenever we need to find the answer to a large problem such that the problem can be broken
//        into sub-problems and the final answer varies due to the order in which the sub-problems are solved,
//        we can think in terms of partition DP.

// int arr[] = [ 10, 20, 30, 40, 50 ]
// MATRIX A = 10x20, B = 20x30, C = 30x40, D = 40x50
//ABCD --->
//        A(BCD)  --> A (B (CD)) + A (BC) D
//        (AB)(CD) --> AB CD
//        (ABC)D  ---> ((AB) C) D + A(BC)D

// MATRIX A ALWAYS DENOTED BY ARR[1] BECAUSE ARR[0] * ARR[1] MAKE A MATRIX
// MATRIX N = ARR[N] * ARR[N-1];
//
// IF ( I == J) RETURN 0; BECAUSE NO  CALCULATION COST FOR 1D ARRAY
//FUNCTION(I, J) = FUNCTION(1, N-1)
//To summarize:
//
//        Represent the entire array by two indexes i and j. In this question i = 1 and j = n. We need to find f(i,j).
//        Maintain a mini variable to get the minimum answer.
//        Set a for loop to find the answer( variable k) from i to j-1,
//        In every iteration find the answer, with the formula discussed above and compare it with the mini value.
//        Return mini as the answer.

public class _48MatrixChainMultiplicationMCM {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int n = arr.length;
        int[][] dp = new int[n][n];
        System.out.println("memo : "+ memo(arr, 1, n-1, dp));

    }

    public static int memo(int[] arr, int i, int j, int [][] dp){
        if(i == j) return 0;
        if(dp[i][j] !=0) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int temp = arr[i-1] * arr[k] * arr[j] + memo(arr, i, k, dp) + memo(arr, k+1, j, dp);
            mini = Math.min(mini, temp);
        }
        return dp[i][j] = mini;
    }
}
