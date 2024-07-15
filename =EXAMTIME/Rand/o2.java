import java.util.*;

    public class o2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            // Read input values
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int P = scanner.nextInt();
            
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            
            // Calculate the count of distinct subarrays
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                int divisibleCount = 0;
                for (int j = i; j < N; j++) {
                    if (nums[j] % P == 0) {
                        divisibleCount++;
                    }
                    
                    if (divisibleCount <= K) {
                        count++;
                    } else {
                        break; // Break the inner loop if the divisibility condition is violated
                    }
                }
            }
            
            System.out.println(count);
            
            scanner.close();
        }
    }
    