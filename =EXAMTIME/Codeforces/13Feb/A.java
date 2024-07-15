import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Encoded word
            int remaining = n - 1; // Subtract 1 for 'a'
            
            // Determine the first letter
            int first = Math.min(remaining, 25)-2; // 'z' has position 26
            remaining -= first+2;
            
            // Determine the second letter
            int second = Math.min(remaining, 25); // 'z' has position 26
            remaining -= second;
            
            // The third letter is whatever is remaining
            int third = remaining;
            
            // Convert positions to letters and store in an array
            char[] letters = {(char) ('a' + first), (char) ('a' + second), (char) ('a' + third)};
            
            // Sort the array
            Arrays.sort(letters);
            
            // Construct the string from sorted characters
            String sortedString = new String(letters);
            
            // Output the lexicographically smallest word
            System.out.println(sortedString);
        }
        
        scanner.close();
    }
}
