import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class deque{
    public static void findMaximumInSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Process the first 'k' elements separately
        for (int i = 0; i < k; i++) {
            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            // The first element in the deque is the maximum for the current window
            System.out.println(nums[deque.peekFirst()]);

            // Remove elements that are no longer in the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Print the maximum of the last window
        System.out.println(nums[deque.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        findMaximumInSlidingWindow(nums, k);
    }
}
