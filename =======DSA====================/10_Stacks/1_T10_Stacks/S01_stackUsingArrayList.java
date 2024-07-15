package T10_Stacks;

import java.util.ArrayList;

public class S01_stackUsingArrayList {

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

class stack {

    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return val;
    }

    public int peek() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return list.get(list.size() - 1);
    }

}
