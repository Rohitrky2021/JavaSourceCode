public class vp4 {
    // https://leetcode.com/problems/longest-valid-parentheses/solutions/1027331/java-from-top-down-w-memo-to-bottom-up-dp-beats-100/

    class Solution1 {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);  // Initialize the stack with -1 as a starting point.
            int maxLen = 0;
    
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
    
                if (c == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);  // Starting pointa for the next valid substring.
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
    
            return maxLen;
        }
    }
    
    //M2==> using sliding window
    class Solution {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, maxLen = 0;
    
            // Forward pass - check from left to right
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxLen = Math.max(maxLen, 2 * right);
                } else if (right > left) {
                    left = right = 0;
                }
            }
    
            left = right = 0;
    
            // Backward pass - check from right to left
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxLen = Math.max(maxLen, 2 * left);
                } else if (left > right) {
                    left = right = 0;
                }
            }
    
            return maxLen;
        }
    }
    
    
}
