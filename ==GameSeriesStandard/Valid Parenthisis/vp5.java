import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
// https://leetcode.com/problems/remove-invalid-parentheses/description/
public class vp5 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> validStrings = new ArrayList<>();
        if (s == null || s.length() == 0) {
            validStrings.add("");
            return validStrings;
        }
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        boolean foundValid = false;
        
        queue.offer(s);
        visited.add(s);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (isValid(current)) {
                validStrings.add(current);
                foundValid = true;
            }
            
            if (foundValid) {
                continue;
            }
            
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') {
                    continue;
                }
                
                String newString = current.substring(0, i) + current.substring(i + 1);
                
                if (!visited.contains(newString)) {
                    queue.offer(newString);
                    visited.add(newString);
                }
            }
        }
        
        return validStrings;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        vp5 solution = new vp5();
        System.out.println(solution.removeInvalidParentheses("()())()"));  // Output: ["(())()","()()()"]
        System.out.println(solution.removeInvalidParentheses("(a)())()"));  // Output: ["(a())()","(a)()()"]
        System.out.println(solution.removeInvalidParentheses(")("));  // Output: [""]
    }
}



// M2 --> Pepcoding 
 

class Solution {

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<>();
        int minRemovals = getMin(s);
        removeInvalidParenthesesHelper(s, minRemovals, result);
        return new ArrayList<>(result);
    }

    private static void removeInvalidParenthesesHelper(String str, int mra, HashSet<String> ans) {
        if (mra == 0) {
           
            if (isValid(str)) {
                if (!ans.contains(str)) {
                    ans.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String l = str.substring(0, i);
            String r = str.substring(i + 1);
            removeInvalidParenthesesHelper(l + r, mra - 1, ans);
        }
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }


    private static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0) {
                    st.push(ch);
                } else if (st.peek() == ')') {
                    st.push(ch);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }
}
