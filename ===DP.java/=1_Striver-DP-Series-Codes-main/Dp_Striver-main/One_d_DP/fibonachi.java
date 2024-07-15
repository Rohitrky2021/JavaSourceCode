package One_d_DP;
import java.util.*;

public class fibonachi {

    //Similar Question - Counting Climbing Stairs *****

    // Using Memorization + Recursion  Method ---Tc - 0(n) , Sc -0(n) [DP]
    public static int fiboDp(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        //Top - down aproach 
        
        //Part -1 

        int one =0;
        //If dp array is empty then add value 
        if(dp[n-1]==-1){
            one = fiboDp(n-1,dp);
            dp[n-1] = one;
        }
        else{
            //if already present than use value 
            one = dp[n-1];
        }

        //Part -2 
        int two =0;
        if(dp[n-2]==-1){
            two = fiboDp(n-2,dp);
            dp[n-2] = two;
        }
        else{
            two = dp[n-2];
        }

        int total = one+two;
        return total ;
    }

    //Using Tabulation method - (TC- 0(n) , SC - 0(1))
    public static int fiboTab(int n){
        if(n==0 || n==1){
            return n;
        }
        //Bottom up 
        //Use two variable **
        int prev1 = 0;
        int prev2 = 1;
        int ans =0;
        for(int i=2;i<=n;i++){
            //curr position fibonachi number is (prev -1 )+ (prev-)
            ans = (prev1+prev2);
            //update value 
            //Prev1 is now prev2 
            prev1 = prev2;
            //prev2 is curr fibonachi 
            prev2 = ans;
        }

        return ans ;
    }
    public static void main(String[] args) {
        //Using Space Optimization Method ---Tc - 0(n) , Sc -0(n)
        int n = 4;
        int dp[] = new int [n+1];
        Arrays.fill(dp,-1);
        // //create a array and store all position fibo value so not extra recu call 
        // System.out.println(fiboDp(n,dp));

        // System.out.println(fiboTab(n));

        int zero =  1;
        int one = 1;
        int two = 2;
        for(int i=3;i<=n;i++){
            int curr = zero + one + two ;
            zero = one ;
            one = two ;
            two = curr;
        }

        System.out.println(two);
        System.out.println(4-2+1);

        
    }
}
