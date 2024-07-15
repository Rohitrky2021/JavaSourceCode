import java.util.ArrayList;
import java.util.Scanner;

// public class B {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         int n = scanner.nextInt();
//         long[] sequence = new long[n];

//         for (int i = 0; i < n; i++) {
//             sequence[i] = scanner.nextLong();
//         }

//         solveArithmeticMean(n, sequence);

//         scanner.close();
//     }

//     private static void solveArithmeticMean(int n, long[] sequence) {
//         ArrayList<Integer> resultIndices = new ArrayList<>();

//         long sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += sequence[i];
//         }

//         for (int i = 0; i < n; i++) {
//             if ((sum - sequence[i]) % (n - 1) == 0 && sequence[i] * (n - 1) == sum - sequence[i]) {
//                 resultIndices.add(i + 1);
//             }
//         }

//         System.out.println(resultIndices.size());

//         for (int index : resultIndices) {
//             System.out.print(index + " ");
//         }
//     }
// }

 
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] sequence = new long[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextLong();
        }

        solveArithmeticMean(n, sequence);

        scanner.close();
    }

    private static void solveArithmeticMean(int n, long[] sequence) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sequence[i];
        }

        ArrayList<Integer> resultIndices = new ArrayList<>();
        double target = (sum * (n - 1)) / n;

        for (int i = 0; i < n; i++) {
            if (sum - sequence[i] == target) {
                resultIndices.add(i + 1);
            }
        }

        System.out.println(resultIndices.size());

        for (int index : resultIndices) {
            System.out.print(index + " ");
        }
    }
}

