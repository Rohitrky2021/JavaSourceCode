package Subsequence_DP;

import java.util.*;

public class Coin_Change {

    // Question -- Count minimum coin to make a ful-fill amount (some coin give )

    //Same Questin - Minimum Element

    //---------- COING CHANGE USING 1D ARRAY--------------------

    // Recursion - (TC-0(2^n), SC-0(M)) -- N = number of coins , M = total amount
    public static int Reccoin(int amount, int coins[]) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int total = Reccoin(amount - coins[i], coins);

            if (total != Integer.MAX_VALUE && total != -1) {
                int ans = total;
                ans++;
                min = Math.min(ans, min);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;

    }

    // Memorization - (TC--0(M*N) ,SC- 0(n)+0(m)) N = number of coins , M = total
    // amount
    public static int dpcoin(int amount, int dp[], int coins[]) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        if (dp[amount] == -1) {
            for (int i = 0; i < coins.length; i++) {
                int total = dpcoin(amount - coins[i], dp, coins);

                if (total != Integer.MAX_VALUE && total != -1) {
                    int ans = total;
                    ans++;
                    min = Math.min(ans, min);
                }
            }

            if (min == Integer.MAX_VALUE) {
                return -1;
            }

        } else {
            min = dp[amount];
        }

        dp[amount] = min;
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;

    }

    // Tabulation -- (TC-0(M*N) ,SC-0(M)) N = number of coins , M = total amount
    public static int Tabcoin(int amount, int coins[]) {

        int dp[] = new int[amount + 1];

        /* TABULATION */
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                int t = i - coins[j];

                if (t >= 0 && dp[t] != Integer.MAX_VALUE) {
                    t = dp[t];
                    t++;
                    min = Math.min(t, min);
                }
            }

            dp[i] = min;
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];

    }



    //--------------- COING CHANGE USING SUB-SEQUENCE METHOD (TAKE , NON TAKE)----------------

    //Memorization -----(TC- 0(N*target) , Sc- 0(N*target)+0(N))
    public static int  rec(int i,int target,int coins[],int dp[][]){
        
        //Base case 
        if(target==0){
            return 0;
        }
        if(i==0){
            int coin = coins[0];
            if(target%coin==0){
                dp[i][target] = target/coin;
                return target/coin;
            }
            return Integer.MAX_VALUE;
        }

        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int take = Integer.MAX_VALUE;
        if(target>=coins[i]){
            //*** IF ANY PROBLEM COINS / VALUE IS USE INFINTY THEN THUMB RULE WHEN ANY INDEX TAKE THEN INDEX NOT CHANGE  */
            take =  rec(i,target-coins[i],coins,dp); // here index is same not change 
            if(take!=Integer.MAX_VALUE){
                take++;
            }
        }

        int nontake =  rec(i-1,target,coins,dp); //here index is change***
        

        int min = Math.min(take,nontake);
        dp[i][target] = min ;
        return min ;
        
    }



    //Tabulation  ----(TC- 0(N*target) , Sc- 0(N*target))
    public static int Tabulation(int coins[], int target) {

        int dp[][] = new int [coins.length][target+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<target+1;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
 
        //Base Case 
        
        for(int i=0;i<=target;i++){
             int coin = coins[0];
             if(i%coin==0){
                 dp[0][i] = i/coin;
                 
             }
        }
 
 
        for(int i=1;i<coins.length;i++){
            
            for(int j=0;j<=target;j++){
                
                 int take = Integer.MAX_VALUE;
                 
                 if(j>=coins[i]){
                     //*** IF ANY PROBLEM COINS / VALUE IS USE INFINTY THEN THUMB RULE WHEN ANY INDEX TAKE THEN INDEX NOT CHANGE  */
                     take = dp[i][ j-coins[i] ];   //(HERE INDEX  i )
                     if(take!=Integer.MAX_VALUE){
                         take++;
                     }
                 }
 
                 int nontake = dp[i-1][j]; //(if not taje then i-1 )
 
                 dp[i][j] = Math.min(take,nontake);
                 
            }
        }
 
        int ans = dp[coins.length-1][target];
        return ans==Integer.MAX_VALUE ? -1 : ans ;
 
     }


     //Space Optimization ----(TC- 0(N*target) , Sc- 0(target))
     public static int Space_Opti(int coins[], int target) {

       int dp[]  = new int [target+1];
       Arrays.fill(dp,Integer.MAX_VALUE);

       //Base Case 
       
       for(int i=0;i<=target;i++){
            int coin = coins[0];
            if(i%coin==0){
                dp[i] = i/coin;
                
            }
       }


       for(int i=1;i<coins.length;i++){
           
           int curr[] = new int [target+1];
           for(int j=0;j<=target;j++){
               
                int take = Integer.MAX_VALUE;
                
                if(j>=coins[i]){
                    //here also use current array not prev array index not change
                    take = curr[ j-coins[i] ];
                    if(take!=Integer.MAX_VALUE){
                        take++;
                    }
                }

                int nontake = dp[j]; //here use prev index 

                curr[j] = Math.min(take,nontake);
                
           }
           dp=curr;
       }

       int ans = dp[target];
       return ans==Integer.MAX_VALUE ? -1 : ans ;

    }

    public static void main(String[] args) {
       
       int amount =11; 
       int coins[] = {1,6,8};
       System.out.println(Tabcoin(amount,coins));
      
      

    }
}
