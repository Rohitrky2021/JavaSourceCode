/**
 *******************************************************************************
 * Description: 
 * 
 * Given a string S, find the longest palindromic substring in S. You may 
 * assume that the maximum length of S is 1000, and there exists one 
 * unique longest palindromic substring.
 * 
 *******************************************************************************
 * Leetcode [005]
 */
package _14_LongestPalindromicSubstring;

/** Test method for {@link _14_LongestPalindromicSubstring.Solution } */
public class Solution {
    
    public String longestPalindrome(String s) {
        int longest = 0;
        int left = -1;
        int right = -1;
        int upper = 2 * s.length();
        int len = s.length();
        for (int i = 0; i < upper; i++) {
            int l = 0;
            int r = 0;
            if (i % 2 == 0) {
                // use A[i / 2] as center
                l = i / 2 - 1;
                r = i / 2 + 1;
            } else {
                // use gap betwen A[(i-1)/2] and A[(i+1)/2] as center
                l = (i - 1) / 2;
                r = (i + 1) / 2;
            }
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // palindrome length
            int length = r - l - 1;
            if (length > longest) {
                // update global max
                longest = length;
                left = l + 1;
                right = r - 1;
            }
        }
        return longest == 0 ? "" : s.substring(left, right + 1);
    }
    
}

