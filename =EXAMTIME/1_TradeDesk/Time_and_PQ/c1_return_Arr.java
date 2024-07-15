import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class c1 {

    public static int[] solve(Vector<Integer> t) {
        PriorityQueue<Integer> a = new PriorityQueue<>(t);
        Queue<Integer> w = new LinkedList<>();
        List<Integer> resultTimes = new ArrayList<>();
        int time = 0;

        while (!a.isEmpty() || !w.isEmpty()) {
            if (!w.isEmpty()) {
                time = Math.max(time, w.poll()) + 5 * 60;
                // System.out.println(time + " 1");
                        resultTimes.add(time);   // ADD only  from Queue 1 in ans

            } else {
                time = a.peek();
                // System.out.println(time+"  2");  

            }

            while (!a.isEmpty() && a.peek() <= time) {
                if (w.size() < 10) {
                    w.offer(a.poll());
                }
            }

        }

        // Convert the List to an array
        int[] resultArray = new int[resultTimes.size()];
        for (int i = 0; i < resultTimes.size(); i++) {
            resultArray[i] = resultTimes.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        Vector<Integer> t = new Vector<>(List.of(4, 400, 450, 500)); // Example input
        int[] result = solve(t);

        // Print the result array
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
