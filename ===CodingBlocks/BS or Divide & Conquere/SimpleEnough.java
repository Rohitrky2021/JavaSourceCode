 
import java.util.Scanner;

public class SimpleEnough {
    static long query(long l1, long r1, long l2, long r2, long nownumber) {
        if (l1 == r1) {
            return nownumber;
        }

        long mid = (l1 + r1) / 2;
        long a = 0, b = 0, c = 0;

        if (l2 < mid) {
            a = query(l1, mid - 1, l2, r2, nownumber >> 1);
        }

        if (r2 > mid) {
            b = query(mid + 1, r1, l2, r2, nownumber >> 1);
        }

        if (l2 <= mid && r2 >= mid) {
            c = nownumber % 2;
        }

        return a + b + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long l = scanner.nextLong();
        long r = scanner.nextLong();

        long len = 1;
        long now = n;
        long add = 2;

        while (now > 1) {
            now >>= 1;
            len += add;
            add <<= 1;
        }

        System.out.println(query(1, len, l, r, n));
    }
}


// Problem Name: Simple Enough
// Problem Difficulty: None
// Problem Constraints: 0 ≤ n < 10^12,
// 0 ≤ r - l ≤ 10^6, 
// 1 ≤ l ≤ r 
// Problem Description:
// For a given number n, form a list and insert the following pattern into the list at the same position sequentially.
//  <br />
// {floor(n/2) , n%2 , floor(n/2) }
//  <br />
// Until every element in the list is either 1 or 0.
// Now, calculate number of 1s in from l to r (1-indexed).
// <BR /> <BR />
// <b> EXPLAINATION: </b> Start from n. Then make a list with the following elements.i.e. {floor(n/2) , n%2 , floor(n/2) }. Now this list has three elements. Now further break down each of those 3 elements considering the new n to be floor(n/2) , n%2 and  floor(n/2) respectively for those three elements respectively <b>INPLACE</b>. And this process will go on until the n reduces down to 1 or 0. So it will basically form a tree with 3 branches coming out of every node at every level starting from 1 node (n) at the root.
// <br/> 




// Input Format: Three integers n , l , r
// Sample Input: 9 6 9
// Output Format: Single line containing number of 1s in the given range.
// Sample Output: 3
