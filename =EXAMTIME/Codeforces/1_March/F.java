import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {
    static class SegmentTree {
        int[] st;
        int[] a;
        int n;

        SegmentTree(int[] arr, int size) {
            n = size;
            a = arr;
            st = new int[4 * n];
            build(1, 0, n - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {
                st[node] = a[start];
            } else {
                int mid = (start + end) / 2;
                build(node * 2, start, mid);
                build(node * 2 + 1, mid + 1, end);
                st[node] = st[node * 2] | st[node * 2 + 1];
            }
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                a[idx] = val;
                st[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(node * 2, start, mid, idx, val);
                } else {
                    update(node * 2 + 1, mid + 1, end, idx, val);
                }
                st[node] = st[node * 2] | st[node * 2 + 1];
            }
        }

        int query(int node, int start, int end, int l, int r, int v) {
            if (r < start || end < l) {
                return -1;
            }
            if (l <= start && end <= r) {
                if (st[node] < v) {
                    return -1;
                }
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (st[node * 2] >= v) {
                        node = node * 2;
                        end = mid;
                    } else {
                        node = node * 2 + 1;
                        start = mid + 1;
                    }
                }
                return start;
            }
            int mid = (start + end) / 2;
            int p1 = query(node * 2, start, mid, l, r, v);
            int p2 = query(node * 2 + 1, mid + 1, end, l, r, v);
            if (p1 == -1) return p2;
            if (p2 == -1) return p1;
            return Math.min(p1, p2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            SegmentTree segmentTree = new SegmentTree(b, n);

            int q = Integer.parseInt(br.readLine());
            while (q-- > 0) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    int idx = Integer.parseInt(st.nextToken()) - 1;
                    int val = Integer.parseInt(st.nextToken());
                    segmentTree.update(1, 0, n - 1, idx, val);
                } else {
                    int l = Integer.parseInt(st.nextToken()) - 1;
                    int r = Integer.parseInt(st.nextToken()) - 1;
                    int res = segmentTree.query(1, 0, n - 1, l, r, v);
                    if (res == -1) {
                        System.out.print("-1 ");
                    } else {
                        int maxBeauty = Integer.MIN_VALUE;
                        for (int i = res; i <= r; i++) {
                            maxBeauty = Math.max(maxBeauty, a[i]);
                        }
                        System.out.print(maxBeauty + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
