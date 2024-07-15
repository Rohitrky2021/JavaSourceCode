import java.util.*;

    public class subarrry {
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
            Map<Integer, Integer> countMap = new HashMap<>();
            countMap.put(0, 1);
            int currentDivisibleCount = 0;
            long result = 0;
            
            for (int i = 0; i < N; i++) {
                if (nums[i] % P == 0) {
                    currentDivisibleCount++;
                }
                
                prefixCount[i + 1] = currentDivisibleCount;
                int diff = prefixCount[i + 1] - K;
                
                if (countMap.containsKey(diff)) {
                    result += countMap.get(diff);
                }
                
                countMap.put(prefixCount[i + 1], countMap.getOrDefault(prefixCount[i + 1], 0) + 1);
            }
            
            System.out.println(result);
        }
    }

    