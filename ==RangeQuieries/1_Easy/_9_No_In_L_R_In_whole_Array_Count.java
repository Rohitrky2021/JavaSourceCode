// https://www.geeksforgeeks.org/queries-counts-array-elements-values-given-range/

public class _8_No_In_L_R_In_whole_Array_Count {
    
}

// Simple java program to count
// number of elements with
// values in given range.
 

class GFG {
    // function to count elements within given range
    static int countInRange(int arr[], int n, int x, int y) {
        // initialize result
        int count = 0;
        for (int i = 0; i < n; i++) {

            // check if element is in range
            if (arr[i] >= x && arr[i] <= y)
                count++;
        }
        return count;
    }

    // driver function
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 9, 10, 3 };
        int n = arr.length;

        // Answer queries
        int i = 1, j = 4;
        System.out.println(countInRange(arr, n, i, j));

        i = 9;
        j = 12;
        System.out.println(countInRange(arr, n, i, j));

    }
}

 
class SegmentTree {
    private List<Integer> tree;
    private int low, high;

    SegmentTree(int n)
    {
        tree = new ArrayList<>(4 * n);
        for (int i = 0; i < 4 * n; i++) {
            tree.add(0);
        }
    }

    // build the tree with array elements
    void build(int[] arr, int v, int tl, int tr)
    {
        if (tl == tr) {
            tree.set(v, (arr[tl] >= low && arr[tl] <= high)
                            ? 1
                            : 0);
        }
        else {
            int tm = (tl + tr) / 2;
            build(arr, v * 2, tl, tm);
            build(arr, v * 2 + 1, tm + 1, tr);
            tree.set(v,
                    tree.get(v * 2) + tree.get(v * 2 + 1));
        }
    }

    // query the tree for given range
    int query(int v, int tl, int tr, int l, int r)
    {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return tree.get(v);
        }
        int tm = (tl + tr) / 2;
        return query(v * 2, tl, tm, l, Math.min(r, tm))
            + query(v * 2 + 1, tm + 1, tr,
                    Math.max(l, tm + 1), r);
    }

    // update tree at index i with given value
    void update(int v, int tl, int tr, int i, int val)
    {
        if (tl == tr) {
            tree.set(v,
                    (val >= low && val <= high) ? 1 : 0);
        }
        else {
            int tm = (tl + tr) / 2;
            if (i <= tm) {
                update(v * 2, tl, tm, i, val);
            }
            else {
                update(v * 2 + 1, tm + 1, tr, i, val);
            }
            tree.set(v,
                    tree.get(v * 2) + tree.get(v * 2 + 1));
        }
    }

    // set range for the tree
    void setRange(int l, int h)
    {
        low = l;
        high = h;
    }
}

public class GFG {
    // function to count elements within given range
    static int countInRange(int[] arr, int n, int x, int y) {
        SegmentTree st = new SegmentTree(n);
        st.setRange(x, y);
        st.build(arr, 1, 0, n - 1);
        return st.query(1, 0, n - 1, 0, n - 1);
    }

    // driver function
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 9, 10, 3 };
        int n = arr.length;

        // Answer queries
        int i = 1, j = 4;
        System.out.println(countInRange(arr, n, i, j));

        i = 9;
        j = 12;
        System.out.println(countInRange(arr, n, i, j));
    }
}
// Efficient C++ program to count number
// of elements with values in given range.
 

class GFG {
    // function to find first index >= x
    static int lowerIndex(int arr[], int n, int x) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    // function to find last index <= y
    static int upperIndex(int arr[], int n, int y) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }

    // function to count elements within given range
    static int countInRange(int arr[], int n, int x, int y) {
        // initialize result
        int count = 0;
        count = upperIndex(arr, n, y) -
                lowerIndex(arr, n, x) + 1;
        return count;
    }

    // Driver function
    public static void main(String[] args) {
        int arr[] = { 1, 4, 4, 9, 10, 3 };
        int n = arr.length;

        // Preprocess array
        Arrays.sort(arr);

        // Answer queries
        int i = 1, j = 4;
        System.out.println(countInRange(arr, n, i, j));
        ;

        i = 9;
        j = 12;
        System.out.println(countInRange(arr, n, i, j));

    }
}

//
