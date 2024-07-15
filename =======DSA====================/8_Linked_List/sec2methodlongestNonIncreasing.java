import java.util.Scanner;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;
}

public class sec2methodlongestNonIncreasing {
    static SinglyLinkedListNode push(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode();
        newNode.data = data;
        newNode.next = head;
        return newNode;
    }

    static int logab(long a, long b) {
        int ans = 0;
        while (a > 1) {
            a /= b;
            ans++;
        }
        return ans;
    }

    static void solve() {
        SinglyLinkedListNode head = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            head = push(head, num);
        }

        int till = 1, max = 1;
        int tc = 1;
        int ind = 0;
        int i = 0;
        SinglyLinkedListNode prev = head;
        SinglyLinkedListNode curr = head.next;
        while (curr != null) {
            if (prev.data >= curr.data) {
                till++;
            } else {
                if (max < till) {
                    max = till;
                    ind = tc - till;
                }
                till = 1;
            }
            tc++;
            prev = curr;
            curr = curr.next;
        }

        if (max < till) {
            max = till;
            ind = tc - max;
        }

        curr = head;
        for (; curr != null; curr = curr.next) {
            if (i == ind) {
                int f = 0;
                int dg = curr.data;
                SinglyLinkedListNode temp = new SinglyLinkedListNode();
                temp.data = dg;
                SinglyLinkedListNode ans = temp;
                while (max > 0) {
                    if (f == 0) {
                        f = 1;
                        max--;
                        curr = curr.next;
                    } else {
                        temp.next = curr;
                        temp = curr;
                        if (curr != null) curr = curr.next;
                        max--;
                    }
                    if (max == 0) break;
                }
                temp.next = null;

                while (ans != null) {
                    System.out.println(ans.data);
                    ans = ans.next;
                }
                return;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }
    }
}
