package T10_Stacks;

import java.util.*;

public class S04_pushAtBottum {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottum(s, 4);

        System.out.println();
    }

    public static void pushAtBottum(Stack<Integer> s, int n) {
        if (s.isEmpty()) {
            s.push(n);
            return;
        }
        int top = s.pop();
        pushAtBottum(s, n);
        s.push(top);
    }
}
