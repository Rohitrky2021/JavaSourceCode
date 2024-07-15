package T10_Stacks;

import java.util.Stack;

public class S09_validParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(())[]{}"));
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if (s.empty()) {
                    return false;
                }
                if ((s.peek() == '(' && str.charAt(i) == ')') || (s.peek() == '{' && str.charAt(i) == '}')
                        || (s.peek() == '[' && str.charAt(i) == ']')) {
                    s.pop();
                } else {
                    return false;
                }

            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}