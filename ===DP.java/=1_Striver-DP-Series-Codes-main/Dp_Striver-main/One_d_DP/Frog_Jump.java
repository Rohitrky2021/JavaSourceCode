package One_d_DP;

import java.util.*;

public class Frog_Jump {

    //Similar question -- minimum cost to climbing stair ****

    //Simple Recusrion (Tc  - 0(2*n) ,Sc -0(n))
    public static int frogRec(int i,int n,int height[]){
        if(i<=0){
            return 0;
        }
       
       int one = frogRec(i-1,n,height)+Math.abs(height[i]-height[i-1]);
       int two =Integer.MAX_VALUE ;
       if(i>1){
           two = frogRec(i-2,n,height)+Math.abs(height[i]-height[i-2]);
       }
       if(two==-1){
           return one;
       }
       int ans = Math.min(one,two);
       return ans ;
        
    }

    // Using Memorization + Recursion Method ---Tc - 0(n) , Sc -0(n) (DP)
    public static int dpfrog(int i, int n, int dp[], int height[]) {
        if (i == 0) {
            return 0;
        }

        int one = 0;
        if (dp[i - 1] == -1) {

            one = dpfrog(i - 1, n, dp, height);

            one = one + Math.abs(height[i] - height[i - 1]);

        } else {
            one = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
        }

        int two = Integer.MAX_VALUE;
        if (i > 1) {
            if (dp[i - 2] == -1) {

                two = dpfrog(i - 2, n, dp, height);

                two = two + Math.abs(height[i] - height[i - 2]);

            } else {
                two = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
        }
        int ans = Math.min(one, two);

        dp[i] = ans;

        return ans;

    }

    //Tabulation solution - (Tc - 0(n) Sc - 0(1))
    public static int Tabfrog(int n,int height[]){
        int one = Math.abs(height[0]-height[1]);
        int two = 0;
        int ans =0;
        for(int i=2;i<n;i++){
            int currone = one +Math.abs(height[i]-height[i-1]);
            int currtwo = two+Math.abs(height[i]-height[i-2]);
            int min   = Math.min(currone,currtwo);
            if(i==n-1){
               ans = Math.min(currone ,currtwo);
            }
            two  = one ;
            one  =  min;
           
        }
        return ans;
     }
    

    public static void main(String[] args) {
        int height[] = {30,10,60,10,60,50};
        int dp[] = new int [height.length];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        int n = height.length;
        System.out.println(dpfrog(n-1, n, dp, height));

    }
}