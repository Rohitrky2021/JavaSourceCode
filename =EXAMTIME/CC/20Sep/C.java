import java.util.*;
public class C {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt(); // Number of test cases
    
            while (t-- > 0) {
                int n = sc.nextInt(); // Length of the string
                int m = sc.nextInt(); // Length of the secret code
                sc.nextLine(); // Consume the newline character
    
                String s = sc.nextLine(); // The string on the digital lock
                String k = sc.nextLine(); // The secret code
    
                int minMoves = findMinMoves(s, k);
                System.out.println(minMoves);
            }
            sc.close();
        }
    
        public static int findMinMoves(String s, String k) {
            int n = s.length();
            int m = k.length();
            int minMoves = Integer.MAX_VALUE;
    
            for (int i = 0; i <= n - m; i++) {
                int moves = 0;
                for (int j = 0; j < m; j++) {
                    int diff = Math.abs(s.charAt(i + j) - k.charAt(j));
                    moves += Math.min(diff, 10 - diff);
                }
                minMoves = Math.min(minMoves, moves);
            }
    
            return minMoves;
        }
    }
    