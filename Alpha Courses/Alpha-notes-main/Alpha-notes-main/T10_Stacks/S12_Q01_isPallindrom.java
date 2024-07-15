package T10_Stacks;

import java.util.Stack;

public class S12_Q01_isPallindrom {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        // head.next.next.next.next.next = new Node(1);

        boolean ans = isPallindrom(head);
        System.out.println(ans);

    }

    public static boolean isPallindrom(Node head) {
        Stack<Integer> s = new Stack<>();
        Node temp1 = head;
        Node temp2 = head;

        while (temp1 != null) {
            s.push(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (s.pop() != temp2.data) {
                return false;
            }
            temp2 = temp2.next;
        }

        return true;
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}