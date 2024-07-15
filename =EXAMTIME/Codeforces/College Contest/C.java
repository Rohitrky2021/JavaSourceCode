import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            int movesNeeded = getMovesToMakeValid(s);
            System.out.println(movesNeeded);
        }
    }
    
    public static int getMovesToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int ans=0,a=0;

     for (char c : s.toCharArray()) {
         if (c == '(' ) {
             a++;
             stack.push(c);
         } else {
             if (stack.isEmpty()) {
                 ans++;
                 continue;
             }
             char top = stack.pop();
             if ((c == ')' && top != '(') ) {
                 // return false;
                 ans+=2;
             }
         }
    
     }
  return (Math.abs(ans)+stack.size())/2;
    }
}
