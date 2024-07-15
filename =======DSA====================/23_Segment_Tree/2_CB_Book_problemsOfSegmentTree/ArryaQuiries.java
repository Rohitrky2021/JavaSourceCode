 
import java.util.Scanner;

public class ArryaQuiries {   // NOt WOrkiing COde 

    static int n, k;
    static int[] A;
    static long[] tree;

    public static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = A[start];
            return;
        }

        int mid = (start + end) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        long leftSum = query(2 * node, start, mid, left, right);
        long rightSum = query(2 * node + 1, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

    public static void update(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            A[index] = newValue;
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            update(2 * node, start, mid, index, newValue);
        } else {
            update(2 * node + 1, mid + 1, end, index, newValue);
        }

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();
        int q = scanner.nextInt();

        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Build the segment tree
        tree = new long[4 * n];
        buildTree(1, 0, n - 1);

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                update(1, 0, n - 1, (x + n - 1) % n, y);
            } else if (type == 2) {
                int L = scanner.nextInt();
                int R = scanner.nextInt();
                long result = query(1, 0, n - 1, L - 1, R - 1);
                System.out.println(result);
            }
        }
    }
}
