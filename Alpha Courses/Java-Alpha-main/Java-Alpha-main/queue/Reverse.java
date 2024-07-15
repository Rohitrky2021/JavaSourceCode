import java.util.*;
public class Reverse {
    public static void reve(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < 10 ;i++){
            q.add(i+1);
        }
        reve(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }

    }
}
