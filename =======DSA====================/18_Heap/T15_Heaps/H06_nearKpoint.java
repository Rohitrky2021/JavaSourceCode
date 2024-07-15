package T15_Heaps;

import java.util.PriorityQueue;

public class H06_nearKpoint {

    static class point implements Comparable<point> {
        int x;
        int y;
        int disqr;
        int idx;

        point(int x, int y, int disqr, int idx) {
            this.x = x;
            this.y = y;
            this.disqr = disqr;
            this.idx = idx;
        }

        @Override
        public int compareTo(point p2) {
            return this.disqr - p2.disqr;
        }
    }

    public static void main(String[] args) {

        int arr[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<point> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            pq.add(new point(x, y, x * x + y * y, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("c" + pq.remove().idx);
        }
    }
}
