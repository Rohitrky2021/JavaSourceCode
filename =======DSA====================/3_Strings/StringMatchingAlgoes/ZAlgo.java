//     Time Complexity: O(m+n), where m is length of pattern and n is length of text.

// Auxiliary Space: O(m+n)
// A Java program that implements Z algorithm for pattern
// searching
// class GFG {
    public class ZAlgo {

	// prints all occurrences of pattern in text using
	// Z algo
	public static void search(String text, String pattern)
	{

		// Create concatenated string "P$T"
		String concat = pattern + "$" + text;

		int l = concat.length();

		int Z[] = new int[l];

		// Construct Z array
		getZarr(concat, Z);

		// now looping through Z array for matching condition
		for(int i = 0; i < l; ++i){

			// if Z[i] (matched region) is equal to pattern
			// length we got the pattern

			if(Z[i] == pattern.length()){
				System.out.println("Pattern found at index "
							+ (i - pattern.length() - 1));
			}
		}
	}

	// Fills Z array for given string str[]
	private static void getZarr(String str, int[] Z) {

		int n = str.length();
		
		// [L,R] make a window which matches with
		// prefix of s
		int L = 0, R = 0;

		for(int i = 1; i < n; ++i) {

			// if i>R nothing matches so we will calculate.
			// Z[i] using naive way.
			if(i > R){

				L = R = i;

				// R-L = 0 in starting, so it will start
				// checking from 0'th index. For example,
				// for "ababab" and i = 1, the value of R
				// remains 0 and Z[i] becomes 0. For string
				// "aaaaaa" and i = 1, Z[i] and R become 5

				while(R < n && str.charAt(R - L) == str.charAt(R))
					R++;
				
				Z[i] = R - L;
				R--;

			}
			else{

				// k = i-L so k corresponds to number which
				// matches in [L,R] interval.
				int k = i - L;

				// if Z[k] is less than remaining interval
				// then Z[i] will be equal to Z[k].
				// For example, str = "ababab", i = 3, R = 5
				// and L = 2
				if(Z[k] < R - i + 1)
					Z[i] = Z[k];

				// For example str = "aaaaaa" and i = 2, R is 5,
				// L is 0
				else{


				// else start from R and check manually
					L = i;
					while(R < n && str.charAt(R - L) == str.charAt(R))
						R++;
					
					Z[i] = R - L;
					R--;
				}
			}
		}
	}
	
	// Driver program
	public static void main(String[] args)
	{
		String text = "GEEKS FOR GEEKS";
		String pattern = "GEEK";

		search(text, pattern);
	}
}

// This code is contributed by PavanKoli.
// What is Z Array? 
// For a string str[0..n-1], Z array is of same length as string. An element Z[i] of Z array stores length of the longest substring starting from str[i] which is also a prefix of str[0..n-1]. The first entry of Z array is meaning less as complete string is always prefix of itself. 

// Example:

// Index            0   1   2   3   4   5   6   7   8   9  10  11 
// Text             a   a   b   c   a   a   b   x   a   a   a   z
// Z values         X   1   0   0   3   1   0   0   2   2   1   0 

// More Examples:
// str  = "aaaaaa"
// Z[]  = {x, 5, 4, 3, 2, 1}

// str = "aabaacd"
// Z[] = {x, 1, 0, 2, 1, 0, 0}

// str = "abababab"
// Z[] = {x, 0, 6, 0, 4, 0, 2, 0}
 
// How is Z array helpful in Searching Pattern in Linear time? 
// The idea is to concatenate pattern and text, and create a string “P$T” where P is pattern, $ is a special character should not be present in pattern and text, and T is text. Build the Z array for concatenated string. In Z array, if Z value at any point is equal to pattern length, then pattern is present at that point. 

// Example:
// Pattern P = "aab",  Text T = "baabaa"

// The concatenated string is = "aab$baabaa"

// Z array for above concatenated string is {x, 1, 0, 0, 0, 
//                                           3, 1, 0, 2, 1}.
// Since length of pattern is 3, the value 3 in Z array 
// indicates presence of pattern. 
// How to construct Z array? 
//      A Simple Solution is to run two nested loops, the outer loop goes to every index and the inner loop finds length of the longest prefix that matches the substring starting at the current index. The time complexity of this solution is O(n2).
//       We can construct Z array in linear time. 

