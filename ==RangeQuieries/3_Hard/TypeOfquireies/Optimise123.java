
// Java program to perform range queries
// over range queries.
// The Time complexity of the above code is O(2 ^ m)
// https://www.geeksforgeeks.org/array-range-queries-range-queries/
// The space complexity of this program is O(m),
import java.util.Arrays;

public class Optimise123 {

    // Function to create the record array
    static void record_sum(int record[], int l,
            int r, int n, int adder) {
        for (int i = l; i <= r; i++) {
            record[i] += adder;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 5, m = 5;
        int arr[] = new int[n];

        // Build query matrix
        Arrays.fill(arr, 0);
        int query[][] = { { 1, 1, 2 }, { 1, 4, 5 },
                { 2, 1, 2 }, { 2, 1, 3 },
                { 2, 3, 4 } };
        int record[] = new int[m];
        Arrays.fill(record, 0);

        for (int i = m - 1; i >= 0; i--) {

            // If query is of type 2 then function
            // call to record_sum
            if (query[i][0] == 2) {
                record_sum(record, query[i][1] - 1,
                        query[i][2] - 1, m,
                        record[i] + 1);
            }

            // If query is of type 1 then
            // simply add 1 to the record array
            else {
                record_sum(record, i, i, m, 1);
            }

        }

        // for type 1 queries adding the contains of
        // record array to the main array record array
        for (int i = 0; i < m; i++) {
            if (query[i][0] == 1) {
                record_sum(arr, query[i][1] - 1,
                        query[i][2] - 1,
                        n, record[i]);
            }
        }

        // printing the array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// This code is contributed
// by Princi Singh
// Method 2:
// In this method we use an extra array for creating the record array to find
// the number of time
// a particular query is being executed and after creating the record array we
// simply execute the queries of
// type 1 and the contains of the record array is simply added to the main array
// the and this would give us
// the resultant array.

// Given an array of size n and a give set of commands of size m. The commands are enumerated from 1 to m. These commands can be of the following two types of commands: 

// Type 1 [l r (1 <= l <= r <= n)] : Increase all elements of the array by one, whose indices belongs to the range [l, r]. In these queries of the index is inclusive in the range.
// Type 2 [l r (1 <= l <= r <= m)] : Execute all the commands whose indices are in the range [l, r]. In these queries of the index is inclusive in the range. It’s guaranteed that r is strictly less than the enumeration/number of the current command.
// Note : The array indexing is from 1 as per the problem statement.

// Example 1 

// Input : 5 5
//         1 1 2
//         1 4 5
//         2 1 2
//         2 1 3
//         2 3 4
// Output : 7 7 0 7 7
// Explanation of Example 1 : 

// Our array initially is of size 5 whose each element has been initialized to 0. 
// So now the question states that we have 5 queries for the above example. 

// Query 1 is of type 1 : As stated above we will simply increment the array indices by 1 the given indices are 1 and 2 so after the execution of the first our array turns down to be 1 1 0 0 0 .
// Query 2 is of type 1 : As stated above we will simply increment the array indices by 1 
// the given indices are 4 and 5 so after the execution of the first our array turns down to be 1 1 0 1 1 .
// Query 3 is of type 2 : As stated in the definition of this type of query we will execute the queries stated in the range i.e. we will operate the queries instead of the array. The range given is 1 and 2 so we will execute queries 1 and 2 again i.e. we will use repetitive approach for the type 2 queries so we will execute query 1 again and our array will be 2 2 0 1 1. Now when we execute the query we will execute query 2 and our resultant array will be 2 2 0 2 2 .
// Query 4 is of type 2 : As stated in the definition of this type of query we will execute the queries stated in the range i.e. we will operate the queries instead of the array. The range given is 1 and 3 so we will execute queries 1, 2 and 3 again i.e. using repetitive approach queries 1, 2 and 3 will be executed. After the execution of the query 1 again the array will be 3 3 0 2 2 . After the execution of the query 2 again the array will be 3 3 0 3 3 . Now due to query 3 inclusive in the range we will execute query 3 the resultant array will be 4 4 0 4 4 . As explained above.
// Query 5 is of type 2 : The last query will execute the 3rd and 4th query which has been explained above. After the execution of the 3rd query our array will be 5 5 0 5 5 . And after the execution of the 4th query i.e. execution of query 1, 2 and 3 our array will be 7 7 0 7 7 The above is the desired result
// Example 2 

// Input : 1 2
//         1 1 1
//         1 1 1
// Output : 2
// Explanation of the example 2: 

// Our array initially is of size 1 whose each element has been initialized to 0. 
// So now the question states that we have 2 queries for the above example.  

// Query 1 is of type 1 : As stated above we will simply increment the array indices by 1 the given indices are 1 and 1 so after the execution of the first our array turns down to be 1 .
// Query 2 is of type 1 : As stated above we will simply increment the array indices by 1 the given indices are 1 and 1 so after the execution of the first our array turns down to be 2 . This gives us the desired result
// Method 1: This method is the brute force method where by simple recursion is applied on the type 2 queries and for type 1 queries simple increment in the array index is performed. 