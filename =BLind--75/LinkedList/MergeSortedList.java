public class MergeSortedList {
    // https://leetcode.com/problems/merge-two-sorted-lists/

    class Solution {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode p1 = list1;
            ListNode p2 = list2;
            ListNode fakeHead = new ListNode(0);
            ListNode p = fakeHead;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) { // chotta waala add kro 
                    p.next = p1;
                    p1 = p1.next; // then us chotte  waale ka increase krdo pinter
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;  // main ans ke ontr ko increase kro
            }
            if (p1 != null) p.next = p1;
            if (p2 != null) p.next = p2;
            return fakeHead.next;
        }
    }
}
 
// M==2----->

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode root = new ListNode();
        ListNode prev = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return root.next;
    }
}

// Solution using Recursion
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
