import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Number of tracks
            int[] tracks = new int[n];
            for (int j = 0; j < n; j++) {
                tracks[j] = scanner.nextInt();
            }
            
            int[] cumulativeIncrease = new int[n];
            cumulativeIncrease[0] = tracks[0];
            for (int j = 1; j < n; j++) {
                cumulativeIncrease[j] = cumulativeIncrease[j - 1] + tracks[j];
            }
            
            int q = scanner.nextInt(); // Number of queries
            for (int j = 0; j < q; j++) {
                int l = scanner.nextInt(); // Start index
                int u = scanner.nextInt(); // Performance increase
                
                int maxIncrease = Integer.MIN_VALUE;
                int optimalR = -1;
                
                for (int r = l - 1; r < n; r++) {
                    int sections = cumulativeIncrease[r] - (l > 1 ? cumulativeIncrease[l - 2] : 0);
                    int increase = (u + 1) * sections - (sections * (sections - 1)) / 2;
                    if (increase > maxIncrease) {
                        maxIncrease = increase;
                        optimalR = r + 1;
                    }
                }
                
                System.out.print(optimalR + " ");
            }
            System.out.println();
        }
    }
}