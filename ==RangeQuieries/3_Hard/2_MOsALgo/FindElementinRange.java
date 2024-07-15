
// Java program to determine if the element
// exists for different range queries
import java.util.*;

public class FindElementinRange {
    // time complexity for each query would be O(N)
    // time complexity would turn out to be O(Q*N).

    // Structure to represent a query range
    static class Query {
        int L, R, X;

        public Query(int L, int R, int X) {
            this.L = L;
            this.R = R;
            this.X = X;
        }
    };

    static int maxn = 100;

    static int[] root = new int[maxn];

    // Find the root of the group containing
    // the element at index x
    static int find(int x) {
        if (x == root[x])
            return x;
        else
            return root[x] = find(root[x]);
    }

    // merge the two groups containing elements
    // at indices x and y into one group
    static void uni(int x, int y) {
        int p = find(x), q = find(y);
        if (p != q) {
            root[p] = root[q];
        }
    }

    static void initialize(int a[], int n,
            Query q[], int m) {
        // make n subsets with every
        // element as its root
        for (int i = 0; i < n; i++)
            root[i] = i;

        // consecutive elements equal in value are
        // merged into one single group
        for (int i = 1; i < n; i++)
            if (a[i] == a[i - 1])
                uni(i, i - 1);
    }

    // Driver code
    public static void main(String args[]) {
        int a[] = { 1, 1, 5, 4, 5 };
        int n = a.length;
        Query q[] = { new Query(0, 2, 2),
                new Query(1, 4, 1),
                new Query(2, 4, 5) };
        int m = q.length;
        initialize(a, n, q, m);

        for (int i = 0; i < m; i++) {
            int flag = 0;
            int l = q[i].L, r = q[i].R, x = q[i].X;
            int p = r;

            while (p >= l) {

                // check if the current element in
                // consideration is equal to x or not
                // if it is equal, then x exists in the range
                if (a[p] == x) {
                    flag = 1;
                    break;
                }
                p = find(p) - 1;
            }

            // Print if x exists or not
            if (flag != 0)
                System.out.println(x + " exists between [" +
                        l + ", " + r + "] ");
            else
                System.out.println(x + " does not exist between [" +
                        l + ", " + r + "] ");
        }
    }
}

// This code is contributed by 29AjayKumar
// Given an array of N elements and Q queries of the form L R X. For each query, you have to output if the 
// element X exists in the array between the indices L and R(included).

// Prerequisite : Mo’s Algorithms 

// Examples :  

// Input : N = 5
//         arr = [1, 1, 5, 4, 5]
//         Q = 3
//         1 3 2
//         2 5 1
//         3 5 5         
// Output : No
//          Yes
//          Yes
// Explanation :
// For the first query, 2 does not exist between the indices 1 and 3.
// For the second query, 1 exists between the indices 2 and 5.
// For the third query, 5 exists between the indices 3 and 5.
// Naive Approach : 
// The naive method would be to traverse the elements from L to R for each query, linearly searching for X.
//  In the worst case, there can be N elements from L to R, hence the worst case time complexity for each query would be O(N). 
//  Therefore, for all the Q queries, the time complexity would turn out to be O(Q*N).

// Using Union-Find Method : 
// This method checks only one element among all the consecutive equal values. If X is not equal to these values, then the algorithm skips all the other the other equal elements and continues traversal with the next different element. This algorithm is evidently useful only when there are consecutive equal elements in large amounts.

// Algorithm :  

// Merge all the consecutive equal elements in one group. 
// While processing a query, start from R. Let index = R. 
// Compare a[index] with X. If they are equal, then print “Yes” and break out of traversing the rest of the range. Else, skip all the consecutive elements belonging to the group of a[index]. Index becomes equal to one less than the index of the root of this group. 
// Continue the above step either till X is found or till index becomes less than L. 
// If index becomes less than L, print “No”. 