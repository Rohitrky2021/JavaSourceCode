public class CandyDistributor {

    class Solution {
        public long distributeCandies(int n, int limit) {
            
            long result = 0;
            
            long min, max;
            
            long rem;
            
            for (int i = 0; i <= limit && i <= n; ++i) {
                rem = n - i;
                
                if (rem > 2 * limit)
                    continue;
                
                min = Math.max(0, rem - limit);
                max = Math.min(rem, limit);
                
                //System.out.println(min + " " + max + " " + rem);
                
                result += Math.max(0, max - min + 1);
            }
            
            return result;
        }
    }

    // Function to calculate combinations
    public long comb2(int num) {
        return 1L * num * (num - 1) / 2; // Calculate combinations using the formula n(n-1)/2
    }

    // Method to distribute candies
    public long distributeCandies(int n, int max) {
        if (n > 3 * max) {
            return 0;
        }

        long ans = comb2(n + 2);

        if (n > max) {
            ans -= 3 * comb2(n - max + 1);
        }

        if (n - 2 >= 2 * max) {
            ans += 3 * comb2(n - 2 * max);
        }

        return ans;
    }

    // Main method for example usage
    public static void main(String[] args) {
        // Example usage:
        CandyDistributor solution = new CandyDistributor();
        long example1 = solution.distributeCandies(5, 2);
        System.out.println("Example 1 Output: " + example1);

        long example2 = solution.distributeCandies(3, 3);
        System.out.println("Example 2 Output: " + example2);
    }
}


public class Solution {

    // Function to calculate combinations
    public long comb2(int num) {
        return 1L * num * (num - 1) / 2; // Calculate combinations using the formula n(n-1)/2
    }

    // Method to distribute candies
    public long distributeCandies(int n, int max) {
        // Check if the number of candies is more than three times the maximum allowed per student
        if (n > 3 * max) {
            return 0; // If so, it's not possible to distribute candies, return 0
        }

        // Calculate the total number of ways to distribute candies initially without any restrictions
        long ans = comb2(n + 2);

        // If the number of candies is more than the maximum allowed per student,
        // subtract the ways to distribute candies with more than the maximum to one student
        if (n > max) {
            ans -= 3 * comb2(n - max + 1);
        }

        // If there are enough candies to distribute to at least two students with the maximum allowed per student,
        // add the ways to distribute candies with more than the maximum to two students
        if (n - 2 >= 2 * max) {
            ans += 3 * comb2(n - 2 * max);
        }

        // Return the total number of ways to distribute candies satisfying the given conditions
        return ans;
    }
}
