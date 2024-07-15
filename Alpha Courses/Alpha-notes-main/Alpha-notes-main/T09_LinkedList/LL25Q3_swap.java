package T09_LinkedList;

public class LL25Q3_swap {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node n = head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        Node m = head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        printLL(head);
        swapNode(head, n, m);
        printLL(head);
    }

    static void swapNode(Node head, Node n, Node m) {
        Node nPrev = null;
        Node mPrev = null;
        Node nNext = null;
        Node mNext = null;
        Node currPre = null;
        Node temp = head.next;
        while (temp != null) {
            if (temp == n) {
                nPrev = currPre;
                nNext = temp.next;
            }
            if (temp == m) {
                mPrev = currPre;
                mNext = temp.next;
            }
            currPre = temp;
            temp = temp.next;
        }

        m.next = nNext;
        n.next = mNext;
        if (nPrev != null) {
            nPrev.next = m;
        }
        if (mPrev != null) {
            mPrev.next = n;
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
}
