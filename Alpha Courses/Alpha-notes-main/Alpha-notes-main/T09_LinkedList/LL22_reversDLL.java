package T09_LinkedList;

public class LL22_reversDLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    public static int size;
    public static Node head;
    public static Node tail;

    public void addFirstDLL(int n) {

        Node newNode = new Node(n);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode; //
    }

    public void addLastDLL(int n) {
        Node newNode = new Node(n);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printDLL(Node head) {
        if (head == null) {
            System.out.println("dll is empty");
            return;
        }
        Node temp = head;

        System.out.print("null<-");
        while (temp.next != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println(temp.data + "->null");
    }

    public int removeFirstDLL() {
        if (head == null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        head.prev = null;
        return val;
    }

    public int removeLastDLL() {
        if (head == null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void reversDll() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LL22_reversDLL dll = new LL22_reversDLL();
        dll.addFirstDLL(1);
        dll.addFirstDLL(2);
        dll.addFirstDLL(3);
        dll.addFirstDLL(4);
        dll.printDLL(head);
        dll.reversDll();
        dll.printDLL(head);

    }
}
