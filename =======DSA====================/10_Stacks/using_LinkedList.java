import java.util.LinkedList;
import java.util.*;

public class using_LinkedList{
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            // this.next=next;
        }
    }    // LinkedList list=new LinkedList<>();
    static class stack{
            static Node head=null;

            public static boolean isEmpty(){
                return head==null;
            }
            public static void push(int data){
                Node newnode=new Node(data);
                // newnode=data;
                if(isEmpty()){
                    head=newnode;
                    return;
                }
                newnode.next=head;
                head=newnode;

            }
            public static int pop(int data){
                if(isEmpty()){
                    return -1;
                }
                int top=head.data;
                head=head.next;
                return top;
            }
            public static int peek(){
                if(isEmpty()){
                    return -1;
                }
                return head.data;
            }
        }
       
        

        public static void main(String arg[]){
            Stack st=new Stack();
            st.push(1);
            st.push(2);
            st.push(3);

            while(!st.isEmpty()){
                System.out.println(st.peek()); 
                st.pop();
             }

        }

}
