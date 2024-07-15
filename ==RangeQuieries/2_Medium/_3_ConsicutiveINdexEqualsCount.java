// i.e i where  Ai==Ai+1.
//     Input : A = [1, 2, 2, 2, 3, 3, 4, 4, 4] 
//         Q = 2 
//         L = 1 R = 8 
//         L = 0 R = 4 
// Output : 5 
//          2
// M1 -->CALCULATE FOR IN EACH RANGE --->Time Complexity : O(R – L) for every query 
//                                       Auxiliary Space: O(1)
// ===================================================================================================
// M2-to precompute a prefix array prefixans such that prefixans[i] stores the total count
//  of the index from 0 to i that obeys the given condition.
//  We can answer queries in O(1) time
//  Time complexity: O(n)--> OVERALL FOR ALL QUIERES .........
//  Auxiliary Space: O(n)
//  prefixans[R-1]-prefix[L-1] returns the total count 
// Java program to count
// the number of indexes
// in range L R such that
// Ai=Ai+1

// class GFG {
    public class ConsicutiveINdexEqualsCount {
	
    public static int N = 1000;
    
    // Array to store count
    // of index from 0 to
    // i that obey condition
    static int prefixans[] = new int[1000];
    
    // precomputing prefixans[] array
    public static void countIndex(int a[], int n)
    {
        
        // traverse to compute
        // the prefixans[] array
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && a[i] == a[i + 1])
                prefixans[i] = 1;
    
            if (i != 0)
                prefixans[i] += prefixans[i - 1];
        }
    }
    
    // function that answers
    // every query in O(1)
    public static int answer_query(int l, int r)
    {
        if (l == 0)
            return prefixans[r - 1];
        else
            return prefixans[r - 1] -
                prefixans[l - 1];
    }
    
    // Driver Code
    public static void main(String args[])
    {
        int a[] = {1, 2, 2, 2, 3, 3, 4, 4, 4};
        int n = 9;
    
        // pre-computation
        countIndex(a, n);
    
        int L, R;
    
        // 1-st query
        L = 1;
        R = 8;
    
        System.out.println(answer_query(L, R));
    
        // 2nd query
        L = 0;
        R = 4;
        System.out.println(answer_query(L, R));
    }
    }
    
    // This code is contributed by Jaideep Pyne
    

// BRUTE FORCE 
// Java program to count the number of
// indexes in range L R such that
// Ai = Ai+1
// class GFG {
	
// 	// function that answers every query
// 	// in O(r-l)
// 	static int answer_query(int a[], int n,
// 							int l, int r)
// 	{
		
// 		// traverse from l to r and count
// 		// the required indexes
// 		int count = 0;
// 		for (int i = l; i < r; i++)
// 			if (a[i] == a[i + 1])
// 				count += 1;

// 		return count;
// 	}

// 	// Driver Code
// 	public static void main(String[] args)
// 	{
// 		int a[] = {1, 2, 2, 2, 3, 3, 4, 4, 4};
// 		int n = a.length;

// 		// 1-st query
// 		int L, R;
// 		L = 1;
// 		R = 8;

// 		System.out.println(
// 				answer_query(a, n, L, R));

// 		// 2nd query
// 		L = 0;
// 		R = 4;
// 		System.out.println(
// 				answer_query(a, n, L, R));
// 	}
// }

// This code is contributed by
// Smitha Dinesh Semwal
