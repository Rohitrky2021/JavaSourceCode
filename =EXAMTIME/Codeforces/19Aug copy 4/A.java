import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            boolean hasA = false, hasB = false, hasC = false;
            
             if (s.charAt(i) == 'A') hasA = true;
            if (s.charAt(i) == 'B') hasB = true;
            if (s.charAt(i) == 'C') hasC = true;
            
             if (i > 0) {
                if (s.charAt(i - 1) == 'A') hasA = true;
                if (s.charAt(i - 1) == 'B') hasB = true;
                if (s.charAt(i - 1) == 'C') hasC = true;
            }
            
             if (i < n - 1) {
                if (s.charAt(i + 1) == 'A') hasA = true;
                if (s.charAt(i + 1) == 'B') hasB = true;
                if (s.charAt(i + 1) == 'C') hasC = true;
            }
            
             if (hasA && hasB && hasC) {
                System.out.println("Yes");
                return;
            }
        }
        
        System.out.println("No");
    }
}
