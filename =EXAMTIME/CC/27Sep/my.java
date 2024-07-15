
    import java.util.*;

    public class my {
        public static void main(String[] args) throws java.lang.Exception {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt(); // Number of test cases
    
            for (int t = 0; t < T; t++) {
                int N = scanner.nextInt(); // Size of the array
                long K = scanner.nextLong(); // Required sum (using long)
    
                if (N % 2 == 1 || (K < N / 2) ) {
                    // If N is odd, or K is not within valid bounds, print -1
                    System.out.println("-1");
                } else {
                    int[] A = new int[N];
    
                    // Fill half of the array with 2 and the other half with 1
                    for (int i = 0; i < N / 2; i++) {
                        A[i] = 2;
                        A[N - i - 1] = 1;
                    }
    
                    // Calculate the remaining sum
                    long remainingSum = K - ((long) N / 2 * 2 + (long) N / 2 * 1);
    
                    // Distribute the remaining sum to even indices
                    for (int i = 0; i < N  && remainingSum>=0 ; i ++) {
                       
                        i=i%(N-1);
                        A[i]++;
                        remainingSum-=1;
                    }
                    while (remainingSum > 0) {
                        A[index]++; // Increase the value at the current index
                        remainingSum--; // Decrease the remaining sum
                        index = (index + 2) % N; // Move to the next even index
                    }
    
                    // Print the generated array
                    for (int i = 0; i < N; i++) {
                        System.out.print(A[i] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    