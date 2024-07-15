import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Vector;
import java.util.List;

public class c_final {

    public static int solve(Vector<Integer> t) {
        PriorityQueue<Integer> a = new PriorityQueue<>(t);
        Queue<Integer> w = new LinkedList<>();
        int time = 0;

        while (!a.isEmpty() || !w.isEmpty()) {
            if (!w.isEmpty()) {
                time = Math.max(time, w.poll()) + 5 * 60;
            } else {
                time = a.peek();
            }

            while (!a.isEmpty() && a.peek() <= time) {
                if (w.size() < 10) {
                    w.offer(a.poll());
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Vector<Integer> t = new Vector<>(List.of(1,6,9,502)); // Example input
        int result = solve(t);
        System.out.println(result);
    }
}
