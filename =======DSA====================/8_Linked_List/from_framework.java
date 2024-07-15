// import java.util.LinkedList;
import java.util.*;
public class from_framework {
    public static class Node{
        int data;
        Node next;

            public Node(int data){
                this.data=data;
                this.next=null;

            }
            
            
        }
        public static Node head;
        public static Node next;
    public static void main (String[] arg){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addFirst(3);
        ll.add(2);
        ll.add(1);
        ll.addFirst(0);
        ll.add(3, 5);
        // ll.prin
        System.out.println(ll);
        ll.removeFirst();
         
        System.out.println(ll);
        ll.removeLast();
        // ll.mergesort
        // ll.mergesort();
        
        
        System.out.println(ll);

    }
    public Node mid(Node mid){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;//ur slow is the mid
    }

    public Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node middle=mid(head);
        Node right=middle;
        middle.next=null;
        Node newleft=mergesort(head);
        Node newright=mergesort(right);
        return merge(newleft,newright);

        



    }
    public Node merge(Node head1,Node head2){
        Node merged=new Node(-1);
        Node temp=merged;
        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
                
            }
            else{
                temp.next=head2;
                // temp.next=head1;
                head2=head2.next;
                temp=temp.next;
            }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }        
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;

        }
        
    }
    return merged.next;
    }
}

