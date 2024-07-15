public class Stackusing2queue {
    class MyStack {
        //     There are two solutions cost O(n) and O(1) for different operations:
    
        // push: O(n), pop/top: O(1)
        // push: O(1), pop/top: O(n)
        // Time efficiency depends on operation frequency of push, pop, top:
        // if push>pop+top, second solution is better.
        // if push<pop+top, first solution is better.
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        private int top;
    
        // Push element x onto stack.
    
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            top = 0; // Initialize top to some default value
        }
    
        public void push(int x) {
            q1.add(x);
            top = x;
        }
    
        // Removes the element on top of the stack.
    public int pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int poppedValue = q1.remove(); // Remove the last element
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return poppedValue; // Return the popped value
    }
    
    
        public int top() {
            return top;
        }
    
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
    // M2--->Using 1 Qeueu;
    class MyStack {
      public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; ++i)
          q.offer(q.poll());
      }
    
      public int pop() {
        return q.poll();
      }
    
      public int top() {
        return q.peek();
      }
    
      public boolean empty() {
        return q.isEmpty();
      }
    
      private Queue<Integer> q = new ArrayDeque<>();
    }
    
    
    
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    
}
