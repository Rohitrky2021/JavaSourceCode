import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] ht, int bricks, int ladders) {
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
        int arr[] = new int[ht.length - 1];
        int sum = bricks;
        for (int i = 1; i < ht.length; i++) {
            int check = ht[i] - ht[i - 1];
            if (check > 0) {
                s.add(check);
                sum -= check;

                if (sum <= 0) {
                    m = i;
                    break;
                }

            }
        }

        for (int j = 0; j < ladders; j++) {
            sum += s.poll();

        }

        for (int i = m; i < ht.length; i++) {
            int check = ht[i] - ht[i - 1];
            if (check > 0) { 
                sum -= check; 
                if (sum <= 0) {
                    m = i;
                    break;
                }

            }
        }

        return i ;
 

    }
}