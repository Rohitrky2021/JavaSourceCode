 
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            System.out.println(findMaxLengthSubarray(A, K));
        }

        scanner.close();
    }

    private static int findMaxLengthSubarray(int[] A, int K) {
        int N = A.length;
        int[] prefix = new int[N + 1];
        prefix[0] = 0;

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int maxLength = -1;

        for (int r = 1; r <= N; r++) {
            int target = prefix[r] - K * (r % 2 == 1 ? 1 : -1);
            
            if (map.containsKey(target)) {
                maxLength = Math.max(maxLength, r - map.get(target));
            }
            
            if (!map.containsKey(prefix[r])) {
                map.put(prefix[r], r);
            }
        }

        return maxLength;
    }
}
