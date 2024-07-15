import java.util.*;
import java.util.stream.IntStream;


// public class red {
//     public static void main(String[] args) {
//         int[] nums = {10, 5, 8, 15, 7};

//         int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);

//         // Using IntStream.range().boxed() to get the index along with the value
//         int indexOfNextLargest = Arrays.stream(nums)
//                 .boxed()
//                 .filter(e -> e < max)  // Filter elements less than max
//                 .reduce((a, b) -> a > b ? a : b)
//                 .map(nextLargest -> IntStream.range(0, nums.length)
//                         .filter(i -> nums[i] == nextLargest)
//                         .findFirst()
//                         .orElse(-1))
//                 .orElse(-1);

//         System.out.println("Index of next largest element: " + indexOfNextLargest);
//     }
// }

 

public class red {
    public static void main(String[] args) {
        int[] nums = {10, 5, 8, 15, 7};

        // Using IntStream.range().boxed() to get the index along with the value
        int indexOfMax = Arrays.stream(nums)
                .boxed()
                .reduce((a, b) -> a > b ? a : b)
                .map(max -> IntStream.range(0, nums.length)
                        .filter(i -> nums[i] == max)
                        .findFirst()
                        .orElse(-1))
                .orElse(-1);

        System.out.println("Index of max value: " + indexOfMax);
    }
}
