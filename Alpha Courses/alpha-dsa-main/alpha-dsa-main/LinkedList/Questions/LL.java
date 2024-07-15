package LinkedList.Questions;

public class LL {

    private int size;
    private Node head;
    private Node tail;

    public LL() {
        this.size = 0;
    }

    // RECURSIVE INSERTION IN LL
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }

        node.next = insertRec(value, index - 1, node.next);
        return node;
    }

    // REMOVE DUPLICATES FROM SORTED LINKED LIST
    public Node removeDuplicates(Node node) {
        if (node == null) {
            return node;
        }

        Node head = node;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }

        return head;
    }

    // MERGE TWO SORTED LL
    public Node merge(Node node1, Node node2) {
        Node ans = new Node();
        Node tail = ans;
        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                tail.next = node1;
                node1 = node1.next;
                tail = tail.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
                tail = tail.next;
            }
        }
        while (node1 != null) {
            tail.next = node1;
            node1 = node1.next;
            tail = tail.next;
        }
        while (node2 != null) {
            tail.next = node2;
            node2 = node2.next;
            tail = tail.next;
        }
        return ans.next;
    }

    // LINKED LIST CYCLE
    public boolean cycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // CYCLE LENGTH
    public int cycleLength(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
        }
        return 0;
    }

    // RETURN CYCLE STARTING POINT
    public Node cycleStartNode(Node head) {
        int length = cycleLength(head);
        if (length == 0) {
            return null;
        }

        Node s = head;
        Node f = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return f;
    }

    // HAPPY NUMBER
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }

    // FIND SUM OF SQUARES OF DIGITS IN A NUMBER
    private int findSquareSum(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            number = number / 10;
            ans = ans + rem * rem;
        }
        return ans;
    }

    // FIND MIDDLE NODE OF A LL
    public Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // MERGE SORT
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return merge(left, right);
    }

    private Node getMid(Node head) {
        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    // BUBBLE SORT
    public void bubbleSort(Node head) {
        bubbleSort(size - 1, 0, head);
    }

    private void bubbleSort(int row, int col, Node head) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1, head);
        } else {
            bubbleSort(row - 1, 0, head);
        }
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // RECURSION REVERSE
    public void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // IN PLACE REVERSAL OF LL
    public Node reverseInPlace(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = null;
        Node pres = head;
        Node next = pres.next;
        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    // REVERSE LL 2 (A PART OF THE LIST)
    public Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        Node curr = head;
        Node prev = null;
        for (int i = 0; i < (left - 1) && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        Node last = prev;
        Node newEnd = curr;

        // reverse b/w left and right
        Node next = curr.next;
        for (int i = 0; i < (right - left + 1) && curr != null; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;

        return head;
    }

    // PALINDROME LL
    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseInPlace(mid);
        Node rereverseHead = headSecond;

        while (head != null && headSecond != null) {
            if (head.value != headSecond.value) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverseInPlace(rereverseHead);
        return (head == null || headSecond == null);
    }

    // RE ORDER LL
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);
        Node hs = reverseInPlace(mid);
        Node hf = head;

        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if (hf != null) {
            hf.next = null;
        }
    }

    // REVERSE K-NODES IN LL
    public Node reverseKGroup(Node head, int k) {
        if (k == 1 || head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node next = curr.next;

        while (isSafe(curr, k)) {
            Node last = prev;
            Node newEnd = curr;

            for (int i = 0; i < k && curr != null; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;
            prev = newEnd;
        }
        return head;
    }

    private boolean isSafe(Node node, int k) {
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    // ROTATE LL
    public Node rotateLL(Node head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        Node last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newLast = head;

        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;
    }

    private class Node {
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int val) {
            this.value = val;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
