public class doublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
            }

    }
    public static Node head;
    public static Node tail;
    public static Node size;
    

    public static void main(String ars[]){
        doublyLL ll=new doublyLL();
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);
        // ll.reverse(head);
        reverse();
        ll.printdll(head);
        
        
    }
    public void addfirst(int data){
        Node n=new Node(data);
        if(head==null){
            head=tail=n;
            return ;
        }
        n.next=head;
        head.prev=n;
        // n.data=data;
        // return n; 
        head=n;  
     }
    public void printdll(Node head){
        Node temp=head;
        while(temp!=null ||temp!=null){
            System.out.print(temp.data+"->"); 
            temp=temp.next;
           }
           System.out.println("Null");
    } 
    //HW write the reverse operation of doubly
    public static void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;

            prev=curr;
            curr=next;
        }
        head=prev;

    }
}
