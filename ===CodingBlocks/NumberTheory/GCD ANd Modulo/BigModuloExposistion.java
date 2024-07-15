
// Java program of finding modulo multiplication
import java.util.*;
import java.io.*;
public class BigModuloExposistion {    


	// Returns (a * b) % mod
	static long moduloMultiplication(long a, long b, long mod)
	{
		
		// Initialize result
		long res = 0;

		// Update a if it is more than
		// or equal to mod
		a %= mod;

		while (b > 0)
		{
			
			// If b is odd, add a with result
			if ((b & 1) > 0)                //   same like converting in pow of 10^
			{
				res = (res + a) % mod;
			}

			// Here we assume that doing 2*a
			// doesn't cause overflow
			a = (2 * a) % mod;

			b >>= 1; // b = b / 2
		}
		return res;
	}

	// Driver code
	public static void main(String[] args)
	{
		long a = 2;
		long b = 5;
		long m = 10005412336548794L;
		System.out.print(moduloMultiplication(a, b, m));
	}
}

// This code is contributed by Rajput-JI
