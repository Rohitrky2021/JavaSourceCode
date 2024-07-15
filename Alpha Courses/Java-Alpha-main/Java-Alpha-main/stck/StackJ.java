import java.util.*;
public class StackJ {
    public static void pushatbottom(Stack<Integer> s, int i) {
        if(s.isEmpty()){
            s.push(i);
            return;
        }
        int top = s.pop();
        pushatbottom(s, i);
        s.push(top);
        }
    
        public static void reverse(Stack<Integer> s){
            if(s.isEmpty()){
                return ;
            }
            int top = s.pop();
            reverse(s);
            pushatbottom(s, top);
        }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();  
        s.push(1);
        s.push(2);
        s.push(3);

        reverse(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
