
import java.util.*;
import java.util.Objects;

public class reverseString {

    // public class using_framework {

    public static void main(String arg[]) {
        // String s=new String()
        Stack<Character> s = new Stack<>();
        String str = new String("Rohit");

        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result = result.append(curr);
            // return result.toString();
        }
        str = result.toString();
        System.out.println(str);
        // while(!s.isEmpty()){
        // System.out.print(s.peek());
        // s.pop();
        // }
    }

    public static void pushatbottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatbottom(s, data);
        s.push(top);

    }

}
