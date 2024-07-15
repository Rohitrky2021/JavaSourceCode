// https://codeforces.com/problemset/problem/231/A


// public class Main {
    
// }
import java.util.Scanner;
 
public class A_E1_team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[][] inputs = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
            inputs[i][2] = scanner.nextInt();
        }
        
        Solution solution = new Solution();
        int result = solution.countProblemsSolved(n, inputs);
        System.out.print(result);
        
        scanner.close();
    }
}

class Solution {
    public int countProblemsSolved(int n, int[][] inputs) {
        int p = 0;
        for (int i = 0; i < n; i++) {
            int a = inputs[i][0];
            int b = inputs[i][1];
            int c = inputs[i][2];
            if (a + b + c > 1) {
                p++;
            }
        }
        return p;
    }
}
