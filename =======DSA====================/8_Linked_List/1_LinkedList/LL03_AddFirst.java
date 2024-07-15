package T09_LinkedList;

public class LL03_AddFirst {
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
        LL03_AddFirst ll = new LL03_AddFirst();
        ll.addFirst(1);
        ll.addFirst(2);

    }
}