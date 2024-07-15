package T11_Queues;

import java.util.*;
// https://leetcode.com/problems/implement-queue-using-stacks/submissions/?envType=daily-question&envId=2024-01-29

/**
 * Complexity Analysis
* There are two stacks solutions with different complexity time for push or pop operations:
** Approach #1 Push - O(n) per operation, Pop - O(1)  per operation.

** Approach #2 Push - O(1)O  per operation, Pop - Amortized O(1)  per operation.
 * @param x
 */

class qu05_usingStack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        boolean isEmpty() {
            return s1.isEmpty();
        }

        void add(int x) {    // *!   Push here O(N)
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
                // s1.pop();
            }

            // Push item into s1
            s1.push(x);

            // Push everything back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
                // s2.pop();
            }
        }

        // remove an item from the queue
        int remove() {
            // if first stack is empty
            if (s1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }

            // Return top of s1
            int x = s1.peek();
            s1.pop();
            return x;
        }

        int peek() {
            // if first stack is empty
            if (s1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }

            // Return top of s1

            return s1.peek();
        }
    }

    // Driver code
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}