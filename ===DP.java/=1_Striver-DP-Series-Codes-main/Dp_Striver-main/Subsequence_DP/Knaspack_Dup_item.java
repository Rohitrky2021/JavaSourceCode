package Subsequence_DP;

public class Knaspack_Dup_item {

    //Problem link - https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?page=2&status[]=unsolved&category[]=Dynamic%20Programming&sortBy=submissions

    //Question add - (Knaspack )any item pick infinty times (Unbounded Knaspack) *****

      //Recursion--(TC- 0(N^2) , SC-0(N))

      public static int rec(int i,int value[],int weight[],int maxWeight){
        
        if(i==0){

            if (weight[0] <= maxWeight) {
                int t = maxWeight / weight[0]; //divide then add value this time 
                int sum = 0;
                
                for (int k = 0; k < t; k++) {
                    sum += value[0];
                }

                //Short form for k loop  -- sum*t;
                return sum;
            } 
            
            return 0;
        }

        int take = 0;
        if(weight[i]<=maxWeight){
            take = value[i] + rec(i,value,weight,maxWeight-weight[i]);
        }

        int nontake = 0;
        nontake =  rec(i-1,value,weight,maxWeight);

        int max = Math.max(take, nontake);
        return max;
    }


    //Memory Optimization --=[ TC - 0(N * W) ,SC-0(N *W)+0(N)]
    public static int DP(int i,int value[],int weight[],int maxWeight,int dp[][]){
        
        if(i==0){
           if (weight[0] <= maxWeight) {
                int t = maxWeight / weight[0]; //divide then add value this time 
                int sum = 0;
                for (int k = 0; k < t; k++) {
                    sum += value[0];
                }

                 //Short form for k loop  --- sum*t;
                dp[i][maxWeight] = sum ;
                return sum;
            }
            
            
            return 0;
        }

        if(dp[i][maxWeight]!=-1){
            return dp[i][maxWeight];
        }

        int take = 0;
        if(weight[i]<=maxWeight){
            take = value[i] + DP(i,value,weight,maxWeight-weight[i],dp);
        }

        int nontake = 0;
        nontake =  DP(i-1,value,weight,maxWeight,dp);

        int max = Math.max(take, nontake);
        dp[i][maxWeight] = max;

        return max;
    } 



     //Tabulation --[ TC - 0(N * W) ,SC-0(N *W)
     public static int Tabu(int[] weight, int[] value, int n, int maxWeight) {

        //dp array size***(also for memorization)****
        int dp[][] = new int [n][maxWeight+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<maxWeight+1;j++){
                dp[i][j] = 0;
            }
        }

        
        for(int i=0;i<=maxWeight;i++){
           if (weight[0] <= i) {

                int t = i / weight[0]; //divide then add value this time 
                int sum = 0;
                for (int k = 0; k < t; k++) {
                    sum += value[0];
                }
                 //Short form for k loop  ---  sum*t;
                dp[0][i] = sum;
            } 
            else{
                dp[0][i] = 0;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=maxWeight;j++){

                int take = 0;
                if(weight[i]<=j){
                    take = value[i] + dp[i][j-weight[i]];
                }

                int nontake = 0;
                nontake = dp[i-1][j];

                int max = Math.max(take, nontake);
                dp[i][j] = max;

            }
        }

        return dp[n-1][maxWeight];

    }


    //Space Optimization ----[ TC - 0(N * W) ,SC-0(W)] 
    public static int knapSack(int n, int maxWeight, int value[], int weight[]) {
        int dp[] = new int[maxWeight + 1];


        //base case change 
        for (int i = 0; i <= maxWeight; i++) {
            if (weight[0] <= i) {
                int t = i / weight[0]; //divide then add value this time 
                int sum = 0;
                for (int k = 0; k < t; k++) {
                    sum += value[0];
                }
                 //Short form for k loop  --- sum*t;
                dp[i] = sum;
            } 
            else {
                dp[i] = 0;
            }

        }

        for (int i = 1; i < n; i++) {
            int curr[] = new int[maxWeight + 1];

            for (int j = 1; j <= maxWeight; j++) {

                int take = 0;
                if (weight[i] <= j) {
                    take = value[i] + curr[j - weight[i]]; //use current index for infinty use 
                }

                int nontake = 0;
                nontake = dp[j]; //prev index 

                int max = Math.max(take, nontake);
                curr[j] = max;

            }
            dp = curr;
        }

        return dp[maxWeight];
    }



    //More Space Optimization ----[ TC - 0(N * W) ,SC-0(W)] (*** ONLY 1D ARRAY SPACE ******)
    public static int SpaceOpti(int n, int maxWeight, int value[], int weight[]) {
        int dp[] = new int[maxWeight + 1];


        //base case change 
        for (int i = 0; i <= maxWeight; i++) {
            if (weight[0] <= i) {
                int t = i / weight[0]; //divide then add value this time 
                int sum = 0;
                for (int k = 0; k < t; k++) {
                    sum += value[0];
                }
                 //Short form for k loop  --- sum*t;
                dp[i] = sum;
            } 
            else {
                dp[i] = 0;
            }

        }

        for (int i = 1; i < n; i++) {
            

            for (int j = 1; j <= maxWeight; j++) {

                int take = 0;
                if (weight[i] <= j) {
                    take = value[i] + dp[j - weight[i]]; //use current index for infinty use 
                }

                int nontake = 0;
                nontake = dp[j]; //prev index 

                int max = Math.max(take, nontake);
                dp[j] = max;

            }
           
        }

        return dp[maxWeight];
    }

    public static void main(String[] args) {

    }
}
