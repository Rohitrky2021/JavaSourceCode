 
import java.util.*;

class kth_Smallest_In_Range {

    static class Node {
        int count;
        Node left, right;

        Node(int count, Node left, Node right) {
            this.count = count;
            this.left = left;
            this.right = right;
        }

        Node insert(int l, int r, int w) {
            if (l <= w && w < r) {
                if (l + 1 == r) {
                    return new Node(this.count + 1, null, null);
                }
                int m = (l + r) >> 1;
                return new Node(this.count + 1, this.left.insert(l, m, w), this.right.insert(m, r, w));
            }
            return this;
        }
    }

    static Node nullNode = new Node(0, null, null);

    static int query(Node a, Node b, int l, int r, int k) {
        if (l + 1 == r) {
            return l;
        }
        int m = (l + r) >> 1;
        int count = a.left.count - b.left.count;
        if (count >= k) {
            return query(a.left, b.left, l, m, k);
        }
        return query(a.right, b.right, m, r, k - count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        Map<Integer, Integer> M = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            M.put(a[i], 0);
        }

        int maxi = 0;
        for (int val : M.keySet()) {
            M.put(val, maxi++);
        }

        int[] RM = new int[maxi];
        Node[] root = new Node[n];

        nullNode.left = nullNode.right = nullNode;

        for (int i = 0; i < n; i++) {
            root[i] = (i == 0 ? nullNode : root[i - 1]).insert(0, maxi, M.get(a[i]));
        }

        while (m-- > 0) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int k = scanner.nextInt();

            u--;
            v--;

            int ans = query(root[v], (u == 0 ? nullNode : root[u - 1]), 0, maxi, k);
            System.out.println(RM[ans]);
        }
    }
}
