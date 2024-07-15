
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class mergeKsortedLinkedLL {
    public static ListNode mergeKLists(ListNode[] lists) {
        // Create a min-heap (priority queue) to store the nodes of linked lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head nodes of all linked lists to the min-heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // Create a dummy node to build the merged linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the nodes in the min-heap until it becomes empty
        while (!minHeap.isEmpty()) {
            // Extract the node with the minimum value from the min-heap
            ListNode node = minHeap.poll();

            // Append the extracted node to the merged linked list
            current.next = node;
            current = current.next;

            // Move to the next node in the linked list
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(9);
        list3.next = new ListNode(10);
        list3.next.next = new ListNode(11);

        ListNode[] lists = {list1, list2, list3};

        ListNode mergedList = mergeKLists(lists);
        printLinkedList(mergedList);
    }
}
