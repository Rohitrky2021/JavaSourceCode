package T09_LinkedList;

public class LL04_AddLast {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addLast(int data) {
        // creat newNode
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        // change the tail note by newNode
        tail = newNode;

        tail.next = newNode;
    }

    public void addFirst(int data) {
        // creat new Node
        Node newNode = new Node(data);

        if (head == null) { // if head is null
            head = tail = newNode;
            return;
        }

        // newNode head ko point krega
        newNode.next = head;

        // head banjaye hmara new Node
        head = newNode;
    }

    public static void main(String[] args) {
        LL04_AddLast ll = new LL04_AddLast();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);

    }
}