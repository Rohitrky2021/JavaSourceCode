package T10_Stacks;

public class S02_stackUsingLinkedList {
    public static void main(String[] args) {

        stack s = new stack();
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

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Stacks {
        Node head = null;

        boolean isEmpty() {
            return head == null;
        }

        void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        int pop() {
            if (isEmpty()) {
                System.out.println("the stack is empty");
                return Integer.MIN_VALUE;
            }

            int top = head.data;
            Node nextHead = head.next;
            head.next = null;
            head = nextHead;
            return top;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("the stack is empty");
                return Integer.MIN_VALUE;
            }

            return head.data;
        }
    }
}
