package DP_String;

import java.util.HashMap;

public class Long_Com_sequ {

      //Question -- Lowest Commoon Sub-sequence (VVIP ******)(LCS)

        
        // Recursion
        public static int rec(String s1, String s2, int i1, int i2) {
          if (i1 == 0 || i2 == 0) {
            return 0;
          }

          // Matching
          int match = 0;
          if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            match = 1 + rec(s1, s2, i1 - 1, i2 - 1);
            return match;

          }

          // Not Matching
          int one = 0 + rec(s1, s2, i1 - 1, i2);
          int two = 0 + rec(s1, s2, i1, i2 - 1);
          int max = Math.max(one, two);

          return max;
        }



        // Memorization (Tc -0(M*N) Sc - 0(N*M))
        public static int DP(String s1, String s2, int i1, int i2, int dp[][]) {

          if (i1 == 0 || i2 == 0) {
            return 0;
          }

          if (dp[i1][i2] != -1) {
            return dp[i1][i2];
          }

          // Matching
          int match = 0;
          if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            match = 1 + DP(s1, s2, i1 - 1, i2 - 1, dp);
            dp[i1][i2] = match;
            return match;

          }

          // Not Matching
          int one = 0 + DP(s1, s2, i1 - 1, i2, dp);
          int two = 0 + DP(s1, s2, i1, i2 - 1, dp);
          int max = Math.max(one, two);

          dp[i1][i2] = max;

          return max;
        }



      //Tabulation (Tc -0(M*N) Sc - 0(N*M))
      public static int lcs(String s1, String s2) {
          int n = s1.length();
          int m = s2.length();

          int dp[][] = new int[n + 1][m + 1];

          //--------------Tabulation--------------
          for (int i1 = 1; i1 <= n; i1++) {

            for (int i2 = 1; i2 <= m; i2++) {

              // Matching
              int match = 0;
              if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                match = 1;
                if (i1 - 1 >= 0 && i2 - 1 >= 0) {
                  match = 1 + dp[i1 - 1][i2 - 1];
                }

                dp[i1][i2] = match;
              } else {

                // Not Matching
                int one = 0;
                int two = 0;
                if (i1 - 1 >= 0 && i2 - 1 >= 0) {
                  one = 0 + dp[i1 - 1][i2];
                  two = 0 + dp[i1][i2 - 1];
                }

                int max = Math.max(one, two);
                // max = Math.max(match,max);
                dp[i1][i2] = max;
              }

            }
          }

          return dp[n][m];
        }



        //Space Optimization 
        public static int Space(String s1, String s2) {
          int n = s1.length();
          int m = s2.length();
      
          //-----------------Space Optimization------------------
          int dp[]= new int [m+1];
      
          for(int i1=1;i1<=n;i1++){
            int curr[] = new int [m+1];
            for(int i2=1;i2<=m;i2++){
      
              //Matching 
              int match =0;
              if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                match =1 ;
                if(i1-1>=0 && i2-1>=0 ){
                  match = 1+dp[i2-1] ;
                }
                  
                curr[i2] = match;
              }
              else{
      
              
                //Not Matching 
                int one =0;
                int two =0;
                if(i1-1>=0 && i2-1>=0 ){
                  one = 0+ dp[i2];
                  two = 0+ curr[i2-1];
                }
                
                int max = Math.max(one,two);
              //	max = Math.max(match,max);
                curr[i2] = max;
              }
      
      
            }
      
            dp = curr;
      
          }
      
          return dp[m];
        
      }



  public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
       
        System.out.println(Space(s1, s2));
       
        

        
       
  }

}
