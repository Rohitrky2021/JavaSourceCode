import java.util.HashMap;
import java.util.Map;

class B {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        int n = s.length();
        
        if (right + 1 < 3) return s.length();
        
        HashMap<Character, Integer> hs = new HashMap<>();
        
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : hs.entrySet()) {
            ans += entry.getValue() % 2==0?2:1;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        B solution = new B();
        
        System.out.println(solution.minimumLength("abaacbcbb")); // Expected Output: 5
        System.out.println(solution.minimumLength("aa")); // Expected Output: 2
    }
}
