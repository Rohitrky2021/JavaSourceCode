import java.util.Scanner;

public class C {
    
    // Function to calculate GCD using Euclid's Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt(); // count of 0s
            int y = scanner.nextInt(); // count of 1s
            
            // Calculate GCD of x and y
            int gcdXY = gcd(x, y);
            
            // The largest K possible is the GCD of x and y
            int largestK = gcdXY;
            
            System.out.println(largestK);
        }
        scanner.close();
    }
}
