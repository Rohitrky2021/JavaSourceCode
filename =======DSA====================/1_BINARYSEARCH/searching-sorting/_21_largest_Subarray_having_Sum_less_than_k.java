// https://www.geeksforgeeks.org/largest-subarray-having-sum-greater-than-k/

// Java program to find largest subarray
// having sum greater than k.

import java.util.*;

// defining pair class
class pair {
    public int first;
    public int second;

    pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

// implementing compare method
// to sort an array of pairs
class pairSort implements Comparator<pair> {

    public int compare(pair a, pair b) {
        if (a.first == b.first)
            return a.second - b.second;

        return a.first - b.first;
    }
}

class _21_largest_Subarray_having_Sum_less_than_k {

    // Function to find index in preSum vector upto which
    // all prefix sum values are less than or equal to val.
    static int findInd(pair[] preSum, int n, int val) {

        // Starting and ending index of search space.
        int l = 0;
        int h = n - 1;
        int mid;

        // To store required index value.
        int ans = -1;

        // If middle value is less than or equal to
        // val then index can lie in mid+1..n
        // else it lies in 0..mid-1.
        while (l <= h) {
            mid = (l + h) / 2;
            if (preSum[mid].first <= val) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }

        return ans;
    }

    // Function to find largest subarray having sum
    // greater than or equal to k.
    static int largestSub(int arr[], int n, int k) {
        int i;

        // Length of largest subarray.
        int maxlen = 0;

        // Vector to store pair of prefix sum
        // and corresponding ending index value.
        pair[] preSum = new pair[n];

        // To store current value of prefix sum.
        int sum = 0;

        // To store minimum index value in range
        // 0..i of preSum vector.
        int[] minInd = new int[n];

        // Insert values in preSum vector.
        for (i = 0; i < n; i++) {
            sum = sum + arr[i];
            preSum[i] = new pair(sum, i);
        }

        Arrays.sort(preSum, new pairSort());

        // Update minInd array.
        minInd[0] = preSum[0].second;

        for (i = 1; i < n; i++) {
            minInd[i] = Math.min(minInd[i - 1], preSum[i].second);
        }

        sum = 0;
        for (i = 0; i < n; i++) {
            sum = sum + arr[i];

            // If sum is greater than k, then answer
            // is i+1.
            if (sum > k)
                maxlen = i + 1;

            // If the sum is less than or equal to k, then
            // find if there is a prefix array having sum
            // that needs to be added to the current sum to
            // make its value greater than k. If yes, then
            // compare the length of updated subarray with
            // maximum length found so far.
            else {
                int ind = findInd(preSum, n, sum - k - 1);
                if (ind != -1 && minInd[ind] < i)
                    maxlen = Math.max(maxlen, i - minInd[ind]);
            }
        }

        return maxlen;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = { -2, 1, 6, -3 };
        int n = arr.length;

        int k = 5;

        // Function call
        System.out.println(largestSub(arr, n, k));
    }
}

// This code is contributed by phasing17
// Java program to find largest subarray
// having sum less than or equal to k.

 

// defining pair class
class pair {
    public int first;
    public int second;

    pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

// implementing compare method
// to sort an array of pairs
class pairSort implements Comparator<pair> {

    public int compare(pair a, pair b) {
        if (a.first == b.first)
            return a.second - b.second;

        return a.first - b.first;
    }
}

class _21_largest_Subarray_having_Sum_less_than_k {

    // Function to find index in preSum vector upto which
    // all prefix sum values are less than or equal to val.
    static int findInd(pair[] preSum, int n, int val) {

        // Starting and ending index of search space.
        int l = 0;
        int h = n - 1;
        int mid;

        // To store required index value.
        int ans = -1;

        // If middle value is less than or equal to
        // val then index can lie in mid+1..n
        // else it lies in 0..mid-1.
        while (l <= h) {
            mid = (l + h) / 2;
            if (preSum[mid].first <= val) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }

        return ans;
    }

    // Function to find largest subarray having sum
    // less than or equal to k.
    static int largestSub(int arr[], int n, int k) {
        int i;

        // Length of largest subarray.
        int maxlen = 0;

        // Vector to store pair of prefix sum
        // and corresponding ending index value.
        pair[] preSum = new pair[n];

        // To store current value of prefix sum.
        int sum = 0;

        // To store maximum index value in range
        // 0..i of preSum vector.
        int[] maxInd = new int[n];

        // Insert values in preSum vector.
        for (i = 0; i < n; i++) {
            sum = sum + arr[i];
            preSum[i] = new pair(sum, i);
        }

        Arrays.sort(preSum, new pairSort());

        // Update maxInd array.
        maxInd[0] = preSum[0].second;

        for (i = 1; i < n; i++) {
            maxInd[i] = Math.max(maxInd[i - 1], preSum[i].second);
        }

        sum = 0;
        for (i = 0; i < n; i++) {
            sum = sum + arr[i];

            // If sum is less than or equal to k, then answer
            // is i+1.
            if (sum <= k)
                maxlen = i + 1;

            // If the sum is greater than k, then find if there is a prefix array
            // having sum that needs to be subtracted from the current sum to
            // make its value less than or equal to k. If yes, then
            // compare the length of updated subarray with
            // maximum length found so far.
            else {
                int ind = findInd(preSum, n, sum - k - 1);
                if (ind != -1 && maxInd[ind] < i)
                    maxlen = Math.max(maxlen, i - maxInd[ind]);
            }
        }

        return maxlen;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = { -2, 1, 6, -3 };
        int n = arr.length;

        int k = 5;

        // Function call
        System.out.println(largestSub(arr, n, k));
    }
}

 

class pair {
    public int first;
    public int second;

    pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

class pairSort implements Comparator<pair> {

    public int compare(pair a, pair b) {
        if (a.first == b.first)
            return a.second - b.second;
        return a.first - b.first;
    }
}

class LargestSubarray {

    static int findInd(pair[] preSum, int n, int val) {
        int l = 0, h = n - 1, mid, ans = -1;
        while (l <= h) {
            mid = (l + h) / 2;
            if (preSum[mid].first <= val) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return ans;
    }

    static int largestSub(int arr[], int n, int k) {
        int maxlen = 0, sum = 0;
        pair[] preSum = new pair[n];
        int[] maxInd = new int[n];
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            preSum[i] = new pair(sum, i);
        }
        Arrays.sort(preSum, new pairSort());
        maxInd[0] = preSum[0].second;
        for (int i = 1; i < n; i++)
            maxInd[i] = Math.max(maxInd[i - 1], preSum[i].second);
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum <= k)
                maxlen = i + 1;
            else {
                int ind = findInd(preSum, n, sum - k - 1);
                if (ind != -1 && maxInd[ind] < i)
                    maxlen = Math.max(maxlen, i - maxInd[ind]);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, 6, -3 };
        int n = arr.length;
        int k = 5;
        System.out.println(largestSub(arr, n, k));
    }
}
