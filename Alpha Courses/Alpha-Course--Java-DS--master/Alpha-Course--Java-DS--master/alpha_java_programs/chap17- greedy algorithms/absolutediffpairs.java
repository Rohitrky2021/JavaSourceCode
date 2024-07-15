// WAP to implement minimum sum of absolute different pairs using greedy algorithms

// time complexity is O(nlogn)
import java.util.*;
public class absolutediffpairs {
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i=0; i<A.length; i++)
        {
            // abs means absolute value
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("minimum absolute difference of pairs = " + minDiff);
    }
}
