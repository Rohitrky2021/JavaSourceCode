import java.util.*;
public class using_framework {

    public static void main(String arg[]){
        Stack s=new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.insertElementAt(5, s.size());
        
        pushatbottom(s,6);
        

        while(!s.isEmpty()){
            System.out.println(s.peek()); 
            s.pop();
         }
    }
    public static void pushatbottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top=s.pop();
        pushatbottom(s,data);
        s.push(top);

    }
}
