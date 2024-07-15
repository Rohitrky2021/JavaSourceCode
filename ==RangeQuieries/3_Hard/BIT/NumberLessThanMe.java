// Java program to answer queries to count number
// of elements smaller than or equal to x.

// Time Complexity: O((n+q)*log(n))

// Auxiliary Space: O(n+q)

import java.util.*;

// structure to hold queries
class Query {
    int l, r, x, idx;
    
    public Query(int l, int r, int x, int idx) {
        this.l = l;
        this.r = r;
        this.x = x;
        this.idx = idx;
    }
}

// structure to hold array
class ArrayElement implements Comparable<ArrayElement> {
    int val, idx;

    public ArrayElement(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
    
    // bool function to sort array according to its value
    public int compareTo(ArrayElement other) {
        return Integer.compare(this.val, other.val);
    }
}

public class NumberLessThanMe {
// public class GFG {
    // bool function to sort queries according to k
    static boolean cmp1(Query q1, Query q2) {
        return q1.x < q2.x;
    }

    // updating the bit array
    static void update(int bit[], int idx, int val, int n) {
        for (; idx <= n; idx += idx & -idx)
            bit[idx] += val;
    }

    // querying the bit array
    static int query(int bit[], int idx, int n) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx)
            sum += bit[idx];
        return sum;
    }

    static void answerQueries(int n, Query queries[], int q,
            ArrayElement arr[]) {
        // initialising bit array
        int bit[] = new int[n + 1];
        Arrays.fill(bit, 0);

        // sorting the array
        Arrays.sort(arr);

        // sorting queries
        Arrays.sort(queries, (q1, q2) -> Integer.compare(q1.x, q2.x));

        // current index of array
        int curr = 0;

        // array to hold answer of each Query
        int ans[] = new int[q];

        // looping through each Query
        for (int i = 0; i < q; i++) {
            // traversing the array values till it
            // is less than equal to Query number
            while (curr < n && arr[curr].val <= queries[i].x) {
                // updating the bit array for the array index
                update(bit, arr[curr].idx + 1, 1, n);
                curr++;
            }

            // Answer for each Query will be number of
            // values less than equal to x upto r minus
            // number of values less than equal to x
            // upto l-1
            ans[queries[i].idx] = query(bit, queries[i].r + 1, n) -
                    query(bit, queries[i].l, n);
        }

        // printing answer for each Query
        for (int i = 0; i < q; i++)
            System.out.println(ans[i]);
    }

    public static void main(String[] args) {
        // size of array
        int n = 4;

        // initializing array value and index
        ArrayElement[] arr = new ArrayElement[n];
        arr[0] = new ArrayElement(2, 0);
        arr[1] = new ArrayElement(3, 1);
        arr[2] = new ArrayElement(4, 2);
        arr[3] = new ArrayElement(5, 3);

        // number of queries
        int q = 2;
        Query[] queries = new Query[q];
        queries[0] = new Query(0, 2, 2, 0);
        queries[1] = new Query(0, 3, 5, 1);

        answerQueries(n, queries, q, arr);
    }
}

// this code is contributed by bhardwajji
// Given an array ‘a[]’ and number of queries q. Each query can be represented by l, r, x.
//  Your task is to print the number of elements less than or equal to x in the subarray represented by l to r. Examples:

// Input : arr[] = {2, 3, 4, 5}
//             q = 2
//             0 3 5
//             0 2 2 
// Output : 4
//          1
// Number of elements less than or equal to
// 5 in arr[0..3] is 4 (all elements)

// Number of elements less than or equal to
// 2 in arr[0..2] is 1 (only 2)
// Naive approach The naive approach for each query traverse the subarray and count the number of elements which are in the given range. 

// Efficient Approach The idea is to use-Binary Index Tree. Note in the following steps x is the number 
// according to which you have to find the elements and the subarray is represented by l, r.
//  Step 1: Sort the array in ascending order.
//   Step 2: Sort the queries according to x in ascending order, initialize bit array as 0. 
//   Step 3: Start from the first query and traverse the array till the value in the array is less than equal to x.
//    For each such element update the BIT with value equal to 1 Step 4: Query the BIT array in the range l to r 