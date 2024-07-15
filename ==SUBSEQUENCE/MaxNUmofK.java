import java.util.*;

public class MaxNUmofK {
    public static String findLargestSubsequence(String input, int k) {
        if (k >= input.length()) {
            return input;
        }
    
        StringBuilder largestSubsequence = new StringBuilder();
    
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
    
          
                while (largestSubsequence.length() > 0 && currentChar > largestSubsequence.charAt(largestSubsequence.length() - 1)
                        && input.length() - i + largestSubsequence.length() > k) {
                    // Remove the last character if a larger digit is found
                    largestSubsequence.deleteCharAt(largestSubsequence.length() - 1);
                }
    
                if (largestSubsequence.length() < k) {
                    // Append the current digit if the subsequence length is less than k
                    largestSubsequence.append(currentChar);
                }
           
        }
    
        return largestSubsequence.toString();
    }
    
    public static void main(String[] args) {
        String input = "99123456789";
        int k = 4;
        String largestSubsequence = findLargestSubsequence(input, k);
        System.out.println("Largest Subsequence of length " + k + ": " + largestSubsequence);
    }
}