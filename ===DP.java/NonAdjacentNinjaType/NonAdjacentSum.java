import java.util.*;
// import Math.max as max;
public class NonAdjacentSum {
    public static int f(int idx,int dp[][],int arr[]){
        if(idx==0) return arr[idx];
        if(idx<0) return 0;
        if(dp[0][idx]!=-1){
            return dp[1][idx];
        }
        
        int pick=arr[idx]+f(idx-2, dp, arr);
        int notpick=0+f(idx-1, dp, arr);
        // dp[1][idx].
        return   dp[0][idx]=Math.max(pick, notpick);
    }
    static int maxsumnoadjancent(int dp[][],int arr[]){
        int n=dp.length;
        return f(n-1,dp,arr);
    }

    public static void main(String args[]){
        // int n=dp.length;

        int dp[][]=new int[3][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j]=-1;
            }
        }
        int arr[]={2,1,4};

        System.out.println(maxsumnoadjancent(dp, arr));
    }

}
