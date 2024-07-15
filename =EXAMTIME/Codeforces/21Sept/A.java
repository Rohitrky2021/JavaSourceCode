import java.util.*;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading t
        
        while (t-- > 0) {
            String cards = scanner.nextLine();
            if (isPossibleToArrange(cards)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
    
    public static boolean isPossibleToArrange(String cards) {
        
        if (cards.contains("abc")) {
            return true;
        }
        
         
        if (cards.equals("acb") || cards.equals("bac") ||  cards.equals("cba")) {
            return true;
        }
        
      
        return false;
    }
}
