import java.util.Arrays;
// https://www.geeksforgeeks.org/program-mobius-function/
 
class MobiusFunc {
	
	// Returns value of mobius()    /.
	static int mobius(int n)
	{
		int p = 0;
	
		// Handling 2 separately
		if (n % 2 == 0)
		{
			n = n / 2;
			p++;
	
			// If 2^2 also divides N
			if (n % 2 == 0)
				return 0;
		}
	
		// Check for all other prime factors
		for (int i = 3; i <= Math.sqrt(n); i = i+2)
		{
			// If i divides n
			if (n % i == 0)
			{
				n = n / i;
				p++;
	
				// If i^2 also divides N
				if (n % i == 0)
					return 0;
			}
		}
	
		return (p % 2 == 0)? -1 : 1;
	}
	
	// Driver code
	public static void main (String[] args) 
	{
		int N = 17;
		System.out.println( "Mobius Functions" 	+ " M(N) at N = " + N + " is: " + mobius(N));

		System.out.println ("Mobius Functions" + "M(N) at N = " + 25 + " is: " + mobius(25));

		System.out.println( "Mobius Functions" + "M(N) at N = " + 6 + " is: " + mobius(6));
	}
}

// This code is contributed by anuj_67.
