package T09_LinkedList;

public class LL24Q2_deletNafterM {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // static void deletNafterMbyMe(int m, int n, Node head) {
    // if (head == null) {
    // return;
    // }
    // Node temp = head;
    // while (temp != null) {
    // Node prev = temp;
    // for (int i = 0; i < m; i++) {
    // prev = temp;
    // temp = temp.next;
    // }
    // for (int i = 0; i < n; i++) {

    // temp = deletNode(prev);
    // }
    // }
    // }

    // static Node deletNode(Node prev) {
    // if (prev == null || prev.next == null) {
    // return null;
    // }
    // prev.next = prev.next.next;
    // return prev.next;
    // }

    static void deletNafterM(int m, int n, Node head) {
        Node curr = head, t;

        while (curr != null) {
            for (int i = 0; i < m - 1 && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                return;
            }
            t = curr.next;
            for (int i = 0; i < n && t != null; i++) {
                t = t.next;
            }
            curr.next = t; //?
            curr = t;  //?
        }
    }

    static void printLL(Node head) {
        if (head == null) {
            System.out.println("the given list is Empty");
            return;
        }
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        printLL(head);
        deletNafterM(2, 2, head);
        printLL(head);
    }
}
