import java.util.Arrays;
// https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
// Time Complexity: O(n+m), where n is the size of the input array arr and m is the maximum value in arr.
// Auxiliary Space: O(m)
// its for Smallest K for Largest Convert K to N-K+1
// and its Not Valid for -ve values also!!!

    public class CountingSort {

	// This function returns the kth smallest element in an
	// array
	static int kthSmallest(int[] arr, int n, int k)
	{  
        int n = arr.length;
      
        k = n - k + 1;  // ya now its lArgest kth

        int minVal = Arrays.stream(arr).min().getAsInt();
        // First, find the maximum element in the array
        int max_element = Arrays.stream(arr).max().getAsInt();

        int rangeSize = max_element - minVal + 1;
        int[] Modified = Arrays.stream(arr).map(num -> num - minVal).toArray();
        int[] freq = new int[rangeSize];

        // Create an array to store the frequency of each
        // element in the input array
        // int[] freq = new int[max_element + 1];
        Arrays.fill(freq, 0);
        for (int i = 0; i < n; i++) {
            freq[Modified[i]]++;
        }

        // Keep track of the cumulative frequency of
        // elements in the input array
        int count = 0;
        for (int i = 0; i <= rangeSize; i++) {
            if (freq[i] != 0) {
                count += freq[i];
                if (count >= k) {
                    // If we have seen k or more elements,
                    // return the current element
                    return i + minVal;
                }
            }
        }
        return -1;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int[] arr = { 3,2,1,5,6,4 };
		int n = arr.length;
		int k = 3;
		System.out.println("The " + k
						+ "th smallest element is "
						+ kthSmallest(arr, n, k));
         System.out.println(arr[kthSmallest(arr, n, k)]);               
	}
}

// This code is contributed by akshitaguprzj3

    

