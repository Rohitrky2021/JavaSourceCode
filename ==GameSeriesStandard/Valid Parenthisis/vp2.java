// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description//
// Return the minimum number of moves required to make s valid.
 
// Input: s = "())"
// Output: 1

public class vp2 {
    class Solution {
        public int minAddToMakeValid(String s) {
               Stack<Character> stack = new Stack<>();
               int ans=0,a=0;
    
            for (char c : s.toCharArray()) {
                if (c == '(' ) {
                    a++;
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        ans++;
                        continue;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ) {
                        // return false;
                        ans+=2;
                    }
                }
           
            }
         return Math.abs(ans)+stack.size();
        }
    
    }   
}
