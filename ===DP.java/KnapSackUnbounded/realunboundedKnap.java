

import java.lang.reflect.Array;
import java.util.Arrays;


    public class realunboundedKnap {



    public static int knapsack3Tabulatio(int val[],int sum,int dp[][]){
        for (int i = 1; i < val.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int v=val[i-1];

                if( v<=j ){
                    dp[i][j]=(dp[i][j-v]+dp[i-1][j]);

                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[val.length][sum];
    }

    public static void main(String args[]){
        int coin[]={1,2,3};
        int wt[]={4,2,7,1,3};//IN these Case Both val & Wt become equal;
        int W =4;
        int dp[][]=new int[coin.length+1][W+1];
        // Arrays.fill(dp, -1);
        // Arrays.fill(dp,-1);
        for (int i = 0; i < dp.length; i++) {
            // for(int j=0;j<dp[0].length;j++){
                dp[i][0]=1;
                // System.out.print(dp[i][j]);
            // }
            // System.out.println();
        }
        
        System.out.println(knapsack3Tabulatio(coin,W,dp));
        for (int i = 0; i < dp.length; i++) {
            System.err.println(Arrays.toString(dp[i]));
            
        }

    }
}
