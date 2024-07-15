/*
 * Problem Name: MAXIMUM SUM QUERY
*    Problem Difficulty: 
*    Problem Constraints: 1<=N,Q<=10^5
*    |Ai|<=10^9
*    Problem Description:
*    You are given an array *A* and *Q* queries. Each query consists of 2 integers *l* and *r*. 
*   The answer to each query will be max(*A<sub>i</sub> + A<sub>i+1</sub> +....+ A<sub>j</sub>*,*l*<=*i*<=*j*<=*r*).
*    
*    Input Format: First line contains an integer N, denoting the number of elements in the array A.
*     Next line contains N integers denoting the elements of the array. Next line contains a single integer Q,
*     denoting the number of queries. Next Q lines contain Q queries, consisting of 2 integers each, L and R.
*    Sample Input: 
*    3 
*    -1 2 3
*    2
*    1 3
*    2 3
*    
*    Output Format: Print the answer to each query.
*    Sample Output: 5
*    5

=====Solution=====>>
 * 
 */
 
import java.util.Scanner;

public class MaximumSubarraySum {

    static final long INT_MIN = -10000000000L;
    static long[] m;
    static long[] tree, ltree, rtree, mtree;

    static long max(long a, long b) {
        return (a > b) ? a : b;
    }

    static void build(int node, int st, int en) {
        if (st > en) {
            return;
        }
        if (st == en) { // leaf node
            tree[node] = m[st];
            ltree[node] = m[st];
            rtree[node] = m[st];
            mtree[node] = m[st];
            return;
        }
        int mid = (st + en) / 2;
        build(2 * node + 1, st, mid);
        build(2 * node + 2, mid + 1, en);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        ltree[node] = max(ltree[2 * node + 1], max(tree[2 * node + 1], max(tree[2 * node + 1] + ltree[2 * node + 2], tree[node])));
        rtree[node] = max(rtree[2 * node + 2], max(tree[2 * node + 2], max(tree[2 * node + 2] + rtree[2 * node + 1], tree[node])));
        mtree[node] = max(mtree[2 * node + 1], max(mtree[2 * node + 2], max(tree[node], max(ltree[node], max(rtree[node], rtree[2 * node + 1] + ltree[2 * node + 2])))));
    }

    static class QueryResult {
        long total, left, right, middle;

        QueryResult(long total, long left, long right, long middle) {
            this.total = total;
            this.left = left;
            this.right = right;
            this.middle = middle;
        }
    }

    static QueryResult query(int node, int st, int en, int l, int r) {
        if (st > en) {
            return new QueryResult(INT_MIN, INT_MIN, INT_MIN, INT_MIN);
        }
        if (st > r || en < l) { // out of range
            return new QueryResult(INT_MIN, INT_MIN, INT_MIN, INT_MIN);
        }
        if (st >= l && en <= r) { // totally in range
            return new QueryResult(tree[node], ltree[node], rtree[node], mtree[node]);
        }
        int mid = (st + en) / 2;
        QueryResult p1 = query(2 * node + 1, st, mid, l, r);
        QueryResult p2 = query(2 * node + 2, mid + 1, en, l, r);

        long total = p1.total + p2.total;
        long left = max(p1.left, max(p1.total, max(p1.total + p2.left, total)));
        long right = max(p2.right, max(p2.total, max(p2.total + p1.right, total)));
        long middle = max(total, max(left, max(right, max(p1.middle, max(p2.middle, p1.right + p2.left))))));

        return new QueryResult(total, left, right, middle);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        m = new long[n];
        tree = new long[4 * n + 2];
        ltree = new long[4 * n + 2];
        rtree = new long[4 * n + 2];
        mtree = new long[4 * n + 2];

        for (int i = 0; i <= 4 * n; i++) {
            tree[i] = INT_MIN;
            ltree[i] = INT_MIN;
            rtree[i] = INT_MIN;
            mtree[i] = INT_MIN;
        }

        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextLong();
        }

        build(0, 0, n - 1);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            QueryResult tmp = query(0, 0, n - 1, x - 1, y - 1);
            long ans = max(tmp.total, max(tmp.left, max(tmp.right, tmp.middle)));
            System.out.println(ans);
        }
    }
}
