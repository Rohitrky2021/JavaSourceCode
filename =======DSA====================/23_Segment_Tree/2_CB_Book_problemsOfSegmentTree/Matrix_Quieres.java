 
import java.util.Scanner;

/*  
 * Problem Name: Matrix Queries-I
*     Problem Difficulty: 
*     Problem Constraints: 1<=n,q<=100000
*     1<=r<=10000
*     Problem Description:
*     Mike has *N* 2*2 matrices, M<sub>1</sub>, M<sub>2</sub>, ..., M<sub>n</sub>. Elements of matrices are in range [0,r-1], where r is an integer. Mike considers an operation, o, such that A<sub>2x2</sub> o B<sub>2x2</sub> = (A<sub>2x2</sub> * B<sub>2x2</sub>)%r (each value in the product of 2 matrices is stored modulo *r*). Mike gives you *q* queries, each of the form L,R. For each query, you have to find M<sub>L</sub> o M<sub>L+1</sub> o ... o M<sub>R</sub>.<br>
*     Note that it is not necessary, that all the input matrices are <a href="https://en.wikipedia.org/wiki/Invertible_matrix">invertible</a>. For eg. a matrix, A<sub>2x2</sub>=[[0,0],[0,0]] can be present in input.
*     
*     Input Format: The first line of the input file contains r, n and q.<br>
*     Next n blocks of two lines, containing two integer numbers ranging from 0 to r.<br>
*     Blocks are separated with blank lines.<br>
*     They are followed by q pairs of integers L and R.
*     
*     Sample Input: 
*     3 4 4
*     0 1
*     0 0
*     
*     2 1
*     1 2
*     
*     0 0
*     0 2
*     
*     1 0
*     0 2
*     
*     1 4
*     2 3
*     1 3
*     2 2
*     
*     Output Format: Print q blocks containing two lines each. Each line should contain two integer numbers ranging from 0 to r.<br>
*     Separate blocks with an empty line.
*     Sample Output: 
*     0 2
*     0 0
*     
*     0 2
*     0 1
*     
*     0 1
*     0 0
*     
*     2 1
*     1 2
 
=====Solution=====
 * 
 */

public class Matrix_Quieres {

    static int[][][] arr;
    static int[][][] tree;
    static int n, p;

    public static void buildTree(int index, int ss, int se) {
        // Base Case
        if (ss == se) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    tree[index][i][j] = arr[ss][i][j];
                }
            }
            return;
        }

        // Rec Case
        int mid = (ss + se) / 2;
        buildTree(2 * index, ss, mid);
        buildTree(2 * index + 1, mid + 1, se);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                tree[index][i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    tree[index][i][j] += (tree[2 * index][i][k] * tree[2 * index + 1][k][j]);
                }
            }
        }
    }

    public static int[][] query(int l, int r, int ss, int se, int index) {
        // Case of No Overlap
        if (l > se || r < ss) {
            int[][] a = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j] = (i == j) ? 1 : 0;
                }
            }
            return a;
        }

        // Case of Complete Overlap
        if (ss >= l && se <= r) {
            int[][] a = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j] = tree[index][i][j];
                }
            }
            return a;
        }

        // Case Of Partial Overlap
        int mid = (ss + se) / 2;
        int[][] leftAns = query(l, r, ss, mid, 2 * index);
        int[][] rightAns = query(l, r, mid + 1, se, 2 * index + 1);
        int[][] myans = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                myans[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    myans[i][j] += (leftAns[i][k] * rightAns[k][j]);
                }
            }
        }
        return myans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        p = scanner.nextInt();
        n = scanner.nextInt();
        int q = scanner.nextInt();

        arr = new int[n][2][2];
        tree = new int[4 * n + 2][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j][k] = scanner.nextInt();
                }
            }
        }

        buildTree(1, 0, n - 1);

        for (int o = 0; o < q; o++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int[][] ans = query(l - 1, r - 1, 0, n - 1, 1);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(ans[i][j] % p + " ");
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
