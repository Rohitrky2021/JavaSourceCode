public class RangeSuminLAZY_propaga {

    // =========> IN segemnt Tree
    // The above approach will query the tree in O(lg(n)) time. But the problem will arise in the update
    // function. As updating a single element takes O(lg(n)) time, now we are doing a range update. So, the
    // overall complexity for update will be O(nlg(n)), which will get TLE as we have to answer for multiple
    // queries.

// ===========> Here In lazy Segment Tree <=============
    // Using Lazy Propagation the range update will be done in O(lg(n))time complexity.

    public static void main(String[] args) {
        int MAX = 1000; // Adjust the size accordingly
        LazySegmentTree st = new LazySegmentTree(MAX);

        // Usage example:
        st.update_tree(1, 0, MAX - 1, 2, 5, 5); // Update the range [2, 5] by adding 5 to each element
        int result = st.query_tree(1, 0, MAX - 1, 1, 6); // Query the sum in the range [1, 6]
        System.out.println("Result: " + result);
    }
}

class LazySegmentTree {
    int MAX;
    int[] tree, lazy;

    LazySegmentTree(int max) {
        MAX = max;
        tree = new int[4 * MAX];
        lazy = new int[4 * MAX];
    }

    // Lazy Propagation - Update function
    void update_tree(int node, int a, int b, int i, int j, int val) {
        if (lazy[node] != 0) {
            tree[node] += (b - a + 1) * lazy[node];
            if (a != b) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (a > b || a > j || b < i)
            return;
        if (a >= i && b <= j) {
            tree[node] += (b - a + 1) * val;
            if (a != b) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return;
        }
        int mid = (a + b) >> 1;
        update_tree(node * 2, a, mid, i, j, val);
        update_tree(node * 2 + 1, mid + 1, b, i, j, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // Lazy Propagation - Query function
    int query_tree(int node, int a, int b, int i, int j) {
        if (a > b || a > j || b < i)
            return 0;
        if (lazy[node] != 0) {
            tree[node] += (b - a + 1) * lazy[node];
            if (a != b) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (a >= i && b <= j)  // In final no need of incre use as arleady used and updated above 
            return tree[node];


        int mid = (a + b) >> 1;
        int q1 = query_tree(node * 2, a, mid, i, j);
        int q2 = query_tree(node * 2 + 1, mid + 1, b, i, j);
        return q1 + q2;
    }
}
