package Subsequence_DP;

public class KnapSack_0_1 {

    //*******  IMPORTANT QUESTION  *****/

    //Recursion--(TC- 0(N^2) , SC-0(N))

    public static int rec(int i,int value[],int weight[],int maxWeight){
        
        if(i==0){
            if(weight[i]<=maxWeight){
                return value[i];
            }
            return 0;
        }

        int take = 0;
        if(weight[i]<=maxWeight){
            take = value[i] + rec(i-1,value,weight,maxWeight-weight[i]);
        }

        int nontake = 0;
        nontake =  rec(i-1,value,weight,maxWeight);

        int max = Math.max(take, nontake);
        return max;
    }

    //Memory Optimization --=[ TC - 0(N * W) ,SC-0(N *W)+0(N)]
    public static int DP(int i,int value[],int weight[],int maxWeight,int dp[][]){
        
        if(i==0){
            if(weight[i]<=maxWeight){
                return value[i];
            }
            return 0;
        }

        if(dp[i][maxWeight]!=-1){
            return dp[i][maxWeight];
        }

        int take = 0;
        if(weight[i]<=maxWeight){
            take = value[i] + DP(i-1,value,weight,maxWeight-weight[i],dp);
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
            if(weight[0]<=i){
                dp[0][i] = value[0];
            }
            else{
                dp[0][i] = 0;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=maxWeight;j++){

                int take = 0;
                if(weight[i]<=j){
                    take = value[i] + dp[i-1][j-weight[i]];
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
    public static int Space_opti(int[] weight, int[] value, int n, int maxWeight) {

        int dp[] = new int [maxWeight+1];
       
        
        for(int i=0;i<=maxWeight;i++){
            if(weight[0]<=i){
                dp[i] = value[0];
            }
            else{
                dp[i] = 0;
            }
            
        }

        for(int i=1;i<n;i++){
            int curr[] = new int [maxWeight+1];

            for(int j=0;j<=maxWeight;j++){

                int take = 0;
                if(weight[i]<=j){
                    take = value[i] + dp[j-weight[i]];
                }

                int nontake = 0;
                nontake = dp[j];

                int max = Math.max(take, nontake);
                curr[j] = max;

            }
            dp = curr;
        }

        return dp[maxWeight];

    }


    //More Space Optimize *** [ONLY ONE 1D ARRAY NEED ] --[ TC - 0(N * W) ,SC-0(W)]
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int dp[] = new int [maxWeight+1];
       
        for(int i=0;i<=maxWeight;i++){
            if(weight[0]<=i){
                dp[i] = value[0];
            }
            else{
                dp[i] = 0;
            }
            
        }

        for(int i=1;i<n;i++){
           // int curr[] = new int [maxWeight+1];

            for(int j=maxWeight;j>=0;j--){

                int take = 0;
                if(weight[i]<=j){
                    take = value[i] + dp[j-weight[i]];
                }

                int nontake = 0;
                nontake = dp[j];

                int max = Math.max(take, nontake);
                dp[j] = max;

            }
           // dp = curr;
        }

        return dp[maxWeight];

    }

        

    public static void main(String[] args) {
        //https://www.codingninjas.com/studio/problems/0-1-knapsack_920542?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

        int wieght [] = {2,1};
        int value[] = {1,1};
        int maxWeight = 3;

        System.out.println(rec(wieght.length-1, value, wieght, maxWeight));
    }
}
