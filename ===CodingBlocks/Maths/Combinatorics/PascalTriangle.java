
public class PascalTriangle {
    public static long[] pascalsTriangle(int N) {
        int n, k;
        long[] C = new long[N + 1];
        
        for (n = 0; n <= N; ++n) {
            C[n] = 1;
            k = n;
            while (--k > 0) {
                C[k] += C[k - 1];
            }
        }
        
        return C;
    }

    public static void main(String[] args) {
        int N = 1; // Replace with the desired value of N starts from 0;
        
        long[] pascalValues = pascalsTriangle(N);
        for (int i = 0; i <= N; i++) {
            System.out.print(pascalValues[i] + " ");
        }
    }
}

// Through Iterative Dp 
public class PascalTriangle {
    public static long[][] pascalsTriangle(int N) {
        long[][] triangle = new long[N + 1][N + 1];
        
        for (int n = 0; n <= N; ++n) {
            triangle[n][0] = 1;
            for (int k = 1; k <= n; ++k) {
                triangle[n][k] = triangle[n - 1][k - 1] + triangle[n - 1][k];  // using n^C^k= n-1^C^k-1+ n-1^C^k ;
            }
        }
        
        return triangle;
    }

    public static void main(String[] args) {
        int N = 10; // Replace with the desired value of N
        
        long[][] pascalTriangle = pascalsTriangle(N);
        for (int n = 0; n <= N; n++) {
            for (int k = 0; k <= n; k++) {
                System.out.print(pascalTriangle[n][k] + " ");
            }
            System.out.println();
        }
    }
}

// in Number Of grid Ways  in PnC as same type for bottom Up DP method 
