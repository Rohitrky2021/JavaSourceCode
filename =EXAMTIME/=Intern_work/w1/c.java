import java.util.*;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int t = sc.nextInt();
            sc.nextLine();  
            Solution solution = new Solution();
            
            for (int i = 0; i < t; i++) {
                String s = sc.nextLine().trim();
                int result = solution.numDecodings(s);
                System.out.println(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers where expected.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format. Please enter the encoded message.");
        } finally {
            sc.close();
        }
    }
}

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}






 