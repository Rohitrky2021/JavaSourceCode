
    import java.util.HashSet;

    public class c {
        public static void main(String[] args) {
            int[] nums = {3,4,5,6};
            int K = 1;
            int P = 2;
            int count = countDistinctSubarrays(nums, K, P);
            System.out.println("Count of distinct subarrays: " + count);
        }
    
        public static int countDistinctSubarrays(int[] nums, int K, int P) {
            int count = 0;
            HashSet<String> subarrays = new HashSet<>();
    
            for (int i = 0; i < nums.length; i++) {
                int divisibleCount = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] % P == 0) {
                        divisibleCount++;
                    }
                    if (divisibleCount <= K) {
                        // Create a subarray as a string
                        StringBuilder subarray = new StringBuilder();
                        for (int k = i; k <= j; k++) {
                            subarray.append(nums[k]);
                            subarray.append(",");
                        }
                        // Add the subarray as a string to the HashSet
                        subarrays.add(subarray.toString());
                    } else {
                        break; // If more than K elements are divisible by P, stop extending the subarray
                    }
                }
            }
            System.out.println(subarrays);
            count = subarrays.size();
            return count;
        }
    }
    