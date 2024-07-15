import java.util.Scanner;
public class MaxiXOR {

	// Function to return the integer X such that
	// (A xor X) + (B ^ X) is minimized
	static int findX(int A, int B)
	{
		int j = 0, x = 0;

		// While either A or B is non-zero
		while (A != 0 || B != 0) {

			// Position at which both A and B
			// have a set bit
			if ((A % 2 == 1) && (B % 2 == 1)) {

				// Inserting a set bit in x
				x += (1 << j);
			}

			// Right shifting both numbers to
			// traverse all the bits
			A >>= 1;
			B >>= 1;
			j += 1;
		}
		return x;
	}

	// Driver code
	public static void main(String[] args)
	{
		int A = 2, B = 3;
		int X = findX(A, B);

		System.out.println(
			"X = " + X + ", Sum = " + ((A ^ X) + (B ^ X)));
	}
}

// This code has been contributed by 29AjayKumar
