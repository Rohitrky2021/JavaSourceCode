 import java.util.*;
// prefixSUmWaala

    // Print modified array after executing the commands of addition and subtraction
//     Given an array of size ‘n’ and a given set of commands of size ‘m’. Every command consist of four integers q, l, r, k. These commands are of following types: 

// If q = 0, add ‘k’ to all integers in range ‘a’ to ‘b'(1 <= a <= b <= n). 
// If q = 1, subtract ‘k’ to all integers in range ‘a’ to ‘b'(1 <= a <= b <= n). 
// Note: Initially all the array elements are set to ‘0’ and array indexing is from ‘1’. 

// Input : n = 5
//         commands[] = {{0 1 3 2}, {1 3 5 3}, 
//                       {0 2 5 1}}
// Output : 0 2 -1 -1 -3
// Explanation
// First command: Add 2 from index 1 to 3
// >=  2 2 2 0 0
// Second command: Subtract 3 from index 3 to 5 
// >= 2 2 -1 -3 -3
// Third command: Add 1 from index 2 to 5
// >= 2 3 0 -2 -2
// Java program to find modified array
// after executing m commands/queries
 

class AddSubtraInRange {
	
	// Update function for every command
	static void updateQuery(int arr[], int n,
				int q, int l, int r, int k)
	{
		
		// If q == 0, add 'k' and '-k'
		// to 'l-1' and 'r' index
		if (q == 0){
			arr[l-1] += k;
			arr[r] += -k;
		}
	
		// If q == 1, add '-k' and 'k'
		// to 'l-1' and 'r' index
		else{
			arr[l-1] += -k;
			arr[r] += k;
		}
		
		return;
	}
	
	// Function to generate the final
	// array after executing all
	// commands
	static void generateArray(int arr[], int n)
	{
		// Generate final array with the
		// help of DP concept
		for (int i = 1; i < n; ++i)
			arr[i] += arr[i-1];
		
	}
	//driver code
	public static void main(String arg[])
	{
		int n = 5;
		int arr[] = new int[n+1];
		
		//Set all array elements to '0'
		Arrays.fill(arr, 0);
		
		int q = 0, l = 1, r = 3, k = 2;
		updateQuery(arr, n, q, l, r, k);
	
		q = 1 ; l = 3; r = 5; k = 3;
		updateQuery(arr, n, q, l, r, k);
	
		q = 0 ; l = 2; r = 5; k = 1;
		updateQuery(arr, n, q, l, r, k);
	
		// Generate final array
		generateArray(arr, n);
	
		// Printing the final modified array
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i]+" ");
	}
}

// This code is contributed by Anant Agarwal.

 