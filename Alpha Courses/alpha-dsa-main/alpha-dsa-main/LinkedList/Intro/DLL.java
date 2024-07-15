package LinkedList.Intro;

public class DLL {
    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    public void display() {
        if (head == null) {
            System.out.println("empty list");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public void insertFirst(int val) {
        Node node = new Node(val, head, null);

        if (head != null) {
            head.previous = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val, null, tail);

        tail.next = node;
        tail = node;

        size++;
    }

    public void insertAt(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = get(index - 1);
        Node node = new Node(val, temp.next, temp);
        temp.next = node;
        node.next.previous = node;
        
        size++;
    }

    public Node get(int index) {
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    private class Node {
        private Node previous;
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
