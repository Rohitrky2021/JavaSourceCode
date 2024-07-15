package T10_Stacks;

import java.util.*;

public class S05_reversStr {
    public static void main(String[] args) {
        String str = "Mukesh";
        System.out.println(reversStr(str));

    }

    public static String reversStr(String str) {
        StringBuilder ans = new StringBuilder("");
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            s.push(str.charAt(i++));

        }

        while (!s.isEmpty()) {
            ans.append(s.pop());
        }

        return ans.toString();

    }
}
