class Solution{
    
    // as per gfg but idea is same


	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    
	    int[][] dp = new int[n+1][sum+1];
	    
	      dp[0][0]=1;
           for(int j=1;j<sum+1;j++)
           {
                   dp[0][j]=0;
               
           }
      for(int i=1;i<n+1;i++) 
          {
           for(int j=0;j<sum+1;j++)
           {
               if(arr[i-1]<=j)
               {
                   dp[i][j]=dp[i-1][j]%1000000007 + dp[i-1][j-arr[i-1]]%1000000007;
               }
               else{
                  dp[i][j]=dp[i-1][j]%1000000007; 
               }
           }
       }
       
       return dp[n][sum]%1000000007;
	    
	    
	    
	    // Your code goes here
	}
	
	
}


// Memorization + DP 

class Solution{
    public int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize the base case
        dp[0][0] = 1;
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        // Recursive function call
        return perfectSumRecursive(arr, n, sum, dp) % 1000000007;
    }

    private int perfectSumRecursive(int[] arr, int n, int sum, int[][] dp) {
        // Base case
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        // Check if the value is already computed
        if (dp[n][sum] != 0)
            return dp[n][sum];

        // Compute the perfect sum recursively
        if (arr[n - 1] <= sum) {
            dp[n][sum] = (perfectSumRecursive(arr, n - 1, sum, dp) % 1000000007 + perfectSumRecursive(arr, n - 1, sum - arr[n - 1], dp) % 1000000007) % 1000000007;
        } else {
            dp[n][sum] = perfectSumRecursive(arr, n - 1, sum, dp) % 1000000007;
        }

        return dp[n][sum];
    }
}
