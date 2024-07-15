import java.util.Stack;

public class revrseStack {
    // public static void isempty(){
    // return s
    // }
    public static void main(String arg[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverseStack(s);
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }

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

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            // s.push(data);
            return;
        }
        int top = s.pop();
        reverseStack(s);
        // s.pushatbottom(s,top);
        // return s;
        pushatbottom(s, top);

    }
}
