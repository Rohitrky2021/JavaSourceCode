public class cycleList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;//taking obj from the same class to assign the value
            this.next=null;
        }

        
    }   
    public static Node head;
    public static Node tail;
    public static int size;
    public static void main (String[] arg){
        cycleList ll=new cycleList();
        // ll.addFirst(4);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.llcycle();
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(3);
        head.next.next.next.next.next=new Node(2);
        head.next.next.next.next.next.next=new Node(1);
        System.out.println(palindrom());
        ll.llcycle();
        // ll.removecycle();
        // ll.llcycle();

        // ll.printll(head);

    }
       


    public void addFirst(int data){
        // int data;
            //step1 = create new node
           Node newNode= new Node(data);
           size++;
           if(head==null){
               head=tail=newNode;
               return;
           }
           //step1 = create new node
           // Node newNode= new Node(data);
   
           //step2- newNode next=head
           newNode.next=head;//link
   
           //step-3 head=newnode
           head=newNode;
   
       }

       public  void printll(Node head){
        Node temp=head;
        if(head==null){
            System.out.println("Null");
        }
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    
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
    public void removecycle(){
        //detect cycle;
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next ;
            if(fast==slow){
                cycle=true;
                break;
            }

        }
        //find the meeting  point 
        slow=head;
        Node prev=null;//last node
        while(slow!=fast){
            prev=fast;//this not work for the last time
            //so prev=fast-1;
            slow=slow.next;
            fast=fast.next.next;
        }
        //removing the cycle
        prev.next=null;

    }
    public static boolean palindrom(){
        if(head==null||head.next==null){
            return true;
        }
        // finding mid
        Node mid=findmidNode(head);
        // reverse 2nd half
        Node curr=mid;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        //check if equal
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }    
    public static Node findmidNode(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
                   
        }
        return slow;
    }
    
    }

