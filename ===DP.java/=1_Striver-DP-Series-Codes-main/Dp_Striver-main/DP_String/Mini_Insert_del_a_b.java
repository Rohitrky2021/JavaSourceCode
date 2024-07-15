package DP_String;

public class Mini_Insert_del_a_b {

    // Question ---> Minimum Number of Deletions and Insertions to change string S1 -> S2 

    // Memorization ----LCS
    public static int rec(String s1, String s2, int i1, int i2, int dp[][]) {

        if (i1 == 0 || i2 == 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        // Matching
        int match = 0;
        if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            match = 1 + rec(s1, s2, i1 - 1, i2 - 1, dp);
            dp[i1][i2] = match;
            return match;

        }

        // Not Matching
        int one = 0 + rec(s1, s2, i1 - 1, i2, dp);
        int two = 0 + rec(s1, s2, i1, i2 - 1, dp);
        int max = Math.max(one, two);

        dp[i1][i2] = max;

        return max;
    }


    public static void main(String[] args) {

        String s1 = "2553432";
        String s2 = "2343552";

         s1.toLowerCase();
        int n = s1.length();
		int m = s2.length();
		
		
		int dp[][] = new int [n+1][m+1];

		for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = -1;
            }
        }

        //LCS (longest common sub-sequence )

        int lcs = rec(s1,s2.toString(),n,m,dp);


        //add this work  (Total minimum operation) 
        int first = n-lcs;
        int sec = m-lcs;
        int total = first+sec;
        System.out.println(total);


        //**ANOTHER QUESTION HOW MANY  DELETE AND INSERTION REQUEIRED INDIVIDUALY */

        int del = n-lcs;
        int insert = m-lcs;
        System.out.println("Delete requierd "+del);
        System.out.println("Insertion Required "+insert);

    }
}
