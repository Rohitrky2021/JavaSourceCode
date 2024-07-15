public class ArrayDequeu {
    //  You can implement a stack with O(1) push 
    // and pop operations using the ArrayDeque class 
    // in Java, which is an implementation of a
    //  double-ended queue (deque). Here's how you
    //   can do it:

    import java.util.ArrayDeque;
import java.util.Deque;

class MyStack {
    private Deque<Integer> stackDeque;
    
    public MyStack() {
        stackDeque = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stackDeque.offerFirst(x);
    }
    
    public int pop() {
        if (stackDeque.isEmpty()) {
            // Handle stack underflow (throwing an exception)
            return -1; // Just a placeholder, you should handle underflow appropriately
        }
        return stackDeque.pollFirst();
    }
    
    public int top() {
        if (stackDeque.isEmpty()) {
            // Handle empty stack (throwing an exception)
            return -1; // Just a placeholder, you should handle empty stack appropriately
        }
        return stackDeque.peekFirst();
    }
    
    public boolean empty() {
        return stackDeque.isEmpty();
    }
}



}
