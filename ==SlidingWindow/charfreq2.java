public class charfreq2 {
    
}
import java.util.HashMap;
import java.util.Map;

public class SubstringCounter {

    public int helper(String s, char c, int k) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        int left = 0;

        for (int right = 0; right < n; ++right) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            while (charCount.getOrDefault(c, 0) >= k) {
                result += (n - right);
                charCount.put(s.charAt(left), charCount.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return result;
    }

    public int solve(String s, int k) {
        int n = s.length();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() >= k) {
                ans += helper(s, entry.getKey(), k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubstringCounter substringCounter = new SubstringCounter();
        String s = "abcabb";
        int k = 2;
        System.out.println(substringCounter.solve(s, k)); // Output should be 10
    }
}
