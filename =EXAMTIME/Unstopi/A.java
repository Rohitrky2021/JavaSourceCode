import java.util.*;

public class A {
    
    public static int maxLengthSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                int len = j - i + 1;
                if (len <= maxLen) break; 
                
                if (isRepeatingSubstring(s.substring(i, j + 1))) {
                    maxLen = len;
                }
            }
        }
        
        return maxLen;
    }
    
    public static boolean isRepeatingSubstring(String str) {
        int n = str.length();
        if (n % 2 != 0) return false;  
        
        int halfLen = n / 2;
        String firstHalf = str.substring(0, halfLen);
        String secondHalf = str.substring(halfLen);
        
        for (int i = 0; i < halfLen; i++) {
            if (firstHalf.charAt(i) != '?' && secondHalf.charAt(i) != '?' && firstHalf.charAt(i) != secondHalf.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String s = "ab?cd"; // Example input string
        int maxLength = maxLengthSubstring(s);
        System.out.println("Max length of repeating substring: " + maxLength);
    }
}



class Solution {
    public int minIncrements(int n, int[] cost) {
        
        
        int ans = 0;

        for (int i = n; i >= 1; i--) {
            if (i <= n/2) {
                ans += Math.abs(cost[2 * i - 1] - cost[2 * i]);
                cost[i-1] = cost[i-1] + Math.max(cost[2 * i - 1], cost[2 * i]) ;
            }
           
        }
        
        return ans;
    }
}