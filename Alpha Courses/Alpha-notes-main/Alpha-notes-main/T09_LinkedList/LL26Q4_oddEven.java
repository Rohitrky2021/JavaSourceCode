package T09_LinkedList;

public class LL26Q4_oddEven {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void oddEven(Node head) {
        Node t = head;
        Node last = new Node(-1);
        Node nxt = last;
        Node tail = head;
        while (t != null) {
            if (t.data % 2 == 1) {
                Node curr = new Node(t.data);
                nxt.next = curr;
                nxt = curr;
                t = t.next;
            }
            tail = t;
            if (t == null) {
                break;
            }
            System.out.println(t.data);
            t = t.next;

        }
        tail = last.next;
        System.out.println(tail.data);
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
        printLL(head);
        oddEven(head);
        printLL(head);

    }

}