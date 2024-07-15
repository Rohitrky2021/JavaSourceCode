package DP_LIS;

import java.util.Arrays;

public class Long_Bit_seq {
    // Formula - 0-n LCS , n-0 Lcs then add and return maximum 
    public static int longestBitonicSequence(int[] a, int n) {
      
        // LCS 0 - n 
        int dp[] = new int [n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            int max =1;
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    int t  = dp[j];
                    t++;
                    max = Math.max(max,t);
                    dp[i] = max;
                }
                
            }
            
            
        }


        //  Lcs - N-0
        int back[] = new int [n];
        Arrays.fill(back,1);
        for(int i=n-1;i>=0;i--){
            int max =1;
            for(int j=n-1;j>i;j--){
                if(a[i]>a[j]){
                    int t  = back[j];
                    t++;
                    max = Math.max(max,t);
                    back[i] = max;
                }
                
            }
            
            
        }

        int ans =0;
        for(int i=0;i<n;i++){
            int max = dp[i]+back[i];
            max--; //common part this element **
            ans = Math.max(ans,max);
        }

        return ans;
        
        
    }
    public static void main(String[] args) {
        int prices[] = new int [6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 3;
        prices[4] = 6;
        prices[5] = 4;
        int n  = prices.length;
        System.out.println(longestBitonicSequence(prices, n));
    }
}
