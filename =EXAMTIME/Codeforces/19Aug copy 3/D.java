import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            
            long sumSnowy = 0;
            long sumNonSnowy = 0;
            
            int[][] heights = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    heights[i][j] = scanner.nextInt();
                }
            }
            
            for (int i = 0; i < n; i++) {
                String line = scanner.next();
                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == '0') {
                        sumSnowy += heights[i][j];
                    } else {
                        sumNonSnowy += heights[i][j];
                    }
                }
            }
            
            // Check if sums are already equal
            if (sumSnowy == sumNonSnowy) {
                System.out.println("YES");
            } else {
                // Check if at least one dimension is greater than or equal to k
                if (Math.min(n, m) < k) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
        
        scanner.close();
    }
}
