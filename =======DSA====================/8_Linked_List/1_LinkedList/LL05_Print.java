package T09_LinkedList;

class LL05_Print {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    void addFirst(int data) {
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

    void addLast(int data) {
        // creat newNode
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        // change the tail note by newNode
        tail.next = newNode;
        tail = newNode;

    }

    void print() {
        if (head == null) {
            System.out.println("the linkde list is Empty ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" null");
    }

    public static void main(String[] args) {
        LL05_Print ll = new LL05_Print();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();

    }
}