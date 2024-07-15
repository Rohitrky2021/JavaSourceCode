// public class Solution {
        public class NextPermu {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }
    
        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
// }


// m2 in O(n) and O(1)
// // Java implementation of the approach
// import java.util.*;

// class GFG
// {
//   static int[] nextPermutation(int n, int[] arr)
//   {

//     // If number of digits is 1 then just return the vector
//     if (n == 1)
//       return arr;

//     // Start from the right most digit and find the first
//     // digit that is
//     // smaller than the digit next to it.
//     int i = 0;
//     for (i = n - 1; i > 0; i--) {
//       if (arr[i] > arr[i - 1])
//         break;
//     }

//     // If there is a possibility of a next greater element
//     if (i != 0)
//     {

//       // Find the smallest digit on right side of (i-1)'th
//       // digit that is
//       // greater than number[i-1]
//       for (int j = n - 1; j >= i; j--) 
//       {
//         if (arr[i - 1] < arr[j])
//         {

//           // Swap the found smallest digit i.e. arr[j]
//           // with arr[i-1]
//           int temp = arr[j];
//           arr[j] = arr[i - 1];
//           arr[i - 1] = temp;
//           break;
//         }
//       }
//     }

//     // Reverse the digits after (i-1) because the digits
//     // after (i-1) are in decreasing order and thus we will
//     // get the smallest element possible from these digits
//     int[] res = new int[arr.length];
//     int ind = arr.length - 1;

//     // copying the first i elements of arr
//     // into res
//     for (int j = 0; j < i; j++)
//       res[j] = arr[j];

//     // copying the rest of the elements
//     // in reverse order
//     for (int j = i; j< res.length; j++)
//       res[j] = arr[ind--];

//     // If i is 0 that means elements are in decreasing order
//     // Therefore, no greater element possible then we just
//     // return the lowest possible
//     // order/element formed from these digits by just
//     // reversing the vector
//     return res;
//   }

//   // Driver Code
//   public static void main(String[] args)
//   {
//     int n = 6;
//     int[] v = { 5,3,4,9,7,6 };
//     int[] res;

//     // Function Call
//     res = nextPermutation(n, v);
//     for (int i = 0; i < res.length; i++) {
//       System.out.print(res[i] + " ");
//     }
//   }
// }

// This code is contributed by phasing17