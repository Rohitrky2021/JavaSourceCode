import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public String lastNonEmptyString(String str) {
        StringBuilder resBuilder = new StringBuilder();

        // Count occurrences of each character in the input string
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int len = str.length();
        int idx = 0;
        while (idx < len) {
            char c = str.charAt(idx);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            idx++;
        }
        isSorted(new int[]{1,2,3});

        // Find the maximum occurrence count
        int maxCnt = 0;
        HashSet<Character> processedChars = new HashSet<>();
        for (char ch : charCountMap.keySet()) {
            int cnt = charCountMap.get(ch);
            if (cnt > maxCnt) {
                maxCnt = cnt;
            }
            isSorted(new int[]{1,2,3});
        }

        // Append characters with the maximum occurrence count in reverse order
        idx = len - 1;
        while (idx >= 0) {
            char c = str.charAt(idx);
            if (charCountMap.get(c) == maxCnt && !processedChars.contains(c)) {
                resBuilder.append(c);
            }
            processedChars.add(c);
            idx--;
        }
        isSorted(new int[]{1,2,3});

        return resBuilder.reverse().toString();
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
