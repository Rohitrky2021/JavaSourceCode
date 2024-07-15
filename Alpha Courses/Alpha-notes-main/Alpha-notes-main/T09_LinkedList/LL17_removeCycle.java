package T09_LinkedList;

public class LL17_removeCycle {

    public static class Node {
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

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            Node prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    prev = fast;
                    fast = fast.next;
                    slow = slow.next;
                }
                prev.next = null;

            }
        }

    }

    public static void main(String[] args) {
        LL17_removeCycle ll = new LL17_removeCycle();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;
        ll.removeCycle();
        ll.print();

    }

}
