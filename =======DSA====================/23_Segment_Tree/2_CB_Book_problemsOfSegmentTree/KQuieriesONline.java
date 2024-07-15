
    // OffLine Quieres Means Type of Lazy ST End m Jaake sub ka ans nikalna
    // But in Online one Update krna he pdega======> Always need the Ans to perform the Next Quieries 

/*
 * 
 * Problem Name: KQUERYO
*       Problem Difficulty: 2
*       Problem Constraints: 
*       Problem Description:
*       Given a sequence of **N** numbers a<sub>1</sub>, ..., a<sub>n</sub> and a number of ***K- queries***.<br> A k-query is a **triple (i, j, k)** (1 ≤ i, j ≤ n). For each k-query (i, j, k), you have to return the number of elements ***greater than k*** in the subarray a<sub>i</sub>, a<sub>i+1</sub>, ..., a<sub>j</sub>.<br>
*       The original problem can be found <a href="http://www.spoj.com/problems/KQUERYO/">here</a>
*       
*       Input Format: Line 1: n (1 ≤ n ≤ 30000).
*       
*       Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤ 10^9).
*       
*       Line 3: q (1 ≤ q ≤ 200000), the number of k- queries.
*       
*       In the next q lines, each line contains 3 numbers a, b, c representing a k-query (1 ≤ a, b , c ≤ 10^9.
*       
*       You should do the following:
*       
*       i = a xor last_ans
*       
*       j = b xor last_ans
*       
*       k = c xor last_ans
*       
*       Where last_ans = the answer to the last query (for the first query it's 0).
*       
*       if i > j answer is 0.
*       
*       if i < 1 take i =1.
*       
*       if j > n take j = n.
*       Sample Input: 6
*       8 9 3 5 1 9
*       5
*       2 3 5
*       3 3 7
*       0 0 11
*       0 0 2
*       3 7 4
*       Output Format: For each k-query (i, j, k), print the number of elements greater than k in the subarray ai, ai+1, ..., aj in a single line.
*       Sample Output: 1
*       1
*       0
*       0
*       2
 * 
 * 
 * 
 */

 
import java.util.*;
import java.io.*;

public class KQuieriesONline {
    static List<Long>[] tree;
    static int n, q;
    static long[] arr;

    public static void build(long lo, long hi, int id) {
        if (lo > hi) {
            return;
        }
        if (lo == hi) { // leaf node
            tree[id].add(arr[(int) lo]);
            return;
        }
        long mid = (lo + hi) / 2;
        build(lo, mid, 2 * id); // left
        build(mid + 1, hi, 2 * id + 1); // right
        tree[id].addAll(merge(tree[2 * id], tree[2 * id + 1])); // sorted merge
    }

    public static List<Long> merge(List<Long> list1, List<Long> list2) {
        List<Long> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }

    public static long query(long lo, long hi, long l, long r, int id, long k) {
        if (lo > hi) {
            return 0;
        }
        if (hi < l || lo > r) { // out of range
            return 0;
        }
        if (lo >= l && hi <= r) { // completely in range
            int ans = upperBound(tree[id], k);
            return tree[id].size() - ans; // greater than k
        }
        long mid = (lo + hi) / 2;
        return query(lo, mid, l, r, 2 * id, k) + query(mid + 1, hi, l, r, 2 * id + 1, k); // sum up answers
    }

    public static int upperBound(List<Long> list, long target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("i1.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("o1.txt"));

        n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];
        tree = new ArrayList[4 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        build(1, n, 1); // build tree

        q = Integer.parseInt(br.readLine());
        long lastAns = 0;

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long l = lastAns ^ a;
            long r = lastAns ^ b;
            long k = lastAns ^ c;

            if (l < 1) {
                l = 1;
            }
            if (r > n) {
                r = n;
            }
            if (l > r) {
                lastAns = 0;
            } else {
                lastAns = query(1, n, l, r, 1, k); // execute online queries
            }
            pw.println(lastAns);
        }

        br.close();
        pw.close();
    }
}
