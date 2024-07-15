import java.util.*;
public class B {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt(); // Number of test cases
            
            while (t-- > 0) {
                int l = scanner.nextInt(); // Length of the racetrack
                int v1 = scanner.nextInt(); // Tortoise's speed
                int v2 = scanner.nextInt(); // Hare's speed
                
                int tortoiseTime = (int) Math.ceil((double) l / v1);  // Time taken by tortoise
                int hareTime = (int) Math.ceil((double) l / v2); // Time taken by hare (rounded up)
                // System.out.println( tortoiseTime +" "+hareTime);
                
                if (hareTime == tortoiseTime) {
                    System.out.println("-1"); // Hare can't win
                } else {
                    System.out.println(tortoiseTime-hareTime - 1); // Hare can wait for (hareTime - 1) seconds and still win
                }
            }
            
            scanner.close();
        }
    }
    