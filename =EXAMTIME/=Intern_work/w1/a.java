import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class a {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        scanner.nextLine();  
        Solution solution = new Solution();
        for (int i = 0; t > 0; i++) {
            String s = scanner.nextLine();
            String result = solution.checkString(s);
            System.out.println(result);
            t--;
        }
        
        scanner.close();
    }
}

class Solution {
    public String checkString(String s) {
        if (s.equalsIgnoreCase("YES")) {
            return "YES";
        } else {
            return "NO";
        }
    }
}