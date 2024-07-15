package LinkedList.Intro;

public class CLL {

    private int size;
    private Node head;
    private Node tail;

    public CLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void insertFirstOrLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void display() {
        Node temp = head;
        do {
            System.out.println(temp.val + " -> ");
            temp = temp.next;
        } while (temp == head);
        System.out.println("END");
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
