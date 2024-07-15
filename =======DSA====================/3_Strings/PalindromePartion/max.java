public class max {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        
        int start = 0;
        int maxLength = 1;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLength && isPalindrome(s, i, j)) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String input = "babasdsdad";
        String result = longestPalindrome(input);
        System.out.println("Longest palindromic substring: " + result);
    }
}
