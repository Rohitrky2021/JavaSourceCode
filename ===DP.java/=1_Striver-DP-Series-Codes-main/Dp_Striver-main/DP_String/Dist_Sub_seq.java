package DP_String;

import java.util.*;
public class Dist_Sub_seq {

    //Concept -- String Matching (VVIP)
    //Question --- Distinct Sub-Sequence / String Matching 

    //Recursion ---tc-0(N^2) , sc- 0(N);
    public static int rec(int i,int j,String s1,String s2){
        
      
        if(j==-1){
            return 1;
        }
        if(j!=-1 && i==-1){
            return 0;
        }
        if(i==0){
           if(j==0 && s1.charAt(i)==s2.charAt(j)){
               return 1;
           }
           return 0;
        }

        //Match
        int match =0;
        if(s1.charAt(i)==s2.charAt(j)){
           
            int take = rec(i-1,j-1,s1,s2);
            int non = rec(i-1,j,s1,s2);
            match = take+non;
           
            return match;
        }
       
        //Non Match
        int nonmatch = rec(i-1,j,s1,s2);
        
        return nonmatch;
    }


    //Memorization --- Tc-(0(i*j) , Sc-0(i*j)*0(i*j) )
    public static int DP(int i,int j,String s1,String s2,int dp[][]){
        
      
        if(j==-1){
            return 1;
        }
        if(j!=-1 && i==-1){
            return 0;
        }
        if(i==0){
           if(j==0 && s1.charAt(i)==s2.charAt(j)){
               return 1;
           }
           return 0;
        }

        //Match
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int match =0;
        if(s1.charAt(i)==s2.charAt(j)){
           
            int take = DP(i-1,j-1,s1,s2,dp);
            int non = DP(i-1,j,s1,s2,dp);
            match = take+non;
            dp[i][j] = match;
            return match;
        }
       
        //Non Match
        int nonmatch = DP(i-1,j,s1,s2,dp);
        dp[i][j] = nonmatch;
        return nonmatch;
    }


    //Tabulation ----Tc-(0(i*j) , Sc-0(i*j))
    public static int numDistinct(String str, String sub) {
        
        int n = str.length();
        int m = sub.length();
        int dp[][] = new int [n+1][m+1];
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int j=1;j<=m;j++){
            dp[0][j] = 0;
        }

        if(str.charAt(0)==sub.charAt(0)){
             dp[1][1] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                    int match =0;
                    if(str.charAt(i-1)==sub.charAt(j-1)){
                    
                        int take = dp[i-1][j-1];
                        int non =  dp[i-1][j];
                        match = take+non;
                        dp[i][j] = match;
                       
                    }

                    else{
                        //Non Match
                        int nonmatch = dp[i-1][j];
                        dp[i][j] = nonmatch;
                        
                    }
            }
        }

        return dp[n][m];

    }

    //Space Optimization ----tc-0(i*j) , sc -0(j)
    public static int Space(String str, String sub) {
        
        int n = str.length();
        int m = sub.length();
        int dp[] = new int [m+1];
        
        dp[0] = 1;
      
        if(str.charAt(0)==sub.charAt(0)){
             dp[1] = 1;
        }

        for(int i=2;i<=n;i++){
            int curr[] = new int [m+1];
            curr[0] = 1;
            for(int j=1;j<=m;j++){
                    int match =0;
                    //Match
                    if(str.charAt(i-1)==sub.charAt(j-1)){
                    
                        int take = dp[j-1];
                        int non =  dp[j];
                        match = take+non;
                        curr[j] = match;
                       
                    }

                    else{
                        //Non Match
                        int nonmatch = dp[j];
                        curr[j] = nonmatch;
                        
                    }
            }

            dp = curr;
        }

        return dp[m];

    }



    //1d Space Optimization ---tc-0(i*j) , sc -0(j)
    public static  int Morespace(String str, String sub) {
        
        int n = str.length();
        int m = sub.length();
        int dp[] = new int [m+1];
       
        dp[0] = 1;
     

        if(str.charAt(0)==sub.charAt(0)){
             dp[1] = 1;
        }

        for(int i=2;i<=n;i++){
           
            for(int j=m;j>=1;j--){
                    int match =0;
                    //Match 
                    if(str.charAt(i-1)==sub.charAt(j-1)){
                    
                        int take = dp[j-1];
                        int non =  dp[j];
                        match = take+non;
                        dp[j] = match;
                       
                    }

                    else{
                        //Non Match
                        int nonmatch = dp[j];
                        dp[j] = nonmatch;
                        
                    }
            }

           
        }


        return dp[m];

    }
    public static void main(String[] args) {
        String s = "rabbbit"; String  t = "rabbit";
        System.out.println(Morespace(s, t));
    }
}
