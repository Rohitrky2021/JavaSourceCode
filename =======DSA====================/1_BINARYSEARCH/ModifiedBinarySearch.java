public class ModifiedBinarySearch {
    // FOR ROTATED SORTED ARRAY !!

    public int searchi(int[] arr, int target, int l, int r) {
        l = 0;
        r = arr.length - 1;
        int mid = l + (r - l) / 2;
        if (l > r) {
            return -1;
        }

        if (arr[mid] == target) {
            return mid;
        }

        // Where the Mid lies
        // on L1-->
        if (arr[mid] >= arr[l]) {
            // left
            if (arr[l] <= target && target < arr[mid]) {
                return searchi(arr, target, l, mid - 1);
            }
            // rigth
            else {
                return searchi(arr, target, mid + 1, r);
            }
        }
        // on L2--->
        else {
            if (target >= arr[mid] && target <= arr[r])
                // right
                return searchi(arr, target, mid + 1, r);
            // left
            else {
                return searchi(arr, target, l, mid - 1);
            }

        }

    }


    // This below code is for  min above was for the target elemnet 
    // ============------------------------------->>>>>>>>>>>>>>>>>>>>

    // Other Approaches of the Aditya Video of Using prev & after elements
    public class MinimumInRotatedSortedArray {
        public int findMin(int[] nums) {
            int first = 0;
            int n = nums.length;
            int last = n - 1;
            int middle = 0, prev = 0, next = 0;
            while (first <= last) {
                if (nums[first] <= nums[last]) {
                    return nums[first];
                }
                middle = first + (last - first) / 2;
                prev = (middle - 1 + n) % n;
                next = (middle + 1) % n;
    
                if (nums[middle] <= nums[next] && nums[middle] <= nums[prev]) {
                    return nums[middle];
                }
                if (nums[first] <= nums[middle]) {
                    first = middle + 1;
                }
                if (nums[middle] <= nums[last]) {
                    last = middle - 1;
                }
            }
            return -1;
        }
    
        public static void main(String[] args) {
            MinimumInRotatedSortedArray solution = new MinimumInRotatedSortedArray();
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            System.out.println(solution.findMin(nums)); // Output: 0
        }
    }


    public class Solution {
        public int findMin(int[] num) {
            int start = 0, end = num.length - 1;
    
            while (start < end) {
                if (num[start] < num[end]) {
                    return num[start];
                }
    
                int mid = start + (end - start) / 2;
    
                if (num[mid] >= num[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
    
            return num[start];
        }
    
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            System.out.println(solution.findMin(nums)); // Output: 0
        }
    }
    
    
    public class Solution {
        public int findMin(int[] arr) {
            int lo = 0, hi = arr.length - 1;
            int mid;
            int prev, next;
            int n = arr.length;
            if (arr[0] < arr[n - 1])
                return arr[0];
            while (lo <= hi) {
    
                mid = lo + (hi - lo) / 2;
    
                prev = (mid - 1 + n) % n;
                next = (mid + 1) % n;
                System.out.println(mid);
                if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
                    return arr[mid];
    
                if (arr[0] <= arr[mid])
                    lo = mid + 1;
    
                else if (arr[mid] <= arr[n - 1])
                    hi = mid - 1;
            }
    
            return -1;
        }
    
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            System.out.println(solution.findMin(nums)); // Output: 0
        }
    }
    















    public static void main(String[] args) {

    }

}
