import java.util.HashMap;
import java.util.Map;

public class minsteps {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int dist = 0;
        int jumps = 0;

        Map<Integer, Integer> hm = new HashMap<>();

        for (int j = 0; j < arr.length; j++) {
            hm.put(j, getMax(arr, j));
        }

        while (dist < n ) {
            int maxJump = hm.get(dist);
            int nextDist = dist + maxJump;

            if (nextDist <= dist) {
                // If no progress is possible, break out of the loop
                break;
            }

            dist = nextDist;
            jumps++;
        }

        System.out.println("Minimum number of jumps: " + jumps);
    }

    public static int getMax(int[] arr, int index) {
        int max = 0;

        for (int i = index + 1; i <= Math.min(index + arr[index], arr.length - 1); i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

}
