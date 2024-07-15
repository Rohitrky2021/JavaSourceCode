public class m1 {
// A simple Java implementation to count inversion of size 3
class Inversion{
	
	// returns count of inversion of size 3
	int getInvCount(int arr[], int n)
	{
		int invcount = 0; // initialize result
		
		for(int i=0 ; i< n-2; i++)
		{
			for(int j=i+1; j<n-1; j++)
			{
				if(arr[i] > arr[j])
				{
					for(int k=j+1; k<n; k++)
					{
						if(arr[j] > arr[k])
							invcount++;
					}
				}
			}
		}
		return invcount;
	}

	// driver program to test above function
	public static void main(String args[])
	{
		Inversion inversion = new Inversion();
		int arr[] = new int[] {8, 4, 2, 1};
		int n = arr.length;
		System.out.print("Inversion count : " + 
					inversion.getInvCount(arr, n));
	}
}
// This code is contributed by Mayank Jaiswal
