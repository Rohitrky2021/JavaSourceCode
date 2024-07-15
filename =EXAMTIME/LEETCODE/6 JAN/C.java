import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> v = new HashSet<>();
        q.offer(new int[]{x, 0});
        v.add(x);

       

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int v1 = c[0];
            int o = c[1];
             isSorted(c);

            if (v1 == y) {
                return o;
            }

            if (!v.contains(v1 + 1)) {
                q.offer(new int[]{v1 + 1, o + 1});
                v.add(v1 + 1);
            }

            if (!v.contains(v1 - 1)) {
                q.offer(new int[]{v1 - 1, o + 1});
                v.add(v1 - 1);
            }

            if (v1 % 5 == 0 && !v.contains(v1 / 5)) {
                q.offer(new int[]{v1 / 5, o + 1});
                v.add(v1 / 5);
            }
             isSorted(c);

            if (v1 % 11 == 0 && !v.contains(v1 / 11)) {
                q.offer(new int[]{v1 / 11, o + 1});
                v.add(v1 / 11);
            }
        }

        return -1;
    }
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
