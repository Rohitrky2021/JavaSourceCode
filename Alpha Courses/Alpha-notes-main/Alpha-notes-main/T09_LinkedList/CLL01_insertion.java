package T09_LinkedList;

public class CLL01_insertion {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        Node newNode = new Node(data);
        newNode.next = newNode;

        return newNode;
    }

    static Node addFirst(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    static Node addEnd(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    static Node addAfter(Node last, int item, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node temp = last.next;
        // while (temp != last) {
        //     if (temp.data == item) {
        //         Node newNode = new Node(data);
        //         newNode.next = temp.next;
        //         temp.next = newNode;
        //         return last;
        //     }
        //     temp = temp.next;
        // }
        // if (item == last.data) {
        //     return addEnd(last, data);
        // }

        do {
            if (temp.data == item) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == last) {
                    last = newNode;
                }
                return last;
            }
            temp = temp.next;
        } while (temp != last.next);

        System.out.println("no item exist");
        return last;
    }

    static Node deletNode(Node last, int key) {
        if (last == null) {
            return last;
        }
        if (last.data == key && last.next == last) {
            last = null;
            return last;
        }
        Node temp = last.next;
        Node prev = last;

        while (temp != last) {
            if (temp.data == key) {
                prev.next = temp.next;
                temp.next = null;
                return last;
            }
            prev = temp;
            temp = temp.next;
        }
        if (last.data == key) {
            prev.next = temp.next;
            temp.next = null;
            last = prev;
        }
        return last;
    }

    static void travers(Node last) {
        if (last == null) {
            System.out.println("the list is null");
            return;
        }
        Node temp = last.next;

        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }

    public static void main(String[] args) {
        Node last = addEnd(null, 1);
        last = addEnd(last, 1);
        last = addEnd(last, 2);
        last = addEnd(last, 3);
        last = addEnd(last, 4);
        last = addEnd(last, 5);
        travers(last);
        last = addAfter(last, 3, 10);
        travers(last);
        last = deletNode(last, 1);
        travers(last);
    }
}
