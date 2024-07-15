import java.util.Arrays;

class D {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;

        // Flatten the 2D array into a 1D array
        int[] items = new int[m * n];
        int index = 0;
        for (int[] row : values) {
            for (int x : row) {
                items[index++] = x;
            }
        }

        // Sort the items array
        Arrays.sort(items);

        long ans = 0;
        int d = 1;

        for (int x : items) {
            ans += 1L * (d++ * x); // Cast d to long before multiplying to avoid overflow
        }

        return ans;
    }

    public static void main(String[] args) {
        D solution = new D();

        // Test Case 1
        int[][] values1 = {{8, 5, 2}, {6, 4, 1}, {9, 7, 3}};
        System.out.println("Test Case 1: " + solution.maxSpending(values1)); // Expected Output: 285

        // Test Case 2
        int[][] values2 = {{10, 8, 6, 4, 2}, {9, 7, 5, 3, 2}};
        System.out.println("Test Case 2: " + solution.maxSpending(values2)); // Expected Output: 386

        // Random Test Case
        int[][] valuesRandom = {{5, 3, 2}, {8, 6, 4}, {7, 1, 9}};
        System.out.println("Random Test Case: " + solution.maxSpending(valuesRandom));
    }
}
