public class SuffixArray {
    // geeksforgeeks.org/suffix-array-set-2-a-((nlognlogn))-algorithm/
    
//     Input: str = “banana”
// Output: {5, 3, 1, 0, 4, 2}
// Explanation:
// Suffix per index                         Suffix sorted alphabetically
// ———————–         —————————————–
// 0 banana                                            5 a
// 1 anana          Sort the Suffixes          3 ana
// 2 nana           —————– —>   1 anana  
// 3 ana                alphabetically           0 banana  
// 4 na                                                  4 na   
// 5 a                                                    2 nana
// So the suffix array for “banana” is {5, 3, 1, 0, 4, 2}
// Note that the above algorithm uses standard sort function and therefore time complexity is O(n Log(n) Log(n)). 
// We can use Radix Sort here to reduce the time complexity to O(n Log n). 

// Auxiliary Space: O(n)
// Java program for building suffix array of a given text
import java.util.*;
class GFG
{
	// Class to store information of a suffix
	public static class Suffix implements Comparable<Suffix>
	{
		int index;
		int rank;
		int next;

		public Suffix(int ind, int r, int nr)
		{
			index = ind;
			rank = r;
			next = nr;
		}
		
		// A comparison function used by sort()
		// to compare two suffixes.
		// Compares two pairs, returns 1
		// if first pair is smaller
		public int compareTo(Suffix s)
		{
			if (rank != s.rank) return Integer.compare(rank, s.rank);
			return Integer.compare(next, s.next);
		}
	}
	
	// This is the main function that takes a string 'txt'
	// of size n as an argument, builds and return the
	// suffix array for the given string
	public static int[] suffixArray(String s)
	{
		int n = s.length();
		Suffix[] su = new Suffix[n];
		
		// Store suffixes and their indexes in
		// an array of classes. The class is needed
		// to sort the suffixes alphabetically and
		// maintain their old indexes while sorting
		for (int i = 0; i < n; i++)
		{
			su[i] = new Suffix(i, s.charAt(i) - '$', 0);
		}
		for (int i = 0; i < n; i++)
			su[i].next = (i + 1 < n ? su[i + 1].rank : -1);

		// Sort the suffixes using the comparison function
		// defined above.
		Arrays.sort(su);

		// At this point, all suffixes are sorted
		// according to first 2 characters.
		// Let us sort suffixes according to first 4
		// characters, then first 8 and so on
		int[] ind = new int[n];
		
		// This array is needed to get the index in suffixes[]
		// from original index. This mapping is needed to get
		// next suffix.
		for (int length = 4; length < 2 * n; length <<= 1)
		{
			
			// Assigning rank and index values to first suffix
			int rank = 0, prev = su[0].rank;
			su[0].rank = rank;
			ind[su[0].index] = 0;
			for (int i = 1; i < n; i++)
			{
				// If first rank and next ranks are same as
				// that of previous suffix in array,
				// assign the same new rank to this suffix
				if (su[i].rank == prev &&
					su[i].next == su[i - 1].next)
				{
					prev = su[i].rank;
					su[i].rank = rank;
				}
				else
				{
					// Otherwise increment rank and assign
					prev = su[i].rank;
					su[i].rank = ++rank;
				}
				ind[su[i].index] = i;
			}
			
			// Assign next rank to every suffix
			for (int i = 0; i < n; i++)
			{
				int nextP = su[i].index + length / 2;
				su[i].next = nextP < n ?
				su[ind[nextP]].rank : -1;
			}
			
			// Sort the suffixes according
			// to first k characters
			Arrays.sort(su);
		}

		// Store indexes of all sorted
		// suffixes in the suffix array
		int[] suf = new int[n];
		
		for (int i = 0; i < n; i++)
			suf[i] = su[i].index;

		// Return the suffix array
		return suf;
	}
	
	static void printArr(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	// Driver Code
	public static void main(String[] args)
	{
		String txt = "banana";
		int n = txt.length();
		int[] suff_arr = suffixArray(txt);
		System.out.println("Following is suffix array for banana:");
		printArr(suff_arr, n);
	}
}

// This code is contributed by AmanKumarSingh


