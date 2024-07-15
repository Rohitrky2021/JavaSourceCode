 
import java.util.BitSet;
import java.util.Scanner;

public class BitSet_LT_ST {
    static BitSet[] tree = new BitSet[800003];
    static BitSet[] lazy = new BitSet[800003];

    public static long CalculateMex(BitSet set) {
        long Mex = 0;
        while (set.get((int) Mex)) {
            Mex++;
        }
        return Mex;
    }

    public static void buildTree(long s, long e, long index) {
        if (s == e) {
            tree[(int) index] = new BitSet(200000);
            return;
        }

        // Rec case
        long mid = (s + e) / 2;
        buildTree(s, mid, 2 * index);
        buildTree(mid + 1, e, 2 * index + 1);
        tree[(int) index] = new BitSet(200000);
    }

    public static void updateRangeLazy(long ss, long se, long l, long r, long clr, long index) {
        // First Step - Never we go down if you have lazy value at node, first resolve it

        if (lazy[(int) index] != null && lazy[(int) index].cardinality() > 0) {
            tree[(int) index] = (BitSet) lazy[(int) index].clone();

            // if not a leaf node
            if (ss != se) {
                lazy[2 * (int) index] = (BitSet) lazy[(int) index].clone();
                lazy[2 * (int) index + 1] = (BitSet) lazy[(int) index].clone();
            }
            lazy[(int) index].clear();
        }

        // Out of Bounds
        if (ss > r || l > se) {
            return;
        }
        // Complete Overlap- Beeche Raste Mei hi Return krna
        if (ss >= l && se <= r) {
            tree[(int) index].clear();
            tree[(int) index].set((int) (clr - 1));

            // Pass the lazy value to children
            if (ss != se) {
                lazy[2 * (int) index].clear();
                lazy[2 * (int) index].set((int) (clr - 1));
                lazy[2 * (int) index + 1].clear();
                lazy[2 * (int) index + 1].set((int) (clr - 1));
            }
            return;
        }

        // Call on Left and Right
        long mid = (ss + se) / 2;
        updateRangeLazy(ss, mid, l, r, clr, 2 * index);
        updateRangeLazy(mid + 1, se, l, r, clr, 2 * index + 1);
        tree[(int) index].or(tree[2 * (int) index]);
        tree[(int) index].or(tree[2 * (int) index + 1]);

        return;
    }

    public static BitSet queryLazy(long ss, long se, long qs, long qe, long index) {
        // First step - resolve the Lazy value
        if (lazy[(int) index] != null && lazy[(int) index].cardinality() > 0) {
            tree[(int) index] = (BitSet) lazy[(int) index].clone();

            // if not a leaf node
            if (ss != se) {
                lazy[2 * (int) index] = (BitSet) lazy[(int) index].clone();
                lazy[2 * (int) index + 1] = (BitSet) lazy[(int) index].clone();
            }
            lazy[(int) index].clear();
        }

        // No Overlap
        if (ss > qe || se < qs) {
            return new BitSet(200000);
        }

        // Complete Overlap
        if (ss >= qs && se <= qe) {

            return tree[(int) index];
        }

        // Partial
        long mid = (ss + se) / 2;
        BitSet left = queryLazy(ss, mid, qs, qe, 2 * index);
        BitSet right = queryLazy(mid + 1, se, qs, qe, 2 * index + 1);

        left.or(right);

        return left;

    }

    public static void solve() {

        Scanner scanner = new Scanner(System.in);

        long n, q;
        n = scanner.nextLong();
        q = scanner.nextLong();

        buildTree(0, n - 1, 1);
        for (int i = 0; i < 800003; i++) {
            lazy[i] = new BitSet(200000);
        }

        for (int i = 0; i < q; i++) {
            long s = scanner.nextLong();
            if (s == 0) {
                long l, r;
                l = scanner.nextLong();
                r = scanner.nextLong();

                updateRangeLazy(0, n - 1, l, r, 0, 1);
            } else if (s == 1) {
                long l, r;
                l = scanner.nextLong();
                r = scanner.nextLong();

                updateRangeLazy(0, n - 1, l, r, 1, 1);
            } else {
                long l, r;
                l = scanner.nextLong();
                r = scanner.nextLong();

                BitSet ans = queryLazy(0, n - 1, l, r, 1);
                int tans = 0;
                for (long j = l; j < r + 1; j++) {
                    tans += ans.get((int) j) ? 1 : 0;
                }
                System.out.println(tans);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }
}
