import java.util.*;
// 974. Subarray Sums Divisible by K
// 6.1K
// 254
// Companies
// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

// A subarray is a contiguous part of an array.

// Example 1:

// Input: nums = [4,5,0,-2,-3,1], k = 5
// Output: 7
// Explanation: There are 7 subarrays with a sum divisible by k = 5:

// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
public class DIVIsibkeByKSUBARR{

    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k;
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    
    }

        public static void main(String[] args) {
            
        }
}

// Time complexity: O(n+k)O(n + k)O(n+k)

// We require O(k)O(k)O(k) time to initialize the modGroups array.
// We also require O(n)O(n)O(n) time to iterate over all the elements of the nums array. 
// The computation of the prefixSum and the calculation of the subarrays
//  divisible by k take O(1)O(1)O(1) time for each index of the array.
// Space complexity: O(k)O(k)O(k)

// We require O(k)O(k)O(k) space for the modGroups array.