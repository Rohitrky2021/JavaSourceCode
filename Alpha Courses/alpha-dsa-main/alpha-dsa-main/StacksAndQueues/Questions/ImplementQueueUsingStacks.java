package StacksAndQueues.Questions;

import java.util.Stack;

//  THIS QUEUE IS INSERT EFFICIENT, I.E. INSERT TAKES O(1) AND REMOVE TAKES O(N)

public class ImplementQueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int remove() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

}