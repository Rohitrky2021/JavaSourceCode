package T11_Priority_Queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ01_inJCF {
    public static void main(String[] args) {

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3); // O(log(n))
        pq.add(5);
        pq.add(1);
        pq.add(10);
        pq.add(7);
        
        while (!pq.isEmpty()) {
            // System.out.println(pq.peek()); // O(1)
            // pq.remove();
            System.out.println(pq.remove()); // O(log(n))
        }
    }
}
