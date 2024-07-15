import java.util.Scanner;

public class LoadBalancer {
    // https://www.spoj.com/problems/BALIFE/

    // Divide it in parts --->As u know how the final array look after balance -->
    // Each elemt same with val==> Sum/N;
    // divide it ion parts and get the Max transfer case while partitioning --> That
    // max Will equal to the
    // NUmber Of rounds needed

    public static void main(String[] args) {
        int arr[] = new int[9000];

        int n, i, val;
        int diff = 0;

        while (true) {
            int max_load = 0, load = 0;

            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            if (n == -1)
                break;

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                load += arr[j];
            }
            if (load % n != 0) {
                System.out.println("-1");
                continue;
            }

            load = load / n;

            for (int j = 0; j < n; j++) {
                diff += (arr[j] - load);
                int ans = Math.abs(diff);
                max_load = Math.max(max_load, ans);

            }

            System.out.println(max_load);

        }
    }

}
