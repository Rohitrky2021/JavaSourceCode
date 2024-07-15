

// public class LongestRepeatingCharacterReplacement {
    public class POINTERAPPROAch {
    public static void main(String[] args) {
        String s = "AAABBBA";
        int k = 2;

        int longestRepeating = characterReplacement(s, k);
        System.out.println("Length of longest repeating substring: " + longestRepeating);
    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCount = new int[26]; // To store the count of each character
        int maxCount = 0; // To keep track of the maximum repeating character count in the window
        int maxLength = 0; // To store the length of the longest repeating substring

        int left = 0; // Left pointer of the window
        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            charCount[rightChar - 'A']++; // Increment the count of the current character

            // Update the maximum repeating character count in the window
            maxCount = Math.max(maxCount, charCount[rightChar - 'A']);

            // If the window size (right - left + 1) exceeds the count of the repeating character (maxCount + k),
            // then we need to shrink the window from the left side
            while (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'A']--; // Decrement the count of the left character
                left++; // Move the left pointer to the right to shrink the window
            }

            // Update the maxLength with the current window size (right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
