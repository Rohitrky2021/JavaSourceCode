import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the string
            int k = scanner.nextInt(); // Value of k
            
            scanner.nextLine(); // Consume the newline character
            String s = scanner.nextLine(); // The input string
            
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            // Process the string to get the lexicographically smallest string
            for (int i = 0; i < n - 1; i++) {
                if (k == 0) break;
                
                // Find the minimum character between current and next k characters
                int minIndex = i;
                for (int j = i + 1; j < Math.min(n, i + k + 1); j++) {
                    if (chars[j] < chars[minIndex]) {
                        minIndex = j;
                    }
                }
                
                // Swap the minimum character with the current character
                for (int j = minIndex; j > i; j--) {
                    char temp = chars[j];
                    chars[j] = chars[j - 1];
                    chars[j - 1] = temp;
                }
                
                // Update k and the remaining swaps
                k -= (minIndex - i);
            }
            
            System.out.println(new String(chars));
        }
        
        scanner.close();
    }
}


// import java.util.Scanner;

// public class B {

//     public static void solve(Scanner scanner) {
//         int n = scanner.nextInt();
//         int k = scanner.nextInt();
//         String s = scanner.next();

//         if (k % 2 == 0) {
//             char[] charArray = s.toCharArray();
//             java.util.Arrays.sort(charArray);
//             System.out.println(new String(charArray));
//             return;
//         }

//         int[][] cnt = new int[26][2];
//         for (int i = 0; i < n; i++) {
//             cnt[s.charAt(i) - 'a'][i % 2]++;
//         }

//         StringBuilder ans = new StringBuilder();
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 26; j++) {
//                 if (cnt[j][i % 2] > 0) {
//                     cnt[j][i % 2]--;
//                     ans.append((char) (j + 'a'));
//                     break;
//                 }
//             }
//         }

//         System.out.println(ans.toString());
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt();
//         for (int i = 0; i < t; i++) {
//             solve(scanner);
//         }
//     }
// }
