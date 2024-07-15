package BinarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInASortedArray {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
        // System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(searchRange(arr, 1)));

    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }

        return ans;
    }

    static int search(int[] arr, int target, boolean findStartIndex) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
