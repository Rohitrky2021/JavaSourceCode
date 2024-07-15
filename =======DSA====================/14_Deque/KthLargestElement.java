import java.util.*;
public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k =4 ;

        int[] result = kthLargestInWindow(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] kthLargestInWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // result index

        Deque<Integer> deque = new ArrayDeque<>();

        // Pre-process the first k elements to form the initial window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
                System.out.println(deque.pollLast());
            }
            deque.offerLast(i);
            
        }
        System.out.println(deque.toString());

        for (int i = k; i < n; i++) {
            // Add the maximum element (kth largest) for the current window to the result array
            result[ri++] = nums[deque.peekFirst()];

            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);
        }

        // Add the maximum element (kth largest) for the last window to the result array
        // for (int i = 0; i < k-1; i++) {
        //     deque.pop();
            
            
        // }
        System.out.println(deque.toString());
        result[ri] = nums[deque.peekFirst()];

        return result;
    }
}
