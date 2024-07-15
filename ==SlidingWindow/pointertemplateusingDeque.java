
import java.util.ArrayDeque;
import java.util.Deque;

// public class LongestRepeatingCharacterReplacement {
    public class pointertemplateusingDeque {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;

        int longestRepeating = characterReplacement(s, k);
        System.out.println("Length of longest repeating substring: " + longestRepeating);
    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCount = new int[26]; // To store the count of each character
        int maxCount = 0; // To keep track of the maximum repeating character count in the window
        int maxLength = 0; // To store the length of the longest repeating substring

        Deque<Integer> window = new ArrayDeque<>(); // Deque to store the indices of characters in the window

        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            charCount[rightChar - 'A']++; // Increment the count of the current character

            // Update the maximum repeating character count in the window
            maxCount = Math.max(maxCount, charCount[rightChar - 'A']);

            window.offerLast(right); // Add the current character's index to the window

            // If the window size (right - left + 1) exceeds the count of the repeating character (maxCount + k),
            // then we need to shrink the window from the left side
            while (right - window.peekFirst() + 1 - maxCount > k) {
                char leftChar = s.charAt(window.pollFirst());
                charCount[leftChar - 'A']--; // Decrement the count of the left character
            }

            // Update the maxLength with the current window size (right - left + 1)
            maxLength = Math.max(maxLength, right - window.peekFirst() + 1);
        }

        return maxLength;
    }
}
