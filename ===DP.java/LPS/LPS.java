public class LPS {
    
}


// palindromic substring in linear time, resulting in a time complexity of O(n),
//  where n is the length of the input string.

// Here's the implementation of Manacher's Algorithm in Java:
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // Modify the input string to insert special characters
        String modifiedString = preProcess(s);

        int n = modifiedString.length();
        int[] palindromeLengths = new int[n]; // Array to store the lengths of palindromic substrings
        int center = 0; // Center of the rightmost palindrome found
        int right = 0; // Right boundary of the rightmost palindrome found

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // Mirror position of the current position

            // Check if the current position is within the right boundary
            if (i < right) {
                palindromeLengths[i] = Math.min(right - i, palindromeLengths[mirror]);
            }

            // Expand around the current position
            while (modifiedString.charAt(i + (1 + palindromeLengths[i])) == modifiedString.charAt(i - (1 + palindromeLengths[i]))) {
                palindromeLengths[i]++;
            }

            // Update the right boundary and center if necessary
            if (i + palindromeLengths[i] > right) {
                center = i;
                right = i + palindromeLengths[i];
            }
        }

        int maxLength = 0; // Length of the longest palindromic substring
        int centerIndex = 0; // Center index of the longest palindromic substring

        for (int i = 1; i < n - 1; i++) {
            if (palindromeLengths[i] > maxLength) {
                maxLength = palindromeLengths[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLength) / 2;
        return s.substring(start, start + maxLength);
    }

    private static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }

        StringBuilder sb = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}

// ------------->>>>>>>// Dynamic Programming Approach


public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for substrings of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}
// ------------->>>>>>>// M2 Modified Dynamic Programming Approach---for space using 1D
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int n = s.length();
        int start = 0;
        int maxLength = 1;
        boolean[] dp = new boolean[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                // Check if characters at i and j are equal
                if (s.charAt(i) == s.charAt(j)) {
                    // If the substring has length less than or equal to 2, it is always a palindrome
                    // If the substring has length greater than 2, check if the inner substring is a palindrome
                    dp[j] = j - i + 1 <= 2 || dp[j - 1];
                } else {
                    dp[j] = false;
                }

                // Update start and maxLength if a longer palindrome is found
                if (dp[j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}



// ---------------->>>>>>>>>>>>>>// Expand Around Center Approach:
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}
// Both approaches provide solutions for finding the longest palindromic substring in a given string. The dynamic programming approach has a time complexity of O(n^2) and a space complexity of O(n^2), where n is the length of the input string. The expand around center approach has a time complexity of O(n^2) and a space complexity of O(1).