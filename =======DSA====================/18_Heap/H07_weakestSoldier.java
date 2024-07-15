
import java.util.PriorityQueue;

public class H07_weakestSoldier {

    // M2 --> A Bettter Approach ==>> 
    
    // PriorityQueue<row> pq = new PriorityQueue<>((r1, r2) -> {
    //     if (r1.soldier == r2.soldier) {
    //         return r1.idx - r2.idx;
    //     } else {
    //         return r1.soldier - r2.soldier;
    //     }
    // });

    static class row implements Comparable<row> {
        int soldier;
        int idx;

        row(int soldier, int idx) {
            this.idx = idx;
            this.soldier = soldier;
        }

        @Override
        public int compareTo(row r2) {
            if (this.soldier == r2.soldier) {
                return this.idx - r2.idx;
            } else {
                return this.soldier - r2.soldier;
            }
        }
    }

    public static void main(String[] args) {
        int k = 2;
        int arr[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };

        PriorityQueue<row> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int soldier = 0;
            int j = 0;
            while (arr[0].length > j && arr[i][j] == 1) {
                soldier++;
                j++;
            }
            pq.add(new row(soldier, i));
        }

        while (k-- > 0) {
            System.out.println("r" + pq.remove().idx);
        }
    }
}
