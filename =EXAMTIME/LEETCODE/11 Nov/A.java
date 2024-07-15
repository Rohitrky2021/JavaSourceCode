class Solution {
    public int distributeCandies(int n, int limit) {
        int result = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k >= 0 && k <= limit) {
                    result++;
                }
            }
        }
        return result;
    }

 
}

public class DistributeCandies {
    public static int distributeCandies(int n, int limit) {
        int result = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k >= 0 && k <= limit) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int example1 = distributeCandies(5, 2);
        System.out.println("Example 1 Output: " + example1);

        int example2 = distributeCandies(3, 3);
        System.out.println("Example 2 Output: " + example2);
    }
}
