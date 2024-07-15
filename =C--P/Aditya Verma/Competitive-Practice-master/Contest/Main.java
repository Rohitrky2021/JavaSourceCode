import java.io.*;
import java.util.*;

@SuppressWarnings("all")
public class Main {

    void solve(FastReader sc) {
        int n = sc.nextInt();
        int nums[] = sc.nextArray(n);
        int sortedNums[] = nums.clone();
        Arrays.sort(sortedNums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(sortedNums[i], i);
        int count[] = new int[n];
        SumSegTree sumSegTree = new SumSegTree(count);
        long left[] = new long[n];
        for (int i = 0; i < n; i++) {
            left[i] = sumSegTree.rangeQuery(1, 0, n - 1, map.get(nums[i]) + 1, n - 1);
            sumSegTree.pointUpdate(1, 0, n - 1, map.get(nums[i]), 1);
        }
        Arrays.fill(count, 0);
        sumSegTree = new SumSegTree(count);
        long right[] = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = sumSegTree.rangeQuery(1, 0, n - 1, 0, map.get(nums[i]) -1);
            sumSegTree.pointUpdate(1, 0, n-1, map.get(nums[i]), 1);
        }
        long cnt = 0;
        for(int i = 1; i<n-1; i++)
            cnt+=(left[i] * right[i]);
        sc.println(cnt);
        sc.closer();
    }

    public static void main(String[] args) {
        // FastReader(true) for File I/O
        // FastReader() for terminal I/O
        Main ob = new Main();
        if (args.length > 0 && args[0].equals("local")) {
            FastReader sc = new FastReader(true);
            // CODE BEGIN

            // for(int T = sc.nextInt();T>0 ;T--)
            ob.solve(sc);
            // CODE END
            sc.closer();
        } else {
            FastReader sc = new FastReader();
            // CODE BEGIN

            // for(int T = sc.nextInt();T>0 ;T--)
            ob.solve(sc);
            // CODE END
            sc.closer();

        }
    }

    final int INTMAX = Integer.MAX_VALUE / 2;
    final int INTMIN = Integer.MIN_VALUE / 2;
    final long mod = 1000000000 + 7;

    void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static long power(long x, long y, long mod) {
        long res = 1L;
        x = x % mod;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % mod;

            y >>= 1;
            x = (x * x) % mod;
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static void sort(int[] a, boolean... rev) {
        List<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        if (rev.length > 0 && rev[0] == true)
            Collections.sort(l, Collections.reverseOrder());
        else
            Collections.sort(l);

        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void fill2D(int arr[][], int n) {
        for (int[] row : arr)
            Arrays.fill(row, n);
    }

    static List<List<Integer>> perms = new ArrayList<>();

    static void generatePermutations(int[] p, int depth) {

        // To generate all permuations of 1...n,
        // call generatePermutations(int[n] p, 1)
        // Results stored in perms
        int n = p.length;
        if (depth == n) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : p)
                tmp.add(i);

            perms.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (p[i] == 0) {
                p[i] = depth;
                generatePermutations(p, depth + 1);
                p[i] = 0;
            }
        }
    }

    static class pair implements Comparable<pair> {
        long x;
        long y;

        pair(long i, long j) {
            x = i;
            y = j;
        }

        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Long.compare(this.x, p.x);
            } else {
                return Long.compare(this.y, p.y);
            }
        }

        public String toString() {
            return x + " " + y;
        }

        public boolean equals(Object o) {
            pair x = (pair) o;
            return (x.x == this.x && x.y == this.y);
        }
    }

    static int upper_bound(int arr[], int key) {
        // Smallest vales greater than or equal to key
        int left = 0, right = arr.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= key) {
                pos = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return pos;
    }

    static int lower_bound(int arr[], int key) {
        // Largest value less than or equal to key
        int left = 0, right = arr.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= key) {
                pos = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return pos;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        PrintWriter pw;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new OutputStreamWriter(System.out));
        }

        public FastReader(boolean b) {
            try {
                br = new BufferedReader(new FileReader("input.txt"));
                pw = new PrintWriter("output.txt");

            } catch (Exception e) {

            }

        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    pw.print(' ');
                pw.print(objects[i]);
            }
        }

        void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    pw.print(' ');
                pw.print(objects[i]);
            }
            pw.println();
        }

        void viewArray1D(int a[]) {
            println(Arrays.toString(a));
        }

        void viewArray2D(int arr[][]) {
            for (int[] row : arr)
                viewArray1D(row);
        }

        void closer() {
            try {
                br.close();
                pw.flush();
                pw.close();
            } catch (Exception e) {
            }
        }
    }
}

