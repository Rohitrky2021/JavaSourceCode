import java.util.*;

class Solution {
    public String clearDigits(String s) {
        // Convert the string to a list of characters
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }

        boolean digitFound;
        do {
            digitFound = false;
            for (int i = 0; i < charList.size(); i++) {
                if (Character.isDigit(charList.get(i))) {
                    digitFound = true;
                    charList.remove(i);  // Remove the digit
                    if (i > 0) {
                        charList.remove(i - 1);  // Remove the closest non-digit to the left
                    }
                    break;  // Restart the search after modification
                }
            }
        } while (digitFound);

        // Build the resulting string from the list of characters
        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            result.append(c);
        }
        return result.toString();
    }
}
