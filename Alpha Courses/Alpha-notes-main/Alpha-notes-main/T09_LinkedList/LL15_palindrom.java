package T09_LinkedList;

public class LL15_palindrom {

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
        size++;

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
        size++;
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
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) { // head == null;

            System.out.println("LL is Empty ");
            return Integer.MIN_VALUE;

        } else if (size == 1) { // head.next == null

            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;
        return val;

    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("the LL is empty ");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size = 0;
            int val = tail.data;
            head = tail = null;
            return val;
        }
        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        size--;
        int val = tail.data;
        prev.next = null;
        tail = prev;
        return val;
    }

    public int itrSearch(int key) {

        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int itr = helper(head.next, key);
        if (itr == -1) {
            return -1;
        }

        return 1 + itr;
    }

    public void revers() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node midNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("mid : = " + slow.data);
        return slow;
    }

    public boolean isPalindrom() {

        if (head == null || head.next == null) {
            return true;
        }
        Node mid = midNode();

        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node headFirst = head;
        Node headLast = prev;
        while (headLast != null && headLast != null) {
            if (headLast.data != headFirst.data) {
                return false;
            }
            headLast = headLast.next;
            headFirst = headFirst.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LL15_palindrom ll = new LL15_palindrom();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        System.out.println(ll.isPalindrom());

    }

}
