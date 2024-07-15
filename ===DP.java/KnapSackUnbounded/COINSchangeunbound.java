import java.lang.reflect.Array;
import java.util.Arrays;

public class COINSchangeunbound {



    public static boolean knapsack3Tabulatio(int val[],int sum,boolean dp[][]){
        for (int i = 1; i < val.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int v=val[i-1];

                if( v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;

                }
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        return dp[val.length][sum];
    }

    public static void main(String args[]){
        int coin[]={4,2,7,1,3};
        int wt[]={4,2,7,1,3};//IN these Case Both val & Wt become equal;
        int W =10;
        boolean dp[][]=new boolean[coin.length+1][W+1];
        // Arrays.fill(dp, -1);
        // Arrays.fill(dp,-1);
        for (int i = 0; i < dp.length; i++) {
            // for(int j=0;j<dp[0].length;j++){
                dp[i][0]=true;
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
