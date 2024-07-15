package T09_LinkedList;

public class LL20_zigzag {
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

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("the linkde list is Empty ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigzag() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node RH = prev;
        Node LH = head;
        Node Rnext, Lnext;

        while (RH != null && LH != null) {
            Lnext = LH.next;
            LH.next = RH;
            Rnext = RH.next;
            RH.next = Lnext;

            LH = Lnext;
            RH = Rnext;
        }
    }

    public static void main(String[] args) {
        LL20_zigzag ll = new LL20_zigzag();
        ll.add(6);
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.print();
        ll.zigzag();
        ll.print();
    }
}
