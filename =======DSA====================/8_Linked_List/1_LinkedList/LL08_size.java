package T09_LinkedList;

public class LL08_size {
    public class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    
    public static Node head;
    public static Node tail;
    public static int size; // by defalt 0

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

    public void addLast(int data) {
        // creat newNode
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        // change the tail note by newNode
        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
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

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        LL08_size ll = new LL08_size();
        ll.addFirst(2); 
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();
        ll.add(2, 9);
        ll.print();
        System.out.println(size);
        

    }
}
