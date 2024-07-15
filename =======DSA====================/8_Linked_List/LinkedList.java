import java.util.*;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    public static Node fast;

    public void addFirst(int data) {
        // step1 = create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step1 = create new node
        // Node newNode= new Node(data);

        // step2- newNode next=head
        newNode.next = head;// link

        // step-3 head=newnode
        head = newNode;

    }
    // public static void main(String args[]){
    // LinkedList<Integer> ll=new LinkedList<>();
    // ll.head=new Node(1);
    // ll.head.next=new Node(2);
    // ll.addFirst(3);
    // ll.addFirst(2);
    // ll.addFirst(1);
    // System.out.println(ll.data());
    // ll.addlast(3);
    // ll.addlast(2);
    // ll.addlast(1);
    // ll.printll(head);
    // deletefirst();
    // ll.addmiddle(5, 3);
    // ll.printll(head);
    // System.out.println(size);//4
    // deltill(5);
    // System.out.println(findkey(5));
    // System.out.println(recursearch(5));
    // ll.reverse();
    // ll.Nthdel(3);
    // ll.palindrom();
    // ll.printll(head);
    // System.out.println(ll.palindrom());

    // }
    public void addlast(int x) {
        Node newnode = new Node(x);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.data = x;
        tail.next = newnode;
        tail = newnode;

    }

    public void printll(Node head) {
        Node temp = head;
        if (head == null) {
            System.out.println("Null");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");

    }

    public void addmiddle(int x, int pos) {
        int count = 0;
        Node newNode = new Node(x);
        size++;
        while (count <= pos) {
            Node temp = head;
            if (pos == 0) {
                addFirst(x);
                // System.out.println("Null");;

                return;
            }

            else {
                temp = temp.next;

                if (count == pos) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                }
                count++;
            }
        }
    }

    public int deletefirst() {
        if (size == 0) {
            System.out.println("empty");
            // return;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            System.out.println(val);
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public void deltill(int pos) {

        for (int i = 0; i < pos; i++) {
            if (size == 0) {
                break;
            }
            deletefirst();
            size--;
        }
        // System.out.println(printll(head));
        printll(head);
    }

    public int findkey(int x) {
        Node temp = head;
        int i = 1;
        while (temp != null) {
            i++;
            temp = temp.next;
            if (temp.data == x) {
                System.out.println("Ur key " + x + " Is at :");
                return i;

            }

        }
        return -1;
    }

    //// ********** */
    public int recursearch(int key) {
        return helper(head, key);
    }

    // ********************** */
    /************** */
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    // rerverse the ll
    public void reverse() {
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

    // del teh Nth node from last
    public void Nthdel(int pos) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (pos == sz) {
            head = head.next;
            return;// remove first
        }
        // sz-n
        int i = 1;
        int itofind = sz - pos;
        Node prev = head;
        while (i < itofind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    // finding the mid
    public Node miid() {
        Node slow = head;
        // fast=0;
        fast = head;
        while (fast != null && fast.next != null) {
            // if (fast==null){
            // break;
            // }
            fast = fast.next.next;
            slow = slow.next;
        }
        // System.out.println(slow.data);
        // static m=slow.data;
        // System.out.println(ll.(slow));
        return slow;
    }

    private Node mid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;// ur slow is the mid
    }

    // ******//* // palindrome same from both side
    public boolean palindrom() {
        // mid();
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = miid();
        Node prev = null;
        Node curr = mid;// 2nd half ko reverse kurna hai
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node right = prev;// right half head
        Node left = head;
        // checking left an dthe right halfs
        while (right != null) {
            if (left.data != right.data) {
                return false;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        return true;

    }
    // public String longestPalindrome(LinkedList<Character> list) {
    // int maxLength = 0;
    // String longestPalindrome = "";
    // for (int i = 0; i < list.size(); i++) {
    // int left = i;
    // int right = i;
    // while (left >= 0 && right < list.size() &&
    // list.get(left).equals(list.get(right))) {
    // int currentLength = right - left + 1;
    // if (currentLength > maxLength) {
    // maxLength = currentLength;
    // longestPalindrome = list.sublist(left, right + 1).toString();
    // }
    // left--;
    // right++;
    // }
    // }
    // return longestPalindrome;
    // }

    private Node merge(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            } else {
                temp.next = head2;
                // temp.next=head1;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }
        System.out.println("ok");

        return merged.next;
    }

    // merge sort 2 linked list ********
    public Node mergesort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = mid(head);
        // left & right Ms
        Node right = middle.next;
        middle.next = null;
        Node newleft = mergesort(head);
        Node newright = mergesort(right);

        // merge
        return merge(newleft, newright);

    }

    // ********************************
    public static void main(String arg[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        // System.out.println(ll.mergesort(ll.head));
        // LinkedList ll2=new LinkedList();
        // ll2.addFirst(1);
        // System.out.println(head=ll.merge(head,head));
        // Node temp=ll.merge(head,head);
        // ll.printll(head);
        // ll.mergesort(head);
        // System.out.println(ll.mid(head));
        // head=ll.mergesort(head);
        ll.zigzag();

        ll.printll(head);
        // LCSlongestcommonsunsequence

    }

    // public String longestPalindrome(Node list) {
    // int maxLength = 0;
    // String longestPalindrome = "";
    // for (int i = 0; i < list.size(); i++) {
    // int left = i;
    // int right = i;
    // while (left >= 0 && right < list.size() &&
    // list.get(left).equals(list.get(right))) {
    // int currentLength = right - left + 1;
    // if (currentLength > maxLength) {
    // maxLength = currentLength;
    // longestPalindrome = list.sublist(left, right + 1).toString();
    // }
    // left--;
    // right++;
    // }
    // }
    // return longestPalindrome;
    // }
    public void zigzag() {
        Node midi = mid(head);
        Node curr = midi.next;
        midi.next = null;// todna hai tho
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // updation of heads
            left = nextL;
            right = nextR;

        }

    }

}
