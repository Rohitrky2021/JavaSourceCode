import java.util.HashMap;
import java.util.Map;

public class p2 {
    
    public int smallestLuckySubstring(int N, String S) {
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < N; right++) {
            char c = S.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            
            while (isValid(freqMap)) {
                // System.out.println(minLen);
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = S.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    
    private boolean isValid(Map<Character, Integer> freqMap) {
        int countA = freqMap.getOrDefault('A', 0);
        int countB = freqMap.getOrDefault('B', 0);
        int countC = freqMap.getOrDefault('C', 0);
        System.out.println(countA+" "+countB+" "+countC);
        return countA > countB && countA > countC && freqMap.size()>=2;
    }
    
    public static void main(String[] args) {
        p2 solution = new p2();
        int N1 = 5;
        String S1 = "ACACB";
        System.out.println(  solution.smallestLuckySubstring(N1, S1));  
        
        int N2 = 4;
        String S2 = "ACBA";
        System.out.println( solution.smallestLuckySubstring(N2, S2)); 
    }
}
