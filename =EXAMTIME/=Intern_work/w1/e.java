 import java.util.*;

public class e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
         int t = sc.nextInt();
        Solution solution = new Solution();
        
         for (int i = 0; i < t; i++) {

             int n = sc.nextInt();

             String s = sc.next();

             int ans = solution.countDistinctStrings(s, n);
            
            System.out.println(ans);
        }
    }catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter integers where expected.");
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid input format. Please enter length and string separated by space.");
    }
        sc.close();
    }
}

class Solution {
    public int countDistinctStrings(String s, int n) {
        int ans = n - 1;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i - 1) == s.charAt(i + 1)) {
                ans--;
            }
        }
        return ans;
    }
}
