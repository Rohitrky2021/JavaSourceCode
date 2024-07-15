import java.util.Scanner;

// https://www.spoj.com/problems/SEQ/

class MatrizSpojExpo{
    static final int MAX = 15;
    static final int MODULO = 1000000000;

    static class Matrix {
        int rowSize = MAX - 1;
        int columnSize = MAX - 1;
        int[][] data = new int[MAX][MAX];

        Matrix() {
            for (int i = 1; i <= rowSize; i++) {
                for (int j = 1; j <= columnSize; j++) {
                    data[i][j] = 0;
                }
            }
        }

        Matrix multiply(Matrix other) {
            assert columnSize == other.rowSize;
            Matrix result = new Matrix();
            for (int i = 1; i <= rowSize; i++) {
                for (int j = 1; j <= other.columnSize; j++) {
                    for (int k = 1; k <= columnSize; k++) {
                        result.data[i][j] = (int) ((result.data[i][j] + 1L * data[i][k] * other.data[k][j] % MODULO) % MODULO);
                    }
                }
            }
            result.rowSize = rowSize;
            result.columnSize = other.columnSize;
            return result;
        }

        Matrix power(int e) {
            if (e == 1) {
                return this;
            }
            if ((e & 1) == 1) {
                return multiply(power(e - 1));
            }
            Matrix half = power(e >> 1);
            return half.multiply(half);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int cases = 0; cases < T; cases++) {
            int K = scanner.nextInt();
            int[] b = new int[MAX];
            int[] c = new int[MAX];
            for (int i = 1; i <= K; i++) {
                b[i] = scanner.nextInt();
            }
            for (int i = 1; i <= K; i++) {
                c[i] = scanner.nextInt();
            }
            int N = scanner.nextInt();
            if (N <= K) {
                System.out.println(b[N]);
                continue;
            }

            Matrix t = new Matrix();
            Matrix I = new Matrix();
            t.rowSize = K;
            t.columnSize = K;
            for (int i = 2; i <= K; i++) {
                t.data[i - 1][i] = 1;
            }
            for (int i = 1; i <= K; i++) {
                t.data[K][i] = c[K - i + 1];
            }
            I.rowSize = K;
            I.columnSize = 1;
            for (int i = 1; i <= K; i++) {
                I.data[i][1] = b[i];
            }
            Matrix result = t.power(N - K).multiply(I);
            System.out.println(result.data[K][1]);
        }
    }
}
