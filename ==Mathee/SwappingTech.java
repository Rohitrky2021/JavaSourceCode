// Java Program to swap two numbers without
// using temporary variable
import java.io.*;

// class Geeks {
    public class SwappingTech {

	public static void main(String a[])
	{
		int x = 10;
		int y = 5;
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("After swapping:"+ " x = " + x + ", y = " + y);
	}
}

// This code is contributed by Mayank Tyagi
// Java Program to swap two numbers without using temporary
// variable
// import java.io.*;

class GFG {
	public static void main(String[] args)
	{
		int x = 10;
		int y = 5;

		// Code to swap 'x' and 'y'
		x = x * y; // x now becomes 50
		y = x / y; // y becomes 10
		x = x / y; // x becomes 5

		System.out.println("After swapping:"
						+ " x = " + x + ", y = " + y);
	}
}

// This code is contributed by Aditya Kumar (adityakumar129)
// Java code to swap using XOR
// import java.io.*;

public class GFG {

	public static void main(String a[])
	{
		int x = 10;
		int y = 5;

		// Code to swap 'x' (1010) and 'y' (0101)
		x = x ^ y; // x now becomes 15 (1111)
		y = x ^ y; // y becomes 10 (1010)
		x = x ^ y; // x becomes 5 (0101)

		System.out.println("After swap: x = "
						+ x + ", y = " + y);
	}
}

// // This code is contributed by Mayank Tyagi
class GFG {
	static void swap(int[] xp, int[] yp)
	{
		xp[0] = xp[0] ^ yp[0];
		yp[0] = xp[0] ^ yp[0];
		xp[0] = xp[0] ^ yp[0];
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] x = { 10 };
		swap(x, x);
		System.out.println("After swap(&x, &x): x = " + x[0]);
	}
}

// // This code is contributed by Aditya Kumar (adityakumar129)
// // Java program of above approach
class GFG {

	static void swap(int xp, int yp)
	{
		if (xp == yp) // Check if the two addresses are same
			return;
		xp = xp + yp;
		yp = xp - yp;
		xp = xp - yp;
	}

	// Driver code
	public static void main(String[] args)
	{
		int x = 10;
		swap(x, x);
		System.out.println("After swap(&x, &x): x = " + x);
	}
}

// // This code is Contributed by Code_Mech.
// // Java program to swap two numbers
// import java.io.*;

class GFG {
	public static void swap(int a, int b)
	{
		// same as a = a + b
		a = (a & b) + (a | b);
		// same as b = a - b
		b = a + (~b) + 1;
		// same as a = a - b
		a = a + (~b) + 1;
		System.out.print("After swapping: a = " + a + ", b = " + b);
	}
	public static void main(String[] args)
	{
		int a = 5, b = 10;
		// Function Call
		swap(a, b);
	}
}

// // This code is contributed by Aditya Kumar (adityakumar129)
// /*package whatever //do not write package name here */
// import java.io.*;

class GFG {
	public static void main(String[] args)
	{
		int x = 10;
		int y = 5;
		x = (x * y) / (y = x);
		System.out.println("After swapping:"
						+ " x = " + x + ", y = " + y);
	}
}

// // This code is contributed by isha307

