
// Java implementation to increment values in the 
// given range by a value d for multiple queries
class _10_Increment_in_range_by_d {

    // structure to store the (start, end)
    // index pair for each query
    static class query {
        int start, end;

        query(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // function to increment values in the given range
    // by a value d for multiple queries
    public static void incrementByD(int[] arr, query[] q_arr,
            int n, int m, int d) {
        int[] sum = new int[n];

        // for each (start, end) index pair, perform
        // the following operations on 'sum[]'
        for (int i = 0; i < m; i++) {

            // increment the value at index 'start'
            // by the given value 'd' in 'sum[]'
            sum[q_arr[i].start] += d;

            // if the index '(end+1)' exists then
            // decrement the value at index '(end+1)'
            // by the given value 'd' in 'sum[]'
            if ((q_arr[i].end + 1) < n)
                sum[q_arr[i].end + 1] -= d;
        }

        // Now, perform the following operations:
        // accumulate values in the 'sum[]' array and
        // then add them to the corresponding indexes
        // in 'arr[]'
        arr[0] += sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
            arr[i] += sum[i];
        }
    }

    // function to print the elements of the given array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 3, 5, 4, 8, 6, 1 };
        query[] q_arr = new query[5];
        q_arr[0] = new query(0, 3);
        q_arr[1] = new query(4, 5);
        q_arr[2] = new query(1, 4);
        q_arr[3] = new query(0, 1);
        q_arr[4] = new query(2, 5);
        int n = arr.length;
        int m = q_arr.length;
        int d = 2;
        System.out.println("Original Array:");
        printArray(arr, n);

        // modifying the array for multiple queries
        incrementByD(arr, q_arr, n, m, d);
        System.out.println("\nModified Array:");
        printArray(arr, n);
    }
}

// This code is contributed by
// sanjeev2552
