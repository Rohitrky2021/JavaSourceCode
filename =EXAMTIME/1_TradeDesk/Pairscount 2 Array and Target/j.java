 
import java.util.HashMap;

public class j {

    public static int cp(int[] a1, int[] a2, int target) {
        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();

        for (int i = 0; i < a1.length; ++i) {
            int s = 0;
            for (int j = i; j < a1.length; ++j) {
                s += a1[j];
                m1.put(s, m1.getOrDefault(s, 0) + 1);
            }
        }

        for (int i = 0; i < a2.length; ++i) {
            int s = 0;
            for (int j = i; j < a2.length; ++j) {
                s += a2[j];
                m2.put(s, m2.getOrDefault(s, 0) + 1);
            }
        }

        int count = 0;

        for (HashMap.Entry<Integer, Integer> entry : m1.entrySet()) {
            int c = target - entry.getKey();
            count += entry.getValue() * m2.getOrDefault(c, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] a1 = {5,2,1,6,4};
        int[] a2 = {3,5};
        int target = 10;

        int result = cp(a1, a2, target);
        System.out.println(result);
    }
}
