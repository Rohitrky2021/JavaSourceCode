import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // number of containers
            long[] containers = new long[n]; // array to store the amounts of water in containers
            long sum = 0; // sum of water in all containers
            for (int i = 0; i < n; i++) {
                containers[i] = scanner.nextLong();
                sum += containers[i];
            }

            if (sum % n != 0) {
                System.out.println("NO"); // if the sum is not divisible by n, print NO
            } else {
                long target = sum / n; // target amount of water for each container
                boolean possible = true;
                long excess = 0; // excess water that needs to be redistributed
                for (long amount : containers) {
                    excess += amount - target; // calculate excess water
                    if (excess < 0 || excess % n != 0) {
                        possible = false;
                        break;
                    }
                }
                System.out.println(possible ? "YES" : "NO"); // print YES if possible, otherwise NO
            }
        }
    }
}
