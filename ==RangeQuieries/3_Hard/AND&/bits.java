public class bits {

    // Function to find the sum of
    // bitwise AND of all subarrays in the range [L, R]
    static int findAndSum(int[] arr, int n, int L, int R) {
        // Check if L and R are within bounds
        if (L < 0 || R >= n || L > R) {
            System.out.println("Invalid range.");
            return 0;
        }

        // variable to store
        // the final sum
        int sum = 0;

        // multiplier
        int mul = 1;

        for (int i = 0; i < 30; i++) {
            // variable to check if
            // counting is on
            boolean count_on = false;

            // variable to store the
            // length of the subarrays
            int l = 0;

            // loop to find the contiguous
            // segments within the range [L, R]
            for (int j = L; j <= R; j++) {
                if ((arr[j] & (1 << i)) > 0)
                    if (count_on)
                        l++;
                    else {
                        count_on = true;
                        l++;
                    }
                else if (count_on) {
                    sum += ((mul * l * (l + 1)) / 2);
                    count_on = false;
                    l = 0;
                }
            }

            if (count_on) {
                sum += ((mul * l * (l + 1)) / 2);
                count_on = false;
                l = 0;
            }

            // updating the multiplier
            mul *= 2;
        }

        // returning the sum
        return sum;
    }

    // Function to calculate the sum for all queries
    static int[] findAndSumForQueries(int[] arr, int n, int[][] queries) {
        int numQueries = queries.length;
        int[] result = new int[numQueries];

        for (int i = 0; i < numQueries; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            result[i] = findAndSum(arr, n, L, R);
        }

        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {1, 0, 2};
        int n = arr.length;

        int[][] queries = {{1, 2}, {2, 3}};

        int[] results = findAndSumForQueries(arr, n, queries);

        // Print results
        for (int result : results) {
            System.out.println(result);
        }
    }
}
