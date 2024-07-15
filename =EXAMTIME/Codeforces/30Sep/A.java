import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int a = scanner.nextInt(); // Maximum bomb timer value
            int b = scanner.nextInt(); // Initial bomb timer value
            int n = scanner.nextInt(); // Number of tools
            
            int[] x = new int[n]; // Array to store tool values
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            
            long maxTime = b;
            for(int i:x){
                maxTime+=Math.min(a-1, i);
            }
            System.out.println(maxTime);
        }
        
        scanner.close();
    }
    
    public static long getMaxTime(int a, int b, int[] x) {
        long maxTime = b;
        
        // Iterate through each tool and calculate the maximum time
        for (int i = 0; i < x.length; i++) {
            long currentTime = Math.min(maxTime, a - 1); // Adjust current time based on bug
            long increase = x[i]; // Tool's timer increase
            
            // Calculate the new bomb timer value after using the tool
            long newTime = currentTime + increase;
            maxTime = Math.max(maxTime, newTime);
        }
        
        return maxTime;
    }
}
