package T10_Stacks;

import java.util.Stack;

public class S06_reversStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        printStack(s);
        reverseStackBF(s);
        printStack(s);

    }

    public static void printStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            System.out.println();
            return;
        }

        int val = s.pop();
        System.out.print(val + " ");
        printStack(s);
        s.push(val);

    }

    public static void reverseStackBF(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int val = s.pop();
        reverseStackBF(s);
        pushAtBottum(s, val);
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
