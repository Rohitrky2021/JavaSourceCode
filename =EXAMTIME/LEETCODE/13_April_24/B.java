import java.util.*;

class B {
    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        List<Pair<Integer, Integer>> v = new ArrayList<>();

        // Populate the vector v
        for (int[] point : points) {
            v.add(new Pair<>(point[0], point[1]));
        }

        // Sort the vector v based on the first element of each pair
        Collections.sort(v, new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey().compareTo(p2.getKey());
            }
        });
        isSorted(new int[]{1,23,4,5});

        int ans = 1;
        int cur = v.get(0).getKey();
        isSorted(new int[]{1,23,4,5});
        // Iterate through the sorted vector v
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i).getKey() <= cur + w) {
                continue;
            } else {
                ans++;
                cur = v.get(i).getKey();
            }
        }
        isSorted(new int[]{1,23,4,5});
        return ans;
    }

    public   boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        B solution = new B();

        // Test cases
        int[][] points1 = {{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}};
        int w1 = 1;
        System.out.println(solution.minRectanglesToCoverPoints(points1, w1)); // Output: 2

        int[][] points2 = {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}};
        int w2 = 2;
        System.out.println(solution.minRectanglesToCoverPoints(points2, w2)); // Output: 3

        int[][] points3 = {{2,3},{1,2}};
        int w3 = 0;
        System.out.println(solution.minRectanglesToCoverPoints(points3, w3)); // Output: 2
    }
}
