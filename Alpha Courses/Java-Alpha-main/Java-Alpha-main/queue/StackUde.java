import java.util.*;
public class StackUde{
    public static class stack{
        static Deque<Integer> q =new LinkedList<>();

        public static boolean isEmpty(){
            return q.isEmpty();
        }

        public static void push(int data){
            q.addLast(data);
        }

        public static int pop(){
            return q.removeLast();
        }

        public static int peek(){
            return q.getLast();
        }
    } 
    public static void main(String[] args) {
        Stack s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);    
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }  
    }
}