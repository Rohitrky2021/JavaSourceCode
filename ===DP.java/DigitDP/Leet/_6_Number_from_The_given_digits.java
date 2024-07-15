// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/?envType=list&envId=r8bvg0x3


 class Solution {
     private int[][][] dp; // Dynamic programming array to store computed values for optimization
 
     // Recursive function to count the number of valid combinations
     // idx: current index in the number string
     // tight: whether the number constructed so far is strictly less than the original number
     // num: string representation of the original number
     // atleast1Dig: whether there is at least one valid digit used so far
     // digits: array of digits available for construction
     private int count(int idx, boolean tight, String num, boolean atleast1Dig, String[] digits) {
         // Base case: If reached the end of the number, return 1 (a valid combination)
         if (idx == num.length()) return 1;
 
         // If the result for the current state is already computed, return it from dp array
         if (dp[idx][tight ? 1 : 0][atleast1Dig ? 1 : 0] != -1) return dp[idx][tight ? 1 : 0][atleast1Dig ? 1 : 0];
 
         // Initialize variables for lower and upper bounds of the current digit
         int lo = 0;
         int cnt = 0;
         int hi = tight ? num.charAt(idx) - '0' : 9;
 
         // If there is no restriction on using digits, add 1 to the count
         if (!atleast1Dig) {
             cnt += count(idx + 1, false, num, false, digits);
         }
 
         // Iterate through available digits
         for (String digit : digits) {
             int dig = digit.charAt(0) - '0';
             // If the current digit is greater than the upper bound, skip it
             if (dig > hi) continue;
             // Recursively count combinations with the current digit
             cnt += count(idx + 1, tight && (dig == hi), num, true, digits);
         }

    // we have use the below this Differnt way !!!

        //  // Iterate through available digits     
        //  for (int i = 0; i < digits.length; i++) {           
        //      int dig = digits[i].charAt(0) - '0';
        //      // If the current digit is greater than the upper bound, skip it
        //      if (dig > hi) {
        //          continue;
        //      }
        //      // Recursively count combinations with the current digit
        //      cnt += count(idx + 1, tight && (dig == hi), num, true, digits);
        //  }
         
 
         // Memoize the result and return
         return dp[idx][tight ? 1 : 0][atleast1Dig ? 1 : 0] = cnt;
     }
 
     // Main function to compute the number of combinations
     public int atMostNGivenDigitSet(String[] digits, int n) {
         // Initialize dp array with -1 values
         dp = new int[10][2][2];
         for (int i = 0; i < dp.length; i++) {
             for (int j = 0; j < dp[0].length; j++) {
                 for (int k = 0; k < dp[0][0].length; k++) {
                     dp[i][j][k] = -1;
                 }
             }
         }
 
         // Convert the number to a string
         String num = String.valueOf(n);
         // Call the count function with initial parameters and return the result
         return count(0, true, num, false, digits) - 1; // Subtract 1 as we don't count the original number itself
     }
 }
 