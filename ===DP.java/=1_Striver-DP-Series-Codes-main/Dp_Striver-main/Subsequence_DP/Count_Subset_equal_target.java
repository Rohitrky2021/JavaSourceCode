package Subsequence_DP;

public class Count_Subset_equal_target {

    // Question --- count total subset sum equal to target

    // Recursion --TC -0(2^N) , Sc-0(N)
    public static int rec(int i, int n, int k, int arr[]) {

        

        if (i == 0) {

            // This is for arr value is contains 0
            if (k == 0 && arr[0] == 0) {
                return 2;
            }
            if (k == 0 || k == arr[0]) {
                return 1;
            }

            // This for arr value is not contains 0
            // if (arr[i] == k) {
            //     return 1;
            // }

            return 0;
        }

        int take = 0;
        if (k >= arr[i]) {
            take = rec(i - 1, n, k - arr[i], arr);
        }

        int nontake = rec(i - 1, n, k, arr);

        int total = take + nontake;
        return total;

    }



    // Memorization --(TC--- 0(N*target) ,SC -0(N*target)+0(N))
    public static int DP(int i, int n, int k, int arr[], int dp[][]) {

       
        if (i == 0) {
             // This is for arr value is contains 0
            if (k == 0 && arr[0] == 0) {
                return 2;
            }
            if (k == 0 || k == arr[0]) {
                return 1;
            }

            // This for arr value is not contains 0
            // if (arr[i] == k) {
            //     return 1;
            // }

            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int take = 0; // take
        if (k >= arr[i]) {
            take = DP(i - 1, n, k - arr[i], arr, dp);
        }

        int nontake = DP(i - 1, n, k, arr, dp); // non take

        // total count ****

        int total = take + nontake;
        dp[i][k] = total;
        return total;
    }




    // Tabulation ----(TC--- 0(N*target) ,SC -0(N*target) )
    public static int Tab(int n, int k, int arr[]) {
        int dp[][] = new int[n][k + 1];

        // ***********TABULATION****************

        //Base Case 
        //This is for arr contains 0 
        if(arr[0]==0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] =1;
        }

        if (arr[0]!=0 && arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        // Nested loop = how many parametter change
        for (int i = 1; i < n; i++) {

            for (int target = 0; target <= k; target++) {

                int take = 0;
                if (target >= arr[i]) {
                    take = dp[i - 1][target - arr[i]];
                }

                int nontake = dp[i - 1][target];

                int total = take + nontake;
                dp[i][target] = total;
            }
        }

        return dp[n - 1][k];

    }

    // Space Optimization ----(TC--- 0(N*target) ,SC -0(target) )
    public static int Space(int n, int k, int arr[]) {
        int dp[] = new int[k + 1];

         //This is for arr contains 0 
        if(arr[0]==0){
            dp[0] = 2;
        }
        else{
            dp[0] =1;
        }

        if (arr[0]!=0 && arr[0] <= k) {
            dp[arr[0]] = 1;
        }

      

        // Nested loop = how many parametter change
        for (int i = 1; i < n; i++) {
            int curr[] = new int[k + 1];
            for (int target = 0; target <= k; target++) {

                int take = 0;
                if (target >= arr[i]) {
                    take = dp[target - arr[i]];
                }

                int nontake = dp[target];

                int total = take + nontake;
                curr[target] = total;
            }
            dp = curr;
        }

        return dp[k];

    }

    public static void main(String[] args) {
            int arr[] = {0,0,1};
            int n= arr.length;
            System.out.println(Space(n, 1, arr));
    }
}
