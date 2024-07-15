/*package whatever //do not write package name here */

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(log(min(a,b))).
// Space Complexity: O(1) 

// public class GFG {
public class UsingmoreMathoptimised {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static List<Integer> rangeLcmQueries(List<Integer> arr, List<int[]> queries) {
        List<Integer> results = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int lcmVal = arr.get(l);
            for (int i = l + 1; i <= r; i++) {
                lcmVal = lcm(lcmVal, arr.get(i));
            }
            results.add(lcmVal);
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(5, 7, 5, 2, 10, 12, 11, 17, 14, 1, 44);
        List<int[]> queries = List.of(new int[] { 2, 5 }, new int[] { 5, 10 }, new int[] { 0, 10 });
        List<Integer> results = rangeLcmQueries(arr, queries);
        for (int result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}

// Approach#2: Using math
// We first define a helper function lcm() to calculate the least common multiple of two numbers. Then, for each query, we iterate through the subarray of arr defined by the query range and calculate the LCM using the lcm() function. The LCM value is stored in a list, which is returned as the final result.

// Algorithm
// 1. Define a helper function lcm(a, b) to calculate the least common multiple of two numbers.
// 2. Define a function range_lcm_queries(arr, queries) that takes an array arr and a list of query ranges queries as input.
// 3. Create an empty list results to store the LCM values for each query.
// 4. For each query in queries, extract the left and right indices l and r.
// 5. Set lcm_val to the value of arr[l].
// 6. For each index i in the range l+1 to r, update lcm_val to be the LCM of lcm_val and arr[i] using the lcm() function.
// 7. Append lcm_val to the results list.
// 8. Return the results list.