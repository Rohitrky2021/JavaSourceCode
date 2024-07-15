 
import java.util.Scanner;

public class Lazy_ST {
    static int[] lazy = new int[1000];

    public static int query(int[] tree, int ss, int se, int qs, int qe, int index) {
        // Complete Overlap
        if (ss >= qs && se <= qe) {
            return tree[index];
        }

        // No Overlap
        if (qe < ss || qs > se) {
            return Integer.MAX_VALUE;
        }

        // Partial Overlap - Call both sides and update the current answer
        int mid = (ss + se) / 2;
        int leftAns = query(tree, ss, mid, qs, qe, 2 * index);
        int rightAns = query(tree, mid + 1, se, qs, qe, 2 * index + 1);
        return Math.min(leftAns, rightAns);
    }

    public static void buildTree(int[] a, int s, int e, int[] tree, int index) {
        if (s == e) {
            tree[index] = a[s];
            return;
        }

        // Rec case
        int mid = (s + e) / 2;
        buildTree(a, s, mid, tree, 2 * index);
        buildTree(a, mid + 1, e, tree, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    public static void updateNode(int[] tree, int ss, int se, int i, int increment, int index) {
        // Leaf updateNode
        // Out of bounds - No Overlap
        if (i > se || i < ss) {
            return;
        }

        // Leaf Node
        if (ss == se) {
            tree[index] += increment;
            return;
        }

        // Left and Right - Call
        int mid = (ss + se) / 2;
        updateNode(tree, ss, mid, i, increment, 2 * index);
        updateNode(tree, mid + 1, se, i, increment, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    public static int queryLazy(int[] tree, int ss, int se, int qs, int qe, int index) {  // Here ITs for Range Min problem
        // First step - resolve the Lazy value
        if (lazy[index] != 0) {
            tree[index] += lazy[index];
            if (ss != se) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index] += lazy[index];
            }
            lazy[index] = 0;
        }

        // No Overlap
        if (ss > qe || se < qs) {
            return Integer.MAX_VALUE;
        }

        // Complete Overlap
        if (ss >= qs && se <= qe) {
            return tree[index];
        }

        // Partial
        int mid = (ss + se) / 2;
        int left = queryLazy(tree, ss, mid, qs, qe, 2 * index);
        int right = queryLazy(tree, mid + 1, se, qs, qe, 2 * index + 1);

        return Math.min(left, right);
    }

    public static void updateRangeLazy(int[] tree, int ss, int se, int l, int r, int inc, int index) {
        // First Step - Never we go down if you have lazy value at node, first resolve it
        if (lazy[index] != 0) {    //ab depth ki value use krni h tho final modification depth m jaana shuru kro
            tree[index] += lazy[index];

            // if not a leaf node   // Lazy value ko ab depth m daal do wha need h
            if (ss != se) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0; //Clear the lazy value at current Node
        }

        // BAse Case 
        // Out of Bounds
        if (ss > r || l > se) {
            return;
        }

        // {{Complete Overlap}}- Beeche Raste Mei hi Return krna
        if (ss >= l && se <= r) {
            tree[index] += inc;

            // Pass the lazy value to children  ---> i.e Create a new Lazy value for Children
            if (ss != se) { 
                lazy[2 * index] += inc;
                lazy[2 * index + 1] += inc;
            }
            return;  // Just giving new Lazy  value now we will return back 
        }

        // Call on Left and Right  -->> {{ PArtial Overlap }}
        int mid = (ss + se) / 2;
        updateRangeLazy(tree, ss, mid, l, r, inc, 2 * index);
        updateRangeLazy(tree, mid + 1, se, l, r, inc, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    public static void updateRange(int[] tree, int ss, int se, int l, int r, int inc, int index) {
        // Out of bounds
        if (l > se || r < ss) {
            return;
        }

        // Leaf Node
        if (ss == se) {
            tree[index] += inc;
            return;
        }

        // Left and Right Call Otherwise
        int mid = (ss + se) / 2;

        updateRange(tree, ss, mid, l, r, inc, 2 * index);
        updateRange(tree, mid + 1, se, l, r, inc, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = {1, 3, 2, -5, 6, 4};
        int n = a.length;

        int[] tree = new int[4 * n + 1];

        buildTree(a, 0, n - 1, tree, 1);

        // Let's print the tree
        for (int i = 1; i <= 13; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // updateNode(tree, 0, n - 1, 2, 10, 1);
        updateNode(tree, 0, n - 1, 3, 15, 1);
        updateRangeLazy(tree, 0, n - 1, 2, 3, 10, 1);

        int no_of_q = 2;

        while (no_of_q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(queryLazy(tree, 0, n - 1, l, r, 1));
        }
    }
}
