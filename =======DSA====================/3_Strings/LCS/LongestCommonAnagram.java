public class LongestCommonAnagram {
    // https://www.geeksforgeeks.org/longest-common-anagram-subsequence/
    // Time Complexity: O(n+m). 
    
// Input : str1 = "abdacp", str2 = "ckamb"
// Output : 3
// Subsequence of str1 = abc
// Subsequence of str2 = cab
//           OR
// Subsequence of str1 = bac
// Subsequence of str2 = cab

// These are longest common anagram subsequences.

// Input : str1 = "abbcfke", str2 = "fbaafbly"
// Output : 4
// Java implementation to find
// the length() of the longest
// common anagram subsequence
import java.io.*;

class GFG
{
	static int SIZE = 26;
	
	// function to find the
	// length() of the longest
	// common anagram subsequence
	static int longCommonAnagramSubseq(String str1,
									String str2,
									int n1, int n2)
	{
		// hash tables for
		// storing frequencies
		// of each character
		int []freq1 = new int[SIZE];
		int []freq2 = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++)
		{
			freq1[i] = 0;
			freq2[i] = 0;
		}
		
		int len = 0;
		
		// calculate frequency
		// of each character of
		// 'str1[]'
		for (int i = 0; i < n1; i++)
			freq1[(int)str1.charAt(i) - (int)'a']++;
		
		// calculate frequency
		// of each character
		// of 'str2[]'
		for (int i = 0; i < n2; i++)
			freq2[(int)str2.charAt(i) - (int)'a']++;
		
		// for each character add
		// its minimum frequency
		// out of the two Strings
		// in 'len'
		for (int i = 0; i < SIZE; i++)
			len += Math.min(freq1[i],
							freq2[i]);
		
		// required length()
		return len;
	}							
	
	// Driver Code
	public static void main(String args[])
	{
		String str1 = "abdacp";
		String str2 = "ckamb";
		int n1 = str1.length();
		int n2 = str2.length();
		System.out.print("Length = " +
				longCommonAnagramSubseq(str1, str2,
										n1, n2));
	}
}

// This code is contributed by
// Manish Shaw(manishshaw1)


