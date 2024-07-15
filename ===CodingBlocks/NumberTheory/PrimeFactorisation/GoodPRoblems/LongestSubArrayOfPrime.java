// https://www.geeksforgeeks.org/longest-sub-array-of-prime-numbers-using-segmented-sieve/?ref=lbp

import java.util.*;
import java.lang.*;
import java.io.*;
// Input: arr[] = {3, 5, 2, 66, 7, 11, 8} 
// Output: 3 
// Explanation: 
// Maximum contiguous prime number sequence is {2, 3, 5}

// Input: arr[] = {1, 2, 11, 32, 8, 9} 
// Output: 2 
// Explanation: 
// Maximum contiguous prime number sequence is {2, 11} 

// Time Complexity: O(N), where N is the length of the array. 
// Auxiliary Space: O(N), where N is the length of the array.

// Java program to find longest subarray
// of prime numbers

public class LongestSubArrayOfPrime {

    // To store the prime numbers
    static Set<Integer> allPrimes = new HashSet<>();

    // Function that find prime numbers
    // till limit
    static void simpleSieve(int limit,
            ArrayList<Integer> prime) {
        boolean[] mark = new boolean[limit + 1];

        // Find primes using
        // Sieve of Eratosthenes
        for (int i = 2; i <= limit; ++i) {
            if (mark[i] == false) {
                prime.add(i);
                for (int j = i; j <= limit; j += i) {
                    mark[j] = true;
                }
            }
        }
    }

    // Function that finds all prime
    // numbers in given range using
    // Segmented Sieve
    static void primesInRange(int low, int high) {

        // Find the limit
        int limit = (int) Math.floor(Math.sqrt(high)) + 1;

        // To store the prime numbers
        ArrayList<Integer> prime = new ArrayList<>();

        // Comput all primes less than
        // or equals to sqrt(high)
        // using Simple Sieve
        simpleSieve(limit, prime);

        // Count the elements in the
        // range [low, high]
        int n = high - low + 1;

        // Declaring boolean for the
        // range [low, high]
        boolean[] mark = new boolean[n + 1];

        // Traverse the prime numbers till
        // limit
        for (int i = 0; i < prime.size(); i++) {
            int loLim = (int) Math.floor((double) low /
                    (int) prime.get(i));
            loLim *= (int) prime.get(i);

            // Find the minimum number in
            // [low..high] that is a
            // multiple of prime[i]
            if (loLim < low) {
                loLim += (int) prime.get(i);
            }

            if (loLim == (int) prime.get(i)) {
                loLim += (int) prime.get(i);
            }

            // Mark the multiples of prime[i]
            // in [low, high] as true
            for (int j = loLim; j <= high; j += (int) prime.get(i))
                mark[j - low] = true;
        }

        // Element which are not marked in
        // range are Prime
        for (int i = low; i <= high; i++) {
            if (!mark[i - low]) {
                allPrimes.add(i);
            }
        }
    }

    // Function that finds longest subarray
    // of prime numbers
    static int maxPrimeSubarray(int[] arr, int n) {
        int current_max = 0;
        int max_so_far = 0;

        for (int i = 0; i < n; i++) {

            // If element is Non-prime then
            // updated current_max to 0
            if (!allPrimes.contains(arr[i]))
                current_max = 0;

            // If element is prime, then
            // update current_max and
            // max_so_far
            else {
                current_max++;
                max_so_far = Math.max(current_max,
                        max_so_far);
            }
        }

        // Return the count of longest
        // subarray
        return max_so_far;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3, 29,
                11, 7, 8, 9 };
        int n = arr.length;

        // Find minimum and maximum element
        int max_el = Integer.MIN_VALUE;
        int min_el = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < min_el) {
                min_el = arr[i];
            }
            if (arr[i] > max_el) {
                max_el = arr[i];
            }
        }

        // Find prime in the range
        // [min_el, max_el]
        primesInRange(min_el, max_el);

        // Function call
        System.out.print(maxPrimeSubarray(arr, n));
    }
}

// This code is contributed by offbeat
