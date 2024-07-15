import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  // Number of kids
            int M = sc.nextInt();  // Initial number of cookies

            if(N>M){
                System.out.println(N-M);
                continue;
            }

            int remainder = M % N;
            
            // Minimum operations needed to make the number of cookies a multiple of N
            int minOperations = Math.min(remainder, N - remainder);
            
            System.out.println(minOperations);
        }

        sc.close();
    }
}
