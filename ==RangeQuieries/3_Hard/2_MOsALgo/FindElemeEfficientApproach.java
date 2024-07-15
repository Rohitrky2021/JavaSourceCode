// Java Program to compute sum of ranges for
// different range queries
// The index variable for R changes at most O(n * \sqrt{n}) times throughout the run and that for L changes
//  its value at most O(m * \sqrt{n})times.
//   Hence, processing all queries takes O(n * \sqrt{n})+ O(m * \sqrt{n}) = O((m+n) * \sqrt{n})time.
// The space complexity of the given program is O((m+n) * sqrt(n)) 

import java.util.*;

// Class to represent a query range
class Query{
    int L;
	int R;
	int x;
	Query(int L, int R,int x){
        this.L = L;
		this.R = R;
		this.x=x;
	}
}

// class Main{
    public class FindElemeEfficientApproach {

	// Prints sum of all query ranges. m is number of queries
	// n is size of array a[].
	static void queryResults(int a[], int n, ArrayList<Query> q, int m){
		
		// Find block size
		int block = (int) Math.sqrt(n);
	
		// Sort all queries so that queries of same blocks
		// are arranged together.
		Collections.sort(q, new Comparator<Query>(){
			
			// Function used to sort all queries so that all queries
			// of the same block are arranged together and within a block,
			// queries are sorted in increasing order of R values.
			public int compare(Query x, Query y){

				// Different blocks, sort by block.
				if (x.L/block != y.L/block)
					return (x.L < y.L ? -1 : 1);

				// Same block, sort by R value
				return (x.R < y.R ? -1 : 1);
			}
		});

		// Initialize current L, current R and current sum
		int currL = 0, currR = 0;
		
		Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
		
		// Traverse through all queries
		for (int i=0; i<m; i++)
		{
			// L and R values of current range
			int L = q.get(i).L, R = q.get(i).R, X = q.get(i).x;

			// Remove extra elements of previous range. For
			// example if previous range is [0, 3] and current
			// range is [2, 5], then a[0] and a[1] are subtracted
			while (currL < L)
			{
				if(mp.containsKey(a[currL])){
			mp.put(a[currL],mp.get(a[currL])-1);
				}
				else{
			mp.put(a[currL],1);
				}
				
				//mp.put(a[currL], mp.get(a[currL] - 1));
				currL++;
			}

			// Add Elements of current Range
			while (currL > L)
			{
				if(mp.containsKey(a[currL-1])){
			mp.put(a[currL-1],mp.get(a[currL-1])+1);
				}
				else{
			mp.put(a[currL-1],1);
				}
				//mp.put(a[currL], mp.get(a[currL-1]+1));
				currL--;
			}
			while (currR <= R)
			{
				if(mp.containsKey(a[currR])){
			mp.put(a[currR],mp.get(a[currR])+1);
				}
				else{
			mp.put(a[currR],1);
				}
				//mp.put(a[currR], mp.get(a[currR]+1));
				currR++;
			}

			// Remove elements of previous range. For example
			// when previous range is [0, 10] and current range
			// is [3, 8], then a[9] and a[10] are subtracted
			while (currR > R+1)
			{
				if(mp.containsKey(a[currR-1])){
			mp.put(a[currR-1],mp.get(a[currR-1])-1);
				}
				else{
			mp.put(a[currR-1],1);
				
				//mp[a[currR-1]]--;
				currR--;
			}
			}
			
			if (mp.containsKey(X))
			System.out.println(X + " exists between [" + L +
						", " + R + "] ");
			else
			System.out.println(X + " does not exist between [" + L +
						", " + R + "] ");
				
			// Print sum of current range
			
			
		}
	}
	
	// Driver program
	public static void main(String argv[]){
		ArrayList<Query> q = new ArrayList<Query>();
		q.add(new Query(0,2,2));
		q.add(new Query(1,4,1));
		q.add(new Query(2,4,5));

		int a[] = {1, 1, 5, 4, 5 };
		queryResults(a, a.length, q, q.size());
	}
}
// This code is contributed by Aarti_Rathi
// Efficient Approach(Using Mo’s Algorithm) : 

// Mo’s algorithm is one of the finest applications for square root decomposition. 

// It is based on the basic idea of using the answer to the previous query to compute the answer for the current query. This is made possible because the Mo’s algorithm is constructed in such a way that if F([L, R]) is known, then F([L + 1, R]), F([L – 1, R]), F([L, R + 1]) and F([L, R – 1]) can be computed easily, each in O(F) time.
// Answering queries in the order they are asked, then the time complexity is not improved to what is needed to be. To reduce the time complexity considerably, the queries are divided into blocks and then sorted. 

// The exact algorithm to sort the queries is as follows : 

// Denote BLOCK_SIZE = sqrt(N)
// All the queries with the same L/BLOCK_SIZE are put in the same block
// Within a block, the queries are sorted based on their R values
// The sort function thus compares two queries, Q1 and Q2 as follows: 
// Q1 must come before Q2 if: 
// L1/BLOCK_SIZE<L2/BLOCK_SIZE 
// L1/BLOCK_SIZE=L2/BLOCK_SIZE and R1<R2
// After sorting the queries, the next step is to compute the answer to the first query and consequently answer rest of the queries. To determine if a particular element exists or not, check the frequency of the element in that range. A non zero frequency confirms the existence of the element in that range. 
// To store the frequency of the elements, STL map has been used in the following code. 

// In the example given, first query after sorting the array of queries is {0, 2, 2}. Hash the frequencies of the elements in [0, 2] and then check the frequency of the element 2 from the map. Since, 2 occurs 0 times, print “No”. 

// While processing the next query, which is {1, 4, 1} in this case, decrement the frequencies of the elements in the range [0, 1) and increment the frequencies of the elements in range [3, 4]. This step gives the frequencies of elements in [1, 4] and it can easily be seen from the map that 1 exists in this range.

// Time complexity : 

// The pre-processing part, that is sorting the queries takes O(m Log m) time. 
// The index variable for R changes at most O(n * \sqrt{n}) times throughout the run and that for L changes
//  its value at most O(m * \sqrt{n})times.
//   Hence, processing all queries takes O(n * \sqrt{n})+ O(m * \sqrt{n}) = O((m+n) * \sqrt{n})time.

// Space complexity:

// The space complexity of the given program is O((m+n) * sqrt(n)) where n is the size of the input array a[] and m is the number of queries. 

// Below is the C++ implementation of the above idea : 