package T11_Queues;

public class qu03_usingLL {
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.front());
            q.remove();
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class queue {
    static Node head;
    static Node tail;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    void add(int data) {

        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    void remove() {
        if (isEmpty() && head == null) {
            System.out.println("que is emply");

        }

        head = head.next;

    }

    int front() {
        if (isEmpty()) {
            System.out.println("que is emply");
            return -1;
        }
        return head.data;
    }
}