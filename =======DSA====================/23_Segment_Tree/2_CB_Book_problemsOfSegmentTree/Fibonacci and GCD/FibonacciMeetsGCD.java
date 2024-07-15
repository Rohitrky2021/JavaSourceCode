 
import java.util.*;

public class FibonacciMeetsGCD {


    /*
     * Problem Name: Fibonacci meets GCD
*     Problem Difficulty: None
*     Problem Constraints: 1 <= N, Q <= 10^5 <br>
*     1 <= A[i] <= 10^9 <br>
*     1 <= L , R <= N
*     Problem Description:
*     Let Fib(x) denote the value of fibonacci of x. For example F(1) =1 , F(2) = 1,  F(3) = 2 and so on for all x. <br>
*     Let GCD(a,b) denote the greatest common divisor of two numbers a and b.<br>
*     You are given an array **A** of **N** integers.<br>
*     You will be given **Q** queries of the form **L R**.<br>
*     For each query you have to find out the value of ***GCD ( F(A[L] , FA[L+1]..... FA[R] ) % mod***. <br>
*     mod = 10^9+7.
*     
*     Input Format: First line : Two integers N and Q.
*     Second line : N space separated integers denoting array A.
*     Next Q lines : Two space separated integers L and R.
*     Sample Input: 
*     3 2
*     2 4 8
*     1 3
*     2 3
*     Output Format: Output the result of each query in a separate line.
*     Sample Output: 
*     1
*     3
     */

    static Map<Long, Long> mymap;
    static long[] arr;
    static long[] tree;
    static int n, q;

    static long f(long num) {
        if (mymap.containsKey(num)) {
            return mymap.get(num);
        }

        long k = num / 2;
        if (num % 2 == 1) {
            mymap.put(num, (f(k) * f(k + 1) + f(k - 1) * f(k)) % mod);
        } else {
            mymap.put(num, (f(k) * f(k) + f(k - 1) * f(k - 1)) % mod);
        }

        return mymap.get(num);
    }

    static void buildSegmentTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildSegmentTree(2 * node, start, mid);
        buildSegmentTree(2 * node + 1, mid + 1, end);

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    static long querySegmentTree(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        long leftGCD = querySegmentTree(2 * node, start, mid, left, right);
        long rightGCD = querySegmentTree(2 * node + 1, mid + 1, end, left, right);

        return gcd(leftGCD, rightGCD);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mymap = new HashMap<>();
        mymap.put(0L, 1L);
        mymap.put(1L, 1L);

        n = scanner.nextInt();
        q = scanner.nextInt();

        arr = new long[n];
        tree = new long[4 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        // Build the Segment Tree
        buildSegmentTree(1, 0, n - 1);

        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            l--;
            r--;

            long ans = querySegmentTree(1, 0, n - 1, l, r);
            ans = f(ans - 1);
            System.out.println(ans);
        }
    }

    static final long mod = 1000000007;
}
