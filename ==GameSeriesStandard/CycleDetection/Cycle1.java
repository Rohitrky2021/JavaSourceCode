public class Cycle1 {
    // https://leetcode.com/problems/linked-list-cycle/description/
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
         if(head==null)return false;
        ListNode s=head;
        ListNode f=head.next;
        while(s!=f){
            if( f==null ||f.next==null)return false;

            s=s.next;
            f=f.next.next;

    }
    return true;
}
}