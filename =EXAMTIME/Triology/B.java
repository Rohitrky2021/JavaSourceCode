import java.util.*;

public class B {
    public int solve(ArrayList<String> A, String B) {
        Set<String> prefixes = new HashSet<>();
        
        // Add all possible prefixes to the hash set
        for (String str : A) {
            for (int i = 0; i < str.length(); i++) {
                prefixes.add(str.substring(0, i + 1));
            }
        }
        
        int count = 0;
        int endIndex = 0;
        
        // Iterate through string B
        for (int i = 0; i < B.length(); i++) {
            if (prefixes.contains(B.substring(endIndex, i + 1))) {
                if (i == B.length() - 1) {
                    count++; // Increment count if the current prefix is valid and at the end of B
                }
                endIndex = i + 1; // Move the end index for the next iteration
                count++; // Increment the count for the current valid prefix
            }
        }
        
        // If the end index is not at the end of B, return -1
        if (endIndex != B.length()) {
            return -1;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        B solution = new B();
        
        ArrayList<String> A1 = new ArrayList<>(Arrays.asList("abc", "bcb", "ka", "efgh"));
        String B1 = "efkabc";
        System.out.println("Output 1: " + solution.solve(A1, B1)); // Expected: 3
        
        ArrayList<String> A2 = new ArrayList<>(Arrays.asList("abcb", "cbdc"));
        String B2 = "abcbabd";
        System.out.println("Output 2: " + solution.solve(A2, B2)); // Expected: -1
    }
}
