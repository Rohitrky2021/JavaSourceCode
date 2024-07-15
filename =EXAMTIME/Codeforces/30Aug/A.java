import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // number of subscribers
            int a = scanner.nextInt(); // initial number of subscribers online
            int q = scanner.nextInt(); // number of notifications
            String notifications = scanner.next(); // notification string
            
            int onlineSubscribers = a;
            boolean possible = false;
            
            if (onlineSubscribers == n) {
                System.out.println("YES");
                continue;
            }
            int neg=0,plus=0,cnt=0;
            
            int maxOnlineSubscribers = a; // Initialize maximum online subscribers
            
            for (int i = 0; i < q; i++) {
                char notification = notifications.charAt(i);
                if (notification == '-') {
                    neg--;
                } else {
                    neg++;
                    plus++;
                }
                if(neg+a==n){
                    possible=true;
                }
                
                // If the number of online subscribers becomes negative or exceeds n, it's not possible for all to read

                // Update the maximum online subscribers
                // maxOnlineSubscribers = Math.max(maxOnlineSubscribers, onlineSubscribers);
            }
            
            if (possible) {
                System.out.println("YES"); // All subscribers have read the post
            } else if (plus+a>=n) {
                System.out.println("MAYBE"); // Some subscribers may not have read the post
            } else {
                System.out.println("NO"); // It's impossible for all subscribers to read the post
            }
        }
    }
}
