public class ReverseLL {
    
    // https://leetcode.com/problems/reverse-linked-list/

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

//  ======M1 Iterative and Best Solution 
class Solution {                /////////////=============>>> NCPC
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;//next  right waale ko fix kiya -->kyuki eske baad k liye track ho esliye 
            curr.next = prev;//mene apne curr ka next ghuma k peeche kr diya to prev
            prev = curr;//Now mene  window shift krdi towards right 
            curr = next;//same step of shifting window 

        }
        head = prev;//curr null ho gya -->last node p prev aa gya now  ASssign head here 
        return head;
    }
}

//  ======M2 Recursive  Solution 
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        // AB ye lines DONE WHILE COMING BACK FROM LAST
        head.next.next = head;   // aage waale ka head mere p kro OR then
        head.next = null;   //then mera head hta do 
//====================================
        return p;
    }
}

