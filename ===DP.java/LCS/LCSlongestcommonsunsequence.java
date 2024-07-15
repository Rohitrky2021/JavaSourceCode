import java.util.*;
public class LCSlongestcommonsunsequence{
    public static int lcs(String str1,String Str2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1)==Str2.charAt(m-1)){//same
            return lcs(str1,Str2,n-1,m-1)+1;
        }
        else{
            //differnet
            int ans1=lcs(str1, Str2, n-1, m);
            int ans2=lcs(str1, Str2, n, m-1);
            return Math.max(ans1, ans2);
           
        }
    }

    public static int lcs2(String str1,String Str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
 
        if(dp[n][m] !=-1){
            return dp[n][m];
        }

        if(str1.charAt(n-1)==Str2.charAt(m-1)){//same
            return dp[n][m]=lcs2(str1,Str2,n-1,m-1,dp)+1;
        }  else{
            int ans1=lcs2(str1, Str2, n-1, m,dp);
            int ans2=lcs2(str1, Str2, n, m-1,dp);
            return dp[n][m]= Math.max(ans1, ans2);
        }

    }

    private int lcsmemo(int[] arr1, int[] arr2, int n, int m, int[][] memo) { //Checked and Working 
        if (n == 0 || m == 0) {
            return 0;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (arr1[n - 1] == arr2[m - 1]) {
            return memo[n][m] = 1 + lcs(arr1, arr2, n - 1, m - 1, memo);
        } else {
            int ans1 = lcs(arr1, arr2, n - 1, m, memo);
            int ans2 = lcs(arr1, arr2, n, m - 1, memo);
            return memo[n][m] = Math.max(ans1, ans2);
        }
    }

    public static int lcs3(String str1,String str2){

        int n=str1.length();
        int m=str2.length();
    
    int dp[][]=new int[n+1][m+1];
    for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i==0 || j==0){
                  dp[i][j]=0;
                }   
            }
    }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
        if(str1.charAt(i-1)==str2.charAt(j-1)){//same
             dp[i][j]=dp[i-1][j-1]+1;
        }else{
            int ans1=dp[i-1][j];
            int ans2=dp[i][j-1];
            dp[i][j]= Math.max(ans1, ans2);
        }
    }
 }
 return dp[n][m];
}

    public static void main(String args[]){

    //  ------>M! Recursion <---------   

        // String str1="abcdge";
        // String str2="abedg";
        // int n=st1.length();
        // int m=st1.length();

        // System.out.println(lcs2(str1, str2, str1.length(), str2.length()));

    //  ------>M 2 Recursion+Memoization  <---------   

        // String str1="abcdge";
        // String str2="abedg";
        // int n=st1.length();
        // int m=st1.length();
        // int dp[][]=new int[n+1][m+1];
        // for (int i = 0; i < n+1; i++) {
        //     for (int j = 0; j < m+1; j++) {
        //         dp[i][j]=-1;
        //     }
        // }
        // int dp[][]=new int[n+1][m+1];

        // System.out.println(lcs(str1, str2, str1.length(), str2.length()));

    //  ------>M 3 Recursion + Tabulation  <---------   
    int[] num=Arrays.copyOf(num);
    String s=num.toString();
    String s=Arrays.sort(num);


    String str1="abcdge";
    String str2="abedg";
    int n=str1.length();
    int m=str2.length();



    System.out.println(lcs3(str1, str2));

    }
    
}
