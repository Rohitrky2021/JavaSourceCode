public class doubly {

    public class Node{
        int data ;
        Node next;
        Node prev;

        public Node(int data){
            this.data =data;
            this.next = null;
            this.prev = null;

        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // add

    public void addfirst(int data){
        Node newNode= new Node(data);
        size++;
        if(head == null){
            head =tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;

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
        newNode.prev = tail;
        tail = newNode;
    }

    // print

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +"<-->");
            temp =temp.next;
        }
        System.out.println("null");
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
        head.prev =null;
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
        Node prev = tail;
        
        
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;

        return val;
    }


    public void reverse(){
        Node curr =head;
        Node prev = null;
        Node next ;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        doubly dll = new doubly();
        dll.addfirst(1);
        dll.addfirst(2);
        dll.addfirst(3);
        dll.addfirst(4);
        dll.addlast(6);
        dll.print();
        dll.removefirst();
        dll.print();
        dll.removelast();
        dll.print();
        dll.print();
        dll.reverse();
        dll.print();
    
    }
}
