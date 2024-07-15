import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the array
            int[] a = new int[n];

            // Input array elements
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int count = countEqualNotePairs(n, a);
            System.out.println(count);
        }

        scanner.close();
    }

    private static int countEqualNotePairs(int n, int[] a) {
        Map<Integer, Integer> countMap = new HashMap<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            int bi = 1 << (a[i] - 1); // Calculate bi = 2^(ai-1)
            result += countMap.getOrDefault(bi, 0);
            countMap.put(bi, countMap.getOrDefault(bi, 0) + 1);
        }

        return result;
    }
}
