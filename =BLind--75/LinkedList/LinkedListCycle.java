public class LinkedListCycle {


    //  M1 --> Using slow and fast pntr ==> Simple if start==fast after some time then true
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

 // same just else if 
public void llcycle(){
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null){
        // slow=head;
        // fast=head;
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            System.out.println("cycle there");
            break;
        }
        else{

            System.out.println("Its simple list ");
            // break;
        }

    }
}