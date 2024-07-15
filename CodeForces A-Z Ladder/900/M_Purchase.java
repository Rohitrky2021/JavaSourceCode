import java.util.*;

public class M_Purchase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        Long arr[] = new Long[n];
        
        // Input the elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // Sort the array in descending order
        Arrays.sort(arr, Collections.reverseOrder());

        // Compute cumulative sums
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        // Process queries
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // Handle queries
            if (x == y) {
                sb.append(arr[x - 1] + "\n");
            } else {
                sb.append(arr[x - 1] - arr[x - y - 1] + "\n");
            }
        }

        // Output the result
        System.out.print(sb.toString());

        // Close the scanner
        sc.close();
    }
}
