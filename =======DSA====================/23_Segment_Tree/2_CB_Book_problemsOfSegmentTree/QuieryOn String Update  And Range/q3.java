 
import java.io.*;
import java.util.*;

public class q3 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        long mod = (long) (1000000007);
        long fact[];
        int depth[];
        int parentTable[][];
        int degree[];
        ArrayList<Integer> leaves;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            while (testNumber-- > 0) {
                int n = in.nextInt();
                int q = in.nextInt();
                char a[] = in.next().toCharArray();
                Node tree[] = new Node[4 * n];
                build(tree, a, 0, n - 1, 0);
                for (int i = 0; i < q; i++) {
                    int type = in.nextInt();
                    int x = in.nextInt();
                    int y = in.nextInt();
                    if (type == 1)
                        update(tree, 0, n - 1, x - 1, y, 0);
                    else
                        out.println(query(tree, 0, n - 1, x - 1, y - 1, 0).ans);
                }
            }
        }

        public Node query(Node tree[], int tl, int th, int ql, int qh, int pos) {
            if (tl > qh || th < ql)
                return new Node(false);

            if (ql <= tl && th <= qh)
                return tree[pos];

            int mid = (tl + th) >> 1;
            Node left = query(tree, tl, mid, ql, qh, 2 * pos + 1);
            Node right = query(tree, mid + 1, th, ql, qh, 2 * pos + 2);
            return merge(left, right);
        }

        public void update(Node tree[], int tl, int th, int index, int value, int pos) {
            if (tl == th && tl == index) {
                tree[pos] = new Node(true);
                tree[pos].total = value % 3;
                tree[pos].prefix[value % 3]++;
                tree[pos].suffix[value % 3]++;
                tree[pos].ans = (value % 3 == 0) ? 1 : 0;
                return;
            }
            if (tl > index || th < index)
                return;

            int mid = (tl + th) >> 1;
            update(tree, tl, mid, index, value, 2 * pos + 1);
            update(tree, mid + 1, th, index, value, 2 * pos + 2);
            tree[pos] = merge(tree[2 * pos + 1], tree[2 * pos + 2]);
            // return tree[pos];
        }

        public Node merge(Node left, Node right) {
            if (!left.isValid)
                return right;
            if (!right.isValid)
                return left;

            Node parent = new Node(true);
            parent.total = (left.total + right.total) % 3;

            for (int i = 0; i < 3; i++) {
                parent.prefix[i] = left.prefix[i] + right.prefix[(3 - left.total + i) % 3];
                parent.suffix[i] = right.suffix[i] + left.suffix[(3 - right.total + i) % 3];
            }

            parent.ans = left.ans + right.ans;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    if ((i + j) % 3 == 0)
                        parent.ans += (long) left.suffix[i] * right.prefix[j];
                }

            return parent;
        }

        public void build(Node tree[], char a[], int low, int high, int pos) {
            if (low == high) {
                tree[pos] = new Node(true);
                int x = a[low] - '0';
                tree[pos].total = x % 3;
                tree[pos].prefix[x % 3]++;
                tree[pos].suffix[x % 3]++;
                tree[pos].ans = (x % 3 == 0) ? 1 : 0;
                return;
            }
            int mid = (low + high) >> 1;
            build(tree, a, low, mid, 2 * pos + 1);
            build(tree, a, mid + 1, high, 2 * pos + 2);
            tree[pos] = merge(tree[2 * pos + 1], tree[2 * pos + 2]);
        }

        class Node {
            int total;
            int prefix[];
            int suffix[];
            long ans;
            boolean isValid;

            public Node(boolean a) {
                total = 0;
                prefix = new int[3];
                suffix = new int[3];
                ans = 0;
                isValid = a;
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
