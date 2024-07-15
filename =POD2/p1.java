public class p1 {
    
}
import java.util.Stack;

class Solution {
    public String makeGood(String s) {

        char[] st = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        stk.push(st[0]);

        for (int i = 1; i < st.length; i++) {
            if (!stk.isEmpty() && Math.abs(stk.peek() - st[i]) == 32) {
                stk.pop();
            } else {
                stk.push(st[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stk) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
