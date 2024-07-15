import java.util.*;

class q2 {
    static class Node {
        int sum;
        int[] c;

        public Node() {
            this.c = new int[3];
        }
    }

    static int[] a;
    static Node[] segTree;

    static Node merge(Node s1, Node s2) {
        Node temp = new Node();
        temp.sum = (s1.sum + s2.sum) % 3;
        if (s1.sum == 0) {
            temp.c[0] = s1.c[0] + s2.c[0];
            temp.c[1] = s1.c[1] + s2.c[1];
            temp.c[2] = s1.c[2] + s2.c[2];
        } else if (s1.sum == 1) {
            temp.c[0] = s1.c[0] + s2.c[2];
            temp.c[1] = s1.c[1] + s2.c[0];
            temp.c[2] = s1.c[2] + s2.c[1];
        } else {
            temp.c[0] = s1.c[0] + s2.c[1];
            temp.c[1] = s1.c[1] + s2.c[2];
            temp.c[2] = s1.c[2] + s2.c[0];
        }
        return temp;
    }

    static void build(int node, int left, int right) {
        if (left == right) {
            segTree[node].sum = a[left] % 3;
            segTree[node].c[segTree[node].sum]++;
            return;
        }
        int mid = (left + right) >> 1;
        build(2 * node + 1, left, mid);
        build(2 * node + 2, mid + 1, right);
        segTree[node] = merge(segTree[2 * node + 1], segTree[2 * node + 2]);
    }

    static Node query(int node, int left, int right, int segLeft, int segRight) {
        if (left > right || left > segRight || right < segLeft)
            return new Node();
        if (left >= segLeft && right <= segRight)
            return segTree[node];
        int mid = (left + right) >> 1;
        Node q1 = query(2 * node + 1, left, mid, segLeft, segRight);
        Node q2 = query(2 * node + 2, mid + 1, right, segLeft, segRight);
        return merge(q1, q2);
    }

    static void update(int node, int left, int right, int index, int value) {
        if (left == right) {
            segTree[node].sum = value % 3;
            segTree[node].c[0] = segTree[node].c[1] = segTree[node].c[2] = 0;
            segTree[node].c[segTree[node].sum] = 1;
            return;
        }
        int mid = (left + right) >> 1;
        if (index <= mid)
            update(2 * node + 1, left, mid, index, value);
        else
            update(2 * node + 2, mid + 1, right, index, value);
        segTree[node] = merge(segTree[2 * node + 1], segTree[2 * node + 2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        a = new int[n];
        String s = sc.next();
        for (int i = 0; i < s.length(); i++)
            a[i] = (s.charAt(i) - '0') % 3;
        segTree = new Node[4 * n];
        for (int i = 0; i < segTree.length; i++)
            segTree[i] = new Node();
        build(0, 0, n - 1);
        while (q-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt() - 1;
            if (type == 1) {
                int x = sc.nextInt();
                update(0, 0, n - 1, l, x);
            } else {
                int r = sc.nextInt() - 1;
                Node ans = query(0, 0, n - 1, l, r);
                int c0 = ans.c[0];
                int c1 = ans.c[1];
                int c2 = ans.c[2];
                c0++;
                long ar = (long) (c0 * 1l * (c0 - 1) / 2);
                ar += (long) (c1 * 1l * (c1 - 1) / 2);
                ar += (long) (c2 * 1l * (c2 - 1) / 2);
                System.out.println(ar);
            }
        }
    }
}
