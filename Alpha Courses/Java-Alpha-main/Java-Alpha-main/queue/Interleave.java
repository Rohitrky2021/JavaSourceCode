import java.util.*;
public class Interleave {
    private static void Inter(Queue<Integer> q) {
        int size = q.size();
        int n= size/2;
        Queue<Integer> fh = new LinkedList<>();
        for(int i =0 ; i < n ; i++){
            fh.add(q.remove());
        }
        while(!fh.isEmpty()){
            q.add(fh.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < 10 ;i++){
            q.add(i+1);
        }
        Inter(q);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }

    
}
