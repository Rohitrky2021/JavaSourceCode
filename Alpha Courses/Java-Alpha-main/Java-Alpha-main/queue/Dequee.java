import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Dequee {
    public static void main(String[] args) {
        Deque<Integer> deq = new LinkedList<>();
        deq.addFirst(1);      //1
        deq.addFirst(2);      //2 1
        deq.addLast(3);       // 2 1 3
        deq.addLast(4);       // 2 1 3 4
        deq.addLast(5);       // 2 1 3 4 5
        System.out.println(deq); // 2 1 3 4 5
        deq.removeFirst();       // 1 3 4 5
        System.out.println(deq); // 1 3 4 5
        deq.removeLast();        // 1 3 4
        System.out.println(deq); // 1 3 4

        System.out.println("First ele" +" --> " +deq.getFirst());  // 1
        System.out.println("Last ele" +" ---> " +deq.getLast());    // 4
    }
}
