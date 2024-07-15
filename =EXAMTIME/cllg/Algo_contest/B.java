// Java program to implement the above problem
class B
{

	// Function to find the maximum
	// number of regions on a plane
	static void maxRegions(int n) 
	{
		int num;
		num = n * (n + 1) / 2 + 1;

		// print the maximum number of regions
		System.out.println(num);;
	}

	// Driver code
	public static void main(String[] args) 
	{
		int n = 10;
		maxRegions(n);
	}
}

// This code is contributed by 29AjayKumar
