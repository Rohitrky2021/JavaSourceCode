class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class longestNonIncreasing {
    public static ListNode findLongestNonIncreasing(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode longestNonIncreasingStart = null;
        ListNode longestNonIncreasingEnd = null;
        ListNode currentStart = head;

        while (current.next != null) {
            if (current.next.val >= current.val) {
                currentStart = current.next;
            } else {
                if (longestNonIncreasingStart == null || (currentStart != current && currentStart != current.next)) {
                    if (longestNonIncreasingEnd == null || longestNonIncreasingEnd != current) {
                        longestNonIncreasingStart = currentStart;
                        longestNonIncreasingEnd = current;
                    }
                }
            }
            current = current.next;
        }

        // In case the longest non-increasing sequence ends at the last element
        if (currentStart != current) {
            if (longestNonIncreasingStart == null) {
                longestNonIncreasingStart = currentStart;
                longestNonIncreasingEnd = current;
            } else if (longestNonIncreasingEnd != current) {
                longestNonIncreasingStart = currentStart;
                longestNonIncreasingEnd = current;
            }
        }

        if (longestNonIncreasingStart != null) {
            // Disconnect the end of the longest non-increasing list from the rest of the list
            longestNonIncreasingEnd.next = null;
        }

        return longestNonIncreasingStart;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        printList(head);

        ListNode longestNonIncreasing = findLongestNonIncreasing(head);
        System.out.println("\nLongest Non-Increasing Linked List:");
        printList(longestNonIncreasing);
    }
}
