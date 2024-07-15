import java.util.ArrayList;
import java.util.Collections;


public class BitwiseAndSum {
// class Main {
public static final long M = 1000000007;

// **** Not giving correct have to check this use another one in file!!!

public static void findSum(int[] A, int N)
{

	// Stores the total sum
	long ans = 0;

	for (int i = 0; i < 32; i++) {
	ArrayList<Long> vec = new ArrayList<>();

	for (int j = 0; j < N; j++)
	{

		// Check if jth bit is set
		if ((A[j] >> i & 1) == 1)
		{

		// Stores the right shifted element by(i+1)
		long X = (A[j] >> (i + 1)) * (1 << (i + 1)) % M;

		// Push in vector vec
		vec.add(A[j] - X);
		}
	}

	// Sort the vector in ascending order
	Collections.sort(vec);

	// Traverse the vector vec
	for (int j = 0; j < vec.size(); j++)
	{

		// Stores the value 2^(i+1)- 2^(i)- vec[j]
		long Y = (1 << (i + 1)) + (1 << i) - vec.get(j);

		// Stores count of numbers whose value > Y
		long idx = Collections.binarySearch(vec.subList(j + 1, vec.size()), (long) Y);

		// Update the ans
		ans += (vec.size() - (j + 1) - idx) * 1L * (1 << i)-2;
		ans %= M;
	}
	}

	// Return the ans
	System.out.println(ans % M -1);
}

public static void main(String[] args) {
	int[] arr = {1, 3, 3};
	int N = arr.length;
	findSum(arr, N);
}
}

// This code is contributed by aadityaburujwale.


