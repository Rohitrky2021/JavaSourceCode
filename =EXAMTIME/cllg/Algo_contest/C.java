import java.util.*;
 

public class C {

    static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] positions = {1,1};
        int[] h = {3,4};

        // Test input array

        int[] asteroids = {5, 10, -5};

        for (int i = 0; i < h.length; i++) {
            asteroids[i]=positions[i]*h[i];
        }

        // Run the asteroidCollision method
        int[] result = solution.asteroidCollision(asteroids);

        // Print the result
        System.out.println("Result:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<C.Pair<Integer, Integer>> qItems = new LinkedList<>(); // Deque of Pair<Integer, Integer>

        for (int i = 0; i < asteroids.length; i++) {
            int ast = asteroids[i];
            if (ast > 0) {
                qItems.add(new C.Pair<>(ast, i)); // Add Pair with index
            } else {
                while (!qItems.isEmpty() && qItems.peekLast().first > 0 && qItems.peekLast().first < -ast) {
                    qItems.pollLast();
                }

                if (!qItems.isEmpty() && qItems.peekLast().first == -ast) {
                    qItems.pollLast();
                } else if (qItems.isEmpty() || qItems.peekLast().first < 0) {
                    qItems.add(new C.Pair<>(ast, i)); // Add Pair with index
                }
            }
        }
        int[] res = new int[qItems.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = qItems.pollFirst().second; // Extracting the value part of Pair
        }
        return res;
    }
}
