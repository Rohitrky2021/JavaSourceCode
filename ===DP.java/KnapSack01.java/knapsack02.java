import java.lang.reflect.Array;
import java.util.Arrays;

public class knapsack02 {

    public static int knapsack(int val[],int wt[],int W,int n,int dp[][]){
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W] !=-1){
            return dp[n][W];
        }
        // we are travelling from end to first
        if(wt[n-1]<= W){
            // include
          int ans1= val[n-1] + knapsack(val,wt,W-wt[n-1], n-1,dp) ;

            // exclude
          int ans2=  knapsack(val, wt, W, n-1,dp);
          dp[n][W]= Math.max(ans1, ans2);
          return dp[n][W];
        }
        else{//not valid
            dp[n][W] =knapsack(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }
//solution-->2 We use DP Table here with prefilled with -1;

 //3rd solution using the tabbulation with first row,colum be 0;
//  Esme bhi table whi rhega bus -->  DP[i][j]---> i=items + J=W(knapsack Size)-->Max profit;


    public static int knapsack3Tabulatio(int val[],int wt[],int W,int n,int dp[][],boolean selected[]){
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W] !=-1){
            return dp[n][W];
        }
        //we are travelling from end to first
        if(wt[n-1]<= W){
            // include
          int ans1= val[n-1] + knapsack(val,wt,W-wt[n-1], n-1,dp) ;

            // exclude
          int ans2=  knapsack(val, wt, W, n-1,dp);
          if (ans1 > ans2) {
            selected[n] = true;
            // ... your existing code ...
        } else {
            selected[n] = false;
            // ... your existing code ...
        }
          dp[n][W]= Math.max(ans1, ans2);
          return dp[n][W];
        }
        else{//not valid
            dp[n][W] =knapsack(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }

    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W =7;
        boolean selected[] = new boolean[val.length+1];
        int dp[][]=new int[val.length+1][W+1];
        // Arrays.fill(dp, -1);
        // Arrays.fill(dp,-1);
        for (int i = 0; i < dp.length; i++) {
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
                // System.out.print(dp[i][j]);
            }
            // System.out.println();
        }
        
        System.out.println(knapsack3Tabulatio(val,wt,W,5,dp,selected));
        for (int i = 0; i < dp.length; i++) {
            System.err.println(Arrays.toString(dp[i]));
            
        }
        System.out.println("----------------------------->");
        System.out.println(Arrays.toString(selected));
        for (int i = 1; i <= val.length; i++) {
            
            if (selected[i-1]) {
                System.out.print(val[i-1] + " ");
            }
        }

    }
}
