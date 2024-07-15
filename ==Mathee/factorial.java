import java.util.ArrayList;

public class factorial {
    public static void main(String[] args) {
        int n = 5;
        int factorial = calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }

    public static int calculateFactorial(int n) {
        int[] sieve = new int[n + 1];
        sieve[0] = 1;

        for (int i = 1; i <= n; i++) {
            sieve[i] = i * sieve[i - 1];
        }
        ArrayList<Integer> ans=new ArrayList<>();

        for(int x:sieve){
            
        }

        return sieve[n];
    }

 
}
