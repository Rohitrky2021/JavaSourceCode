package StacksAndQueues.Questions;

import java.util.Stack;

//  THIS QUEUE IS REMOVE EFFICIENT, I.E. INSERT TAKES O(N) AND REMOVE TAKES O(1)

public class ImplementRemoveEfficientQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementRemoveEfficientQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(item);
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() {
        return first.pop();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() {
        return first.peek();
    }
}
