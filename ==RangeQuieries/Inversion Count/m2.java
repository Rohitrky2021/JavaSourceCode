public class m2 {
// A O(n^2) Java program to count inversions of size 3

 
	
	// returns count of inversion of size 3
	int getInvCount(int arr[], int n)
	{
		int invcount = 0; // initialize result
		
		for (int i=0 ; i< n-1; i++)
		{
			// count all smaller elements on right of arr[i]
			int small=0;
			for (int j=i+1; j<n; j++) if (arr[i] > arr[j]) small++;
					
			// count all greater elements on left of arr[i]
			int great = 0;
			for (int j=i-1; j>=0; j--) 	if (arr[i] < arr[j]) great++;
					
			// update inversion count by adding all inversions
			// that have arr[i] as middle of three elements
			invcount += great*small;
		}
		return invcount;
	}
	// driver program to test above function
	public static void main(String args[])
	{
		m2 inversion = new m2();
		int arr[] = new int[] {8, 4, 2, 1};
		int n = arr.length;
		System.out.print("Inversion count : " +
					inversion.getInvCount(arr, n));
	}
}

// This code has been contributed by Mayank Jaiswal
