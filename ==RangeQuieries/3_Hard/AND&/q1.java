class q1 {
    // https://www.geeksforgeeks.org/sum-of-bitwise-and-of-all-subarrays/
    // Function to find the sum of
    // bitwise AND of subarrays in the given range
    static int findAndSumInRange(int[] arr, int start, int end) {
        // variable to store the final sum
        int sum = 0;

        // multiplier
        int mul = 1;

        for (int i = 0; i < 30; i++) {
            // variable to check if counting is on
            boolean count_on = false;

            // variable to store the length of the subarrays
            int l = 0;

            // loop to find the contiguous segments within the specified range
            for (int j = start - 1; j < end; j++) {
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

    // Function to handle queries
    static void handleQueries(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int result = findAndSumInRange(arr, start, end);
            System.out.println("Sum of bitwise AND for subarray [" + start + ", " + end + "]: " + result);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int n = arr.length;

        int[][] queries = {{1, 3}, {2, 4}, {1, 4}};

        handleQueries(arr, queries);
    }
}
