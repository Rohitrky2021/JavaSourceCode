public class PartitionLLaboutPivot {
    // https://leetcode.com/problems/partition-list/

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lefttail = left;
        ListNode righttail = right;

        while (head != null) {
            if (head.val < x) {
                lefttail.next = head;
                lefttail = lefttail.next;
            } else {
                righttail.next = head;
                righttail = righttail.next;
            }
            head = head.next;
        }

        lefttail.next = right.next;
        righttail.next = null;

        return left.next;

    }

}
