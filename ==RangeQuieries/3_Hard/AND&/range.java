class range {

    static final int BITS = 32;

    static int andSum(int arr[], int L, int R) {
        int ans = 0;

        for (int i = 0; i < BITS; i++) {
            int countSetBits = 0;

            // Iterating array element in the subarray [L, R]
            for (int j = L; j <= R; j++) {
                // Counting the set bit of array in ith position
                if ((arr[j] & (1 << i)) != 0)
                    countSetBits++;
            }

            // Counting subset which produces sum when a particular bit 
            // position is set.
            int subset = (1 << countSetBits) - 1;

            // Multiplying every position subset with 2^i to count the sum.
            subset = (subset * (1 << i));

            ans += subset;
        }

        return ans;
    }

    static int[] findAndSumForQueries(int arr[], int n, int[][] queries) {
        int[] results = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0] - 1; // left index
            int R = queries[i][1] - 1; // right index
            results[i] = andSum(arr, L, R);
        }

        return results;
    }

    // Drivers code
    public static void main(String args[]) {
        int[] arr = {4, 3, 2, 1};
        int n = arr.length;

        int[][] queries = {{1, 3}, {2, 4}, {1, 4}};

        int[] results = findAndSumForQueries(arr, n, queries);

        // Print results
        for (int result : results) {
            System.out.println(result);
        }
    }
}
