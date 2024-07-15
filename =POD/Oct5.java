import java.util.*;
import java.util.stream.Collectors;

public class Oct5 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 3, 1, 2, 2};
     
        List<Integer> ans = majorityElements(nums);
        System.out.println(ans);
    }

    public static List<Integer> majorityElements(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return Arrays.asList(); // Return an empty list if the input is empty
        }

        int threshold = n / 3;

        // Use Java streams to filter elements that occur more than n/3 times
        List<Integer> ans = Arrays.stream(nums)
                .boxed() // Convert int to Integer for stream operations
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return ans;
    }
}
