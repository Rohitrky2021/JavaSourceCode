package T10_Stacks;

import java.util.*;

public class S03_stackCollectionFramwork {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.peek());
        s.push(5);
        s.push(6);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
