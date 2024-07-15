public class cycle2 {
    // https://leetcode.com/problems/linked-list-cycle-ii/description/
}

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode node1 = head;
                ListNode node2 = fast;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }

                return node1;
            }
        }

        return null;
    }
}

/** (Using Two Pointers) **/
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
// Time Complexity : O(n)
// Space Complexity : O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Initialize pointers at head of linkedlist...
        ListNode p1 = head, p2 = head;
        // Run a loop until p2 and p2.next is equal to null...
        while (p2 != null && p2.next != null) {
            p1 = p1.next;       // moving p1 by 1
            p2 = p2.next.next;  // moving p2 by 2
            // found the cycle...
            if (p1 == p2)  break;
        }
        // In case there is no cycle or no meeting point...
        if (p2 == null || p2.next == null) return null;
        // run loop until again head & p1 don't collab...
        while (head != p1) {
            head = head.next;   // moving head by 1...
            p1 = p1.next;   // moving p1 by 1 as well...
        }
        return head;       // Or return p1, they both will return the tail where cycle starts...
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------------------

/** (Using Hashset) **/
// Runtime: 3 ms, faster than 81.55% of Java online submissions for Linked List Cycle II.
// Time Complexity : O(n)
// Space Complexity : O(n)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Take a HashSet to store unique values and we are storing address of ListNodes which should be unique if there is no cycle.
        HashSet<ListNode> set = new HashSet<>();
        // Traverse elements of the list through the loop...
        // Insert current node inside the set and move forward.
        while (head != null && set.add(head)) {
            head = head.next;
        }
        // If node already present inside the set, It means we reach that node again then return that node.
        return head;
    }
}


// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         boolean hasCycle = false;
        
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//             if (slow == fast) {
//                 hasCycle = true;
//                 break;
//             }
//         }
        
//         if (!hasCycle) {
//             return null;
//         }
        
//         ListNode node1 = head;
//         ListNode node2 = fast;
//         while (node1 != node2) {
//             node1 = node1.next;
//             node2 = node2.next;
//         }
        
//         return node1;
//     }
// }

