import java.util.*;
import java.io.*;

// https://codeforces.com/contest/1772/problem/D

public class AbsoluteSortingwithX {
    public static Scanner obj = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {

        int len = obj.nextInt();
        while (len-- != 0) {

            int n = obj.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = obj.nextInt();

            int min = 0, max = (int) (1e9);

            for (int i = 1; i < n; i++) {

                int x = a[i - 1];
                int y = a[i];

                int left = (x + y) / 2;
                int right = (x + y + 1) / 2;

                if (x < y) {
                    max = Math.min(max, left);
                } 
                else if (x > y) {
                    min = Math.max(min, right);
                }
            }

            if (min <= max) out.println(min);
            else out.println(-1);
        }
        out.flush();
    }
}


/*
 * 
 * 
 * Here's a simplified explanation of the solution approach:

*  For each pair of adjacent elements (ai, ai+1), determine the range of values for x that would keep them in the correct order.
*  If ai = ai+1, any value of x works.
*  If ai < ai+1, the valid range for x is x ≤ ⌊(ai + ai+1) / 2⌋.
*  If ai > ai+1, the valid range for x is x ≥ ⌈(ai + ai+1) / 2⌉.
*  To find a common range that satisfies all pairs, take the minimum of the upper bounds and the maximum of the lower bounds.
*  If the resulting range is valid (minimum ≤ maximum), then there is a valid x that preserves the sorting order; otherwise, there is no answer.
*  The overall time complexity of this solution is O(n) per testcase, where n is the size of the array. This is because the algorithm iterates through each pair of adjacent elements in the array.
 */