// MAX SEGTREEE
// CNT SEGTREE WITH ODD PARITY
// SUM SEGTREE

class MaxSegTree {
    long tree[];
    int nums[];

    public MaxSegTree(int nums[]) {
        this.nums = nums;
        int n = nums.length;
        tree = new long[4 * n + 5];
        buildTree(1, 0, n - 1);
    }

    public void buildTree(int ind, int l, int r) {
        if (l > r)
            return;
        if (l == r) {
            tree[ind] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(2 * ind, l, mid);
        buildTree(2 * ind + 1, mid + 1, r);
        tree[ind] = Math.max(tree[2 * ind], tree[2 * ind + 1]);

    }

    public void pointUpdate(int ind, int l, int r, int pos, int val) {
        if (pos < l || r < pos)
            return;
        if (l == r) {
            tree[ind] = val;
            nums[l] = val;
            return;
        }

        int mid = (l + r) / 2;
        pointUpdate(2 * ind, l, mid, pos, val);
        pointUpdate(2 * ind + 1, mid + 1, r, pos, val);
        tree[ind] = Math.max(tree[2 * ind], tree[2 * ind + 1]);
    }

    public long rangeQuery(int ind, int l, int r, int lq, int rq) {
        if (r < lq || rq < l)
            return Long.MIN_VALUE / 2;
        if (lq <= l && r <= rq)
            return tree[ind];
        int mid = (l + r) / 2;
        long left = rangeQuery(2 * ind, l, mid, lq, rq);
        long right = rangeQuery(2 * ind + 1, mid + 1, r, lq, rq);
        return Math.max(left, right);
    }
}

class CountOddSegTree {
    long tree[];
    int nums[];

    public CountOddSegTree(int nums[]) {
        this.nums = nums;
        int n = nums.length;
        tree = new long[4 * n + 5];
        buildTree(1, 0, n - 1);
    }

    public void buildTree(int ind, int l, int r) {
        if (l > r)
            return;
        if (l == r) {
            tree[ind] = nums[l] % 2;
            return;
        }
        int mid = (l + r) / 2;
        buildTree(2 * ind, l, mid);
        buildTree(2 * ind + 1, mid + 1, r);
        tree[ind] = tree[2 * ind] + tree[2 * ind + 1];

    }

    public void pointUpdate(int ind, int l, int r, int pos, int val) {
        if (pos < l || r < pos)
            return;
        if (l == r) {
            tree[ind] = val % 2;
            nums[l] = val % 2;
            return;
        }

        int mid = (l + r) / 2;
        pointUpdate(2 * ind, l, mid, pos, val);
        pointUpdate(2 * ind + 1, mid + 1, r, pos, val);
        tree[ind] = tree[2 * ind] + tree[2 * ind + 1];
    }

    public long rangeQuery(int ind, int l, int r, int lq, int rq) {
        if (r < lq || rq < l)
            return 0;
        if (lq <= l && r <= rq)
            return tree[ind];
        int mid = (l + r) / 2;
        long left = rangeQuery(2 * ind, l, mid, lq, rq);
        long right = rangeQuery(2 * ind + 1, mid + 1, r, lq, rq);
        return left + right;
    }
}

class SumSegTree {
    long tree[];
    int nums[];

    public SumSegTree(int nums[]) {
        this.nums = nums;
        int n = nums.length;
        tree = new long[4 * n + 5];
        buildTree(1, 0, n - 1);
    }

    public void buildTree(int ind, int l, int r) {
        if (l > r)
            return;
        if (l == r) {
            tree[ind] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(2 * ind, l, mid);
        buildTree(2 * ind + 1, mid + 1, r);
        tree[ind] = tree[2 * ind] + tree[2 * ind + 1];

    }

    public void pointUpdate(int ind, int l, int r, int pos, int val) {
        if (pos < l || r < pos)
            return;
        if (l == r) {
            tree[ind] = val;
            nums[l] = val;
            return;
        }

        int mid = (l + r) / 2;
        pointUpdate(2 * ind, l, mid, pos, val);
        pointUpdate(2 * ind + 1, mid + 1, r, pos, val);
        tree[ind] = tree[2 * ind] + tree[2 * ind + 1];
    }

    public long rangeQuery(int ind, int l, int r, int lq, int rq) {
        if (r < lq || rq < l)
            return 0;
        if (lq <= l && r <= rq)
            return tree[ind];
        int mid = (l + r) / 2;
        long left = rangeQuery(2 * ind, l, mid, lq, rq);
        long right = rangeQuery(2 * ind + 1, mid + 1, r, lq, rq);
        return left + right;
    }
}