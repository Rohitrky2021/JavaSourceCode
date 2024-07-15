package T15_Heaps;

import java.util.PriorityQueue;

public class H07_connectRops {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(3);
        pq.add(3);
        pq.add(4);
        pq.add(6);
        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        System.out.println(cost);
    }
}
