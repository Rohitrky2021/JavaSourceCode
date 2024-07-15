import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of branches Chef saw
            long l = scanner.nextLong(); // Length of the branch Chef has

            List<Integer> ans = new ArrayList<>(); // Corrected the declaration of ArrayList

            ans.add(1);
            ans.add(2);
            for(int i = 2; i < n; i++) { // Changed the loop starting index to 2
                int next = ans.get(i - 1) + ans.get(i - 2);
                if(next > l) break;
                ans.add(i+1);
            }
            
            // Print the numbers
            for(int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println(l - 1); // Print the last number as L-1
        }
    }
}
