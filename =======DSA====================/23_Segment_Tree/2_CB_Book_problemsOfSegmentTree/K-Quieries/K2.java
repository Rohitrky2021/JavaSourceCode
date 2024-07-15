import java.util.*;

public class K2 {
    static final int Nmax = 30005;
    static int n, q, a, b, c;
    static int[] arr;
    static ArrayList<Integer>[] tree;

    public static void build(int node, int start, int end) {
        if (start == end) {
            tree[node].add(arr[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(node * 2 + 1, start, mid);
        build(node * 2 + 2, mid + 1, end);
        merge(tree[node * 2 + 1], tree[node * 2 + 1], tree[node * 2 + 2], tree[node * 2 + 2], new ArrayList<>());
        tree[node] = new ArrayList<>(tree[node * 2 + 1]);
        tree[node].addAll(tree[node * 2 + 2]);
    }

    public static int query(int node, int start, int end, int l, int r, int v) {
        if (l > end || r < start)
            return 0;
        if (start >= l && end <= r) {
            int k = Collections.binarySearch(tree[node], v) + 1;
            return (end - start + 1) - k;
        }
        int mid = start + (end - start) / 2;
        return query(node * 2 + 1, start, mid, l, r, v) + query(node * 2 + 2, mid + 1, end, l, r, v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new ArrayList[treeSize];

        for (int i = 0; i < treeSize; i++) {
            tree[i] = new ArrayList<>();
        }

        build(0, 0, n - 1);

        q = sc.nextInt();
        int ans = 0;

        while (q-- > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            int i, j, k;
            i = ans ^ a;
            j = ans ^ b;
            k = ans ^ c;
            if (i < 1)
                i = 1;
            if (j > n)
                j = n;
            if (i > j) {
                ans = 0;
                System.out.println(ans);
                continue;
            }
            i--;
            j--;
            ans = query(0, 0, n - 1, i, j, k);
            System.out.println(ans);
        }

        sc.close();
    }
}
