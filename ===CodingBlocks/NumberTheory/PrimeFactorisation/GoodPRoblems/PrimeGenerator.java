import java.util.Arrays;
import java.util.Scanner;

public class PrimeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            generatePrimesInRange(m,n);

            if (i < t - 1) {
                System.out.println(); // Separate test cases with an empty line
            }
        }

        scanner.close();
    }

    // Function to generate prime numbers in the given range [m, n]
    public static void generatePrimesInRange( int m,int n) {
       		// prime[i] is going to store true if
		// if i*2 + 1 is composite.
		boolean prime[]=new boolean[Math.max(m, n)*2];
		Arrays.fill(prime, false);
	
		// 2 is the only even prime so we can
		// ignore that. Loop starts from 3.
		for (int i = m ; i * i < n; i += 2)
		{
			// If i is prime, mark all its
			// multiples as composite
			if (prime[i / 2] == false)
				for (int j = i * i; j < n; j += i * 2)
					prime[j / 2] = true;
		}
	
		// writing 2 separately
		System.out.print("2 ");
	
		// Printing other primes
		for (int i = m; i < n ; i += 2)
			if (prime[i / 2] == false)
				System.out.print(i + " ");
    }
}
