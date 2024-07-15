import java.util.*;

public class op {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int P = scanner.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] prefixCount = new int[N + 1];
        prefixCount[0] = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        int distinctSubarrays = 0;
        int divisibleCount = 0;

        for (int i = 0; i < N; i++) {
            if (nums[i] % P == 0) {
                divisibleCount++;
            }

            while (divisibleCount > K) {
                int firstElement = nums[i - divisibleCount + 1];
                if (firstElement % P == 0) {
                    divisibleCount--;
                }

                int removedPrefixCount = prefixCount[i - divisibleCount + 1];
                countMap.put(removedPrefixCount, countMap.get(removedPrefixCount) - 1);
                if (countMap.get(removedPrefixCount) == 0) {
                    countMap.remove(removedPrefixCount);
                }

                prefixCount[i - divisibleCount + 1]++;
            }

            int currentPrefixCount = prefixCount[i + 1];
            if (countMap.containsKey(currentPrefixCount)) {
                distinctSubarrays += countMap.get(currentPrefixCount);
            }

            countMap.put(currentPrefixCount, countMap.getOrDefault(currentPrefixCount, 0) + 1);
        }

        System.out.println(distinctSubarrays);
    }
}
