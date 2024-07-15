// public class Solution {
    import java.util.*;
        public class A {
        public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
            int N = A.size();
            int[] dp = new int[N];
    
            // Initialize the dp array with the values from array B
            for (int i = 0; i < N; i++) {
                dp[i] = B.get(i);
            }
    
            int maxCost = 0;
    
            // Loop through each index and update the dp array based on the constraints
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (A.get(j) >= A.get(i) - 1) {
                        dp[i] = Math.max(dp[i], dp[j] + B.get(i));
                    }
                }
                maxCost = Math.max(maxCost, dp[i]);
            }
    
            return maxCost;
        }
        
        public static void main(String[] args) {
            A solution = new A();
            ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(-1, -2, -3, 4, 3, 2, 1));
            ArrayList<Integer> B1 = new ArrayList<>(Arrays.asList(4, 6, 2, 3, 8, 4, 5));
            System.out.println(solution.solve(A1, B1)); // Output: 23
            
            ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(5, 4, 3, 6, 7));
            ArrayList<Integer> B2 = new ArrayList<>(Arrays.asList(6, 8, 2, 9, 4));
            System.out.println(solution.solve(A2, B2)); // Output: 27
        }
    }
    