package T10_Stacks;

import java.util.Stack;

public class S10_duplicateParentheses {
    public static void main(String[] args) {
        System.out.println(isDuplicate("((a+b))"));
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;

                }
                if (count == 0) {
                    return true;
                }

            } else {
                s.push(str.charAt(i));
            }
        }
        return false;
    }
}
