import java.util.*;

public class Linkedlist{
    public static class Node{
            int data;
            Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }



    public static Node head;
    public static Node tail;
    public static int size;





    public void addfirst(int data){
        Node newNode= new Node(data);
        size++;
        if(head == null){
            head =tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }






    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }





    public void printll(){ 
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println("null");
    }






    public void addin(int data, int idx){
        if(idx==0){
            addfirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0 ;
        while(i< (idx-1)){
            temp = temp.next;
            i++;
        }

        newNode.next=temp.next;
        temp.next = newNode;
    }




    
    public int removefirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1 ){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val = head.data;
        head=head.next;
        size--;
        return val;
    }






    public int removelast(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1 ){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }
        // . 1 2 3 4 
        Node prev = head;
        
        while(prev.next.next != null){
           prev= prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }





    public int iterators(int key){
        Node temp = head;
        int i=0;
        
        while(temp!= null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        
        return -1;
    }




    public int search(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx = search(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }





    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;


        while(curr!=null){
            next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }





    public void removeNthFromEnd( int n) {
        int i = 0 ; 
        Node temp = head;
        
        // calculate size of linked list
        while(temp!= null){
            i++;
            temp = temp.next;
        }
        if(i==1){
            head = temp=null;
            return ;
        }
        int x = i-n;
         
        if(x==0){
            head =head.next;
            return ;
        }
       
        temp = head;
        
         // at prev node
        while(x>1){
            temp =temp.next;
            x--;
        }
        temp.next = temp.next.next;
        return ;
    }






    public Node findmid(Node head){
        Node slow = head;
        Node fast =head;


        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }






    public boolean palindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // find mid 
        Node midNode = findmid(head);
        
        // reverse second half

        Node prev = null;
        Node curr = midNode;
        Node next;


        while(curr!=null){
            next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // check 
        while(right != null ){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }





    public boolean cyclecheck(){
        Node slow = head;
        Node fast = head;


        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public void removecycle(){
        Node slow = head;
        Node fast = head;
        Boolean exist = false;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                exist =true;
                break;
            }
        }
        if(exist == false){
            return;
        }
        slow = head ;

        while(fast.next != slow.next){
            fast =fast.next;
            slow = slow.next;
        }

        fast.next = null;
    

    }



////////zig zag 



    public void zigzag(){
        // find mid 
        Node slow =head ;
        Node fast =head.next;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        Node mid =slow;

        // 
        Node prev = null;
        Node curr = mid.next;
        mid.next =null;
        Node next;

        

        while(curr!=null){
            next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;


        Node lnext ;
        Node rnext ;

        while(right!=null && left!=null){
            lnext = left.next;
            left.next = right;
            rnext = right.next;
            right.next = lnext;

            right = rnext;
            left = lnext;
        }


    }


    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        
        ll.addlast(1);  
        ll.addlast(2);
        ll.addlast(3);  
        ll.addlast(4);
        ll.addlast(5);  
        ll.zigzag();
        ll.printll();
    
        
        
    }
}