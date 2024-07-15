// Given an array of N positive integers. There are Q queries, each include a range [L, R]. 
// For each query output the xor of greatest odd divisor of each number in that range.

// Examples: 

// Input : arr[] = { 3, 4, 5 }
// query 1: [0, 2]
// query 2: [1, 2]
// Output : 7 4
// Greatest odd divisor are: { 3, 1, 5 }
// XOR of 3, 1, 5 is 7
// XOR of 1, 5 is 4

// M1-->using answer each query, return (preXOR[r] xor preXOR[l-1]).
// Java code Queries on XOR of
// greatest odd divisor of the range
import java.io.*;

// class GFG
// {
    public class XorOFOddDivisor {
	// Precompute the prefix XOR of greatest
	// odd divisor
	static void prefixXOR(int arr[], int preXOR[], int n)
	{
		// Finding the Greatest Odd divisor
		for (int i = 0; i < n; i++)
		{
			while (arr[i] % 2 != 1)
				arr[i] /= 2;
	
			preXOR[i] = arr[i];
		}
	
		// Finding prefix XOR
		for (int i = 1; i < n; i++)
			preXOR[i] = preXOR[i - 1] ^ preXOR[i];
	}
	
	// Return XOR of the range
	static int query(int preXOR[], int l, int r)
	{
		if (l == 0)
			return preXOR[r];
		else
			return preXOR[r] ^ preXOR[l - 1];
	}
	
	// Driven Program
	public static void main (String[] args)
	{
		int arr[] = { 3, 4, 5 };
		int n = arr.length;
	
		int preXOR[] = new int[n];
		prefixXOR(arr, preXOR, n);
	
		System.out.println(query(preXOR, 0, 2)) ;
		System.out.println (query(preXOR, 1, 2));
	
			
	}
}

// This article is contributed by vt_m


