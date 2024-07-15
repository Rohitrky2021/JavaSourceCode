import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        Solution solution = new Solution();
        for (int i = 0; i < n; i++) {
            String st = scanner.nextLine();
            String result = solution.processString(st);
            System.out.println(result);
        }
        
        scanner.close();
    }
}

class Solution {
    public String processString(String s) {
        int l = s.length();
        if (l <= 10) {
            return s;
        } else {
            return "" + s.charAt(0) + (l - 2) + s.charAt(l - 1);
        }
    }
}
