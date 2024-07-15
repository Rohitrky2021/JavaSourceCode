
// https://chat.openai.com/c/181d8c8f-d112-4c0d-8900-42f4e94598a8

 /*Problem Name:   {{  MAX QUERY-I    }}
Problem Difficulty: 
Problem Constraints: 1<=N,Q<=10 ^5<br>
|Ai|, |K|<=10^9<br>
1<=L, R<=N
Problem Description:
You are given an array *A* of *N* elements and *Q* queries. Each query consists of 3 integers *L R K*.
 For each query, you have to find the number of elements *A<sub>x<sub>1</sub></sub>, A<sub>x<sub>2</sub></sub>,....,A<sub>x<sub>j</sub></sub>*>=*K*,
  where *L*<=*x<sub>1</sub>, x<sub>2</sub>,...x<sub>j</sub>*<=*R*.

Input Format: First line contains an integer *N*, denoting the number of elements in the array *A*. Next line contains *N* integers denoting the elements of the array.
 Next line contains a single integer *Q*, denoting the number of queries. Next Q lines contains Q queries, consisting of 3 integers each, *L R K*.
Sample Input:
 5
1 2 3 4 5
5
L R K 
1 4 1
1 5 2
1 5 3
1 5 4
1 5 5

Output Format: Print Q lines, 
where i<sup>th</sup> line contains the answer to the i<sup>th</sup> query.
Sample Output: 
4
4
3
2
1

// Speciality when u got the vector while doing queires it will be Sorted 

=====Solution===== */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static final int MAXN = 100005;

    //             At each tree node there will be like a Vector 
    static long query(Vector<Vector<Long>> tree, int ss, int se, int qs, int qe, int index, long k) {
        if (qe < ss || qs > se) {
            return 0;
        } else if (ss >= qs && se <= qe) {
            return tree.get(index).size() - lowerBound(tree.get(index), k);
        }

        int mid = (ss + se) / 2;
        long leftAns = query(tree, ss, mid, qs, qe, 2 * index, k);
        long rightAns = query(tree, mid + 1, se, qs, qe, 2 * index + 1, k);
        return leftAns + rightAns;
    }

    static void buildTree(Vector<Vector<Long>> tree, Vector<Long> arr, int s, int e, int index) {
        if (s == e) {
            tree.get(index).add(arr.get(s));
            return;
        }

        int mid = (s + e) / 2;
        buildTree(tree, arr, s, mid, index * 2);
        buildTree(tree, arr, mid + 1, e, index * 2 + 1);
        merge(tree.get(2 * index), tree.get(2 * index + 1), tree.get(index));
    }

    static int lowerBound(Vector<Long> vec, long key) {    // (N - lowerbound of K in vector )==> Then we will get  Number of elemennt less tha k  
        int low = 0, high = vec.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (vec.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Vector<Long> arr = new Vector<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextLong());
        }

        Vector<Vector<Long>> tree = new Vector<>(4 * n + 1);

        for (int i = 0; i < 4 * n + 1; i++) {
            tree.add(new Vector<>());
        }

        buildTree(tree, arr, 0, n - 1, 1);

        int q = scanner.nextInt();

        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long k = scanner.nextLong();
            l--;
            r--;

            System.out.println(query(tree, 0, n - 1, l, r, 1, k));
        }
    }
}
