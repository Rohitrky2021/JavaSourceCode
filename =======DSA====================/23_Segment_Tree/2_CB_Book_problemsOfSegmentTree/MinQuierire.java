 
/*Problem Name:{{ MIN QUERY-I }}
Problem Difficulty: 
Problem Constraints: 1<=N,Q<=10^5
|Ai|,|Y|<=10^9
1<=L,R,X<=N
Problem Description:
You are given an array A of n elements and Q queries. Each query can be of following types: 
1. 1 L R: Print the minimum value in AL, AL+1, AL+2....,AR.
2. 2 X Y: Update the value of Ax with Y.

Input Format: First line contains integers N and Q, denoting the number of elements and number of queries. Next line contains N integers, denoting *A<sub>1</sub>, A<sub>2</sub>, A<sub>3</sub>....,A<sub>N</sub>*. Next Q lines contains Q queries.
Sample Input:
5 5
1 4 3 5 2
1 1 5
2 3 9
1 2 4
1 2 5
1 3 4

Output Format: Answer each query of type 1.
Sample Output: 
1
4
2
5

=====Solution===== */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinQuierire {
    static final int MAXN = 100100;
    static int[] t = new int[4 * MAXN];
    static int[] a = new int[MAXN];

    public static void build(int node, int st, int en) {
        if (st == en) {
            t[node] = a[st];
            return;
        }
        int mid = (st + en) >> 1;
        build(node * 2 + 1, st, mid);
        build(node * 2 + 2, mid + 1, en);
        t[node] = Math.min(t[node * 2 + 1], t[node * 2 + 2]);
    }

    public static void update(int node, int st, int en, int pos) {
        if (st == en) {
            t[node] = a[st];
            return;
        }
        int mid = (st + en) >> 1;
        if (pos <= mid)
            update(node * 2 + 1, st, mid, pos);
        else
            update(node * 2 + 2, mid + 1, en, pos);
        t[node] = Math.min(t[node * 2 + 1], t[node * 2 + 2]);
    }

    public static int query(int node, int st, int en, int l, int r) {
        if (st > en || en < l || st > r)
            return Integer.MAX_VALUE;
        if (st >= l && en <= r)
            return t[node];
        int mid = (st + en) >> 1;
        int p1 = query(node * 2 + 1, st, mid, l, r);
        int p2 = query(node * 2 + 2, mid + 1, en, l, r);
        return Math.min(p1, p2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        build(0, 0, n - 1);

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (c == 1)
                System.out.println(query(0, 0, n - 1, l - 1, r - 1));
            else {
                a[l - 1] = r;
                update(0, 0, n - 1, l - 1);
            }
        }
    }
}
