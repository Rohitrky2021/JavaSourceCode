import java.util.ArrayList;
import java.util.*;
public class using_Array_list {
    
        // int data;
    static class Stack{
        static ArrayList<Integer> list=new ArrayList<>();
         
        public static Boolean isEmpty(){
            return list.size()==0;

        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            } 
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }
        public static int peek(){
            
            // int top=;
            return list.get(list.size()-1);
        }

    }
    
    public static void main(String args[]){
        Stack st=new Stack();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        while(!st.isEmpty()){
           System.out.println(st.peek()); 
           st.pop();
        }
    }
}

//  using Array

class MyStack {
    private int[] stackArray;
    private int topIndex;
    
    public MyStack() {
        stackArray = new int[1000]; // You can choose an appropriate size
        topIndex = -1;
    }
    
    public void push(int x) {
        if (topIndex == stackArray.length - 1) {
            // Handle stack overflow (resizing array or throwing an exception)
            return;
        }
        stackArray[++topIndex] = x;
    }
    
    public int pop() {
        if (topIndex == -1) {
            // Handle stack underflow (throwing an exception)
            return -1; // Just a placeholder, you should handle underflow appropriately
        }
        return stackArray[topIndex--];
    }
    
    public int top() {
        if (topIndex == -1) {
            // Handle empty stack (throwing an exception)
            return -1; // Just a placeholder, you should handle empty stack appropriately
        }
        return stackArray[topIndex];
    }
    
    public boolean empty() {
        return topIndex == -1;
    }
}
