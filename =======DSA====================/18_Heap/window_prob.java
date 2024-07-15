import java.util.PriorityQueue;
import java.util.*;

public class window_prob {
    static class pair implements Comparable<pair> {
        int val;
        int idx;

        public pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair p2) {
            // descending
            return p2.val - this.val;// reverse this for descending order
        }

    }
    

    public static void main(String args[]) {
        // System.out.println("Enter the size of K:");
        // Scanner sc=new Scanner(System.in);
        // int k=sc.nextInt();
        int k = 3;
        int win[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int res[] = new int[win.length - k + 1];// n-k+1
        PriorityQueue<pair> pq = new PriorityQueue<>();
        // pq.add(1)1
        for (int i = 0; i < k; i++) {
            pq.add(new pair(win[i], i));
        }
        res[0] = pq.peek().val;
        for (int i = k; i < win.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new pair(win[i], i));
            res[i - k + 1] = pq.peek().val;
            // System.out.print(pq.remove()+" ");
        }

        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
            sum += res[i];
        }
        System.out.println();
        System.out.println(sum);
    }
}
