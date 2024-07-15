
// https://chat.openai.com/c/181d8c8f-d112-4c0d-8900-42f4e94598a8


// You have a string of N decimal digits, denoted by numbers A1,A2, ..., AN.
// Now you are given M queries, each of whom is of following two types.
// 1. 1 X Y: Replace AX by Y.
// 2. 2 C D: Print the number of sub-strings divisible by 3 in range [C,D]


/*
The key idea is to use a segment tree to store information about each interval of the string. The information stored in 
each node of the segment tree includes:

ans: the answer for that interval (number of substrings divisible by 3).
prefix[]: the number of prefixes of the interval that, modulo 3, give 0, 1, and 2.
suffix[]: the number of suffixes of the interval that, modulo 3, give 0, 1, and 2.
total: the total sum of the interval modulo 3. 
*/

 
import java.util.Scanner;

// public class QSET {
    public class QuieryOnStringAndUpdate {


    static class Tree {
        int ans;
        int[] prefix = new int[3];
        int[] suffix = new int[3];
        int total;
    }

    static Tree[] tree = new Tree[4 * 100005];
    static int[] arr = new int[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String s = sc.next();

        for (int i = 0; i < N; ++i) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }

        buildTree(1, 0, N - 1);

        for (int i = 0; i < M; ++i) {
            int type = sc.nextInt();

            if (type == 1) {
                int X = sc.nextInt() - 1;
                int Y = sc.nextInt();
                updateTree(1, 0, N - 1, X, Y);
            } else {
                int C = sc.nextInt() - 1;
                int D = sc.nextInt() - 1;
                int result = queryTree(1, 0, N - 1, C, D).ans;
                System.out.println(result);
            }
        }
    }

    static void buildTree(int node, int a, int b) {
        if (a == b) {
            tree[node] = new Tree();
            tree[node].prefix[arr[a] % 3] = 1;
            tree[node].suffix[arr[a] % 3] = 1;
            tree[node].total = arr[a] % 3;
            tree[node].ans = (arr[a] % 3 == 0 ? 1 : 0);
            return;
        }

        int mid = (a + b) / 2;
        buildTree(node * 2, a, mid);
        buildTree(node * 2 + 1, mid + 1, b);

        for (int i = 0; i < 3; ++i) {
            tree[node].prefix[i] = tree[node * 2].prefix[i] + tree[node * 2 + 1].prefix[(3 - tree[node * 2].total + i) % 3];
            tree[node].suffix[i] = tree[node * 2 + 1].suffix[i] + tree[node * 2].suffix[(3 - tree[node * 2 + 1].total + i) % 3];
        }

        tree[node].total = (tree[node * 2].total + tree[node * 2 + 1].total) % 3;
        tree[node].ans = tree[node * 2].ans + tree[node * 2 + 1].ans;

        for (int i = 0; i < 3; ++i) {
            if ((tree[node * 2].total + i) % 3 == 0) {
                tree[node].ans += tree[node * 2].suffix[i] * tree[node * 2 + 1].prefix[0];
            }
        }
    }

    static void updateTree(int node, int a, int b, int idx, int val) {
        if (a == b) {
            tree[node] = new Tree();
            tree[node].prefix[val % 3] = 1;
            tree[node].suffix[val % 3] = 1;
            tree[node].total = val % 3;
            tree[node].ans = (val % 3 == 0 ? 1 : 0);
            return;
        }

        int mid = (a + b) / 2;
        if (idx <= mid) {
            updateTree(node * 2, a, mid, idx, val);
        } else {
            updateTree(node * 2 + 1, mid + 1, b, idx, val);
        }

        for (int i = 0; i < 3; ++i) {
            tree[node].prefix[i] = tree[node * 2].prefix[i] + tree[node * 2 + 1].prefix[(3 - tree[node * 2].total + i) % 3];
            tree[node].suffix[i] = tree[node * 2 + 1].suffix[i] + tree[node * 2].suffix[(3 - tree[node * 2 + 1].total + i) % 3];
        }

        tree[node].total = (tree[node * 2].total + tree[node * 2 + 1].total) % 3;
        tree[node].ans = tree[node * 2].ans + tree[node * 2 + 1].ans;

        for (int i = 0; i < 3; ++i) {
            if ((tree[node * 2].total + i) % 3 == 0) {
                tree[node].ans += tree[node * 2].suffix[i] * tree[node * 2 + 1].prefix[0];
            }
        }
    }

    static Tree queryTree(int node, int a, int b, int i, int j) {
        if (a > b || a > j || b < i) {
            return new Tree();
        }

        if (a >= i && b <= j) {
            return tree[node];
        }

        int mid = (a + b) / 2;
        Tree left = queryTree(node * 2, a, mid, i, j);
        Tree right = queryTree(node * 2 + 1, mid + 1, b, i, j);

        Tree result = new Tree();
        result.ans = left.ans + right.ans;

        for (int k = 0; k < 3; ++k) {
            result.prefix[k] = left.prefix[k] + right.prefix[(3 - left.total + k) % 3];
            result.suffix[k] = right.suffix[k] + left.suffix[(3 - right.total + k) % 3];
        }

        result.total = (left.total + right.total) % 3;

        for (int k = 0; k < 3; ++k) {
            if ((left.total + k) % 3 == 0) {
                result.ans += left.suffix[k] * right.prefix[0];
            }
        }

        return result;
    }
}
