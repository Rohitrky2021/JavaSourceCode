class Solution {
    public int minimumPushes(String word) {
        // Create a frequency array to count the occurrences of each letter
        int[] freq = new int[26];
        
        // Count the occurrences of each letter in the word
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // Define the remapped keypad
        // Here, we're considering each letter from 'a' to 'z' mapped to its respective key
        int[] keyPushes = {1, 2, 3, 1, 2, 3, 1, 2, 3,1, 2, 3, 1, 2, 3, 1, 2, 3,4, 1, 2, 3,   1, 2, 3,4};
        
        int totalPushes = 0;
        
        // Sum up the minimum number of pushes for each letter
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                totalPushes += freq[i] * keyPushes[i];
            }
        }
        
        return totalPushes;
    }
}
