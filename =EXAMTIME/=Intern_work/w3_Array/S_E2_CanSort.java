     
import java.util.Scanner;
import java.util.Vector;

    // https://codeforces.com/problemset/problem/1891/A
 
    public class S_E2_CanSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        Solution solution = new Solution();

        while (t-- > 0) {
            int n = scanner.nextInt();  
            Vector<Integer> a = new Vector<>();

            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }

            if (solution.canSortArray(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

class Solution {
    public boolean canSortArray(Vector<Integer> a) {
        int n = a.size();

        for (int i = 0; i + 1 < n; i++) {
            if (a.get(i) > a.get(i + 1)) {
                if ((i & (i + 1)) != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
