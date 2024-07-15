package T09_LinkedList;

public class LL23Q1_interSection {
    public Node head;
    public Node tail;
    public static int size;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    static Node interSection(Node h1, Node h2) {
        Node temp = h2;
        while (h1 != null) {
            h2 = temp;
            while (h2 != null) {
                if (h1 == h2) {
                    return h1;
                }
                h2 = h2.next;
            }
            h1 = h1.next;
        }
        return null;
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

    public static void main(String[] args) {
        Node head1, head2;
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(7);
        head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = head1.next.next.next;
        printLL(head1);
        printLL(head2);
        if (interSection(head1, head2) == null) {
            System.out.println("No inter section exist");
        } else {

            System.out.println(interSection(head1, head2).data);
        }
    }
}
