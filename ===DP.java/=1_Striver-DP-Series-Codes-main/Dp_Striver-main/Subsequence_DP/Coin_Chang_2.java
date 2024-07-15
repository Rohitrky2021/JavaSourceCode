package Subsequence_DP;

public class Coin_Chang_2 {

    // Question --- find the number of ways you can make target by using different
    // combinations from coins. (Infinite coins)

    // Recursion --(TC-0(2^N), SC-0(M)) -- N = number of coins , M = total amount
    public static long rec(int i, int n, int k, int arr[]) {

        if (k == 0) {

            return 1;
        }

        if (i == 0) {
            if (k % arr[0] == 0) {

                return 1;
            }

            return 0;
        }

        long take = 0;
        if (k >= arr[i]) {
            take = rec(i, n, k - arr[i], arr);
        }

        long nontake = rec(i - 1, n, k, arr);

        long t = take + nontake;

        return t;
    }

    // Memorization--(TC-0(N*M), Sc- 0(N*target)+0(N)) -- N = number of coins , M = total amount
    public static long DP(int i, int n, int k, int arr[], long dp[][]) {

        if (k == 0) {
            dp[i][k] = 1;
            return 1;
        }

        if (i == 0) {
            if (k % arr[0] == 0) {
                dp[i][k] = 1;
                return 1;
            }
            dp[i][k] = 0;
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        long take = 0;
        if (k >= arr[i]) {
            take = DP(i, n, k - arr[i], arr, dp);
        }

        long nontake = DP(i - 1, n, k, arr, dp);

        long t = take + nontake;
        dp[i][k] = t;
        return t;
    }

    // Tabulation---(TC-0(N*M), Sc- 0(N*target)) -- N = number of coins , M = total amount
    public static long countWaysToMakeChange(int arr[], int k){
		
		int n = arr.length;
        long  dp[][] = new long[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
                dp[i][j] = -1;
            }
        }


		//---------------------Tabulation-------------------

		//Base Case *
        for(int i=0;i<=k;i++){
             if(i%arr[0]==0){
                dp[0][i] = 1 ;
            }
        }

        

        //Nested loop = how many parametter change 
        for(int i=1;i<n;i++){

            for(int target=0;target<=k;target++){

                    long take = 0; //int take =0;
                    if(target>=arr[i]){
                        take = dp[i][target-arr[i]];
                    }

                    long nontake =  dp[i-1][target]; //int nontake = dp[i-1][target]
                
					long total= take+nontake;
					dp[i][target] = total;        
            }
        }

        return dp[n-1][k];
    }


    //Space Optimization --(TC-0(N*M), Sc- 0(M))) -- N = number of coins , M = total amount
    public static long Space(int arr[],int k){
        int n = arr.length;
        long dp[] = new long[k+1];
		for(int i=0;i<=k;i++){
            if(i%arr[0]==0){
                dp[i] = 1 ;
            }
        }


        //----------------Space Optimization
		for(int i=1;i<n;i++){
 
			long curr[] = new long [k+1];

            for(int target=0;target<=k;target++){

                    long take = 0; //int take =0;
                    if(target>=arr[i]){
                        take = curr[target-arr[i]];
                    }

                    long nontake =  dp[target]; //int nontake = dp[i-1][target]
                
					long total= take+nontake;
					curr[target] = total;        
            }

			dp = curr;
        }

        return dp[k];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,};
        System.out.println(Space(arr, 4));
    }
}
