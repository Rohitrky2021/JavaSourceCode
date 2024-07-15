import java.util.ArrayList;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] distances = new int[q];

            for (int j = 0; j < q; j++) {
                distances[j] = scanner.nextInt();
            }

            solveTree(n, q, distances);
        }
    }

    private static void solveTree(int n, int q, int[] distances) {
        // Create the initial tree
        ArrayList<int[]> treeEdges = new ArrayList<>();
        for (int j = 1; j < n; j++) {
            treeEdges.add(new int[]{j, j + 1});
        }

        // Perform operations for each day
        ArrayList<int[]> operations = new ArrayList<>();
        for (int d : distances) {
            if (d == 2) {
                // No operation needed for distance 2
                operations.add(new int[]{-1, -1, -1});
            } else {
                // Perform an operation to create leaves at distance d
                operations.add(new int[]{d - 1, d, 1});
                treeEdges.remove(new int[]{1, d});
            }
        }

        // Output the tree edges
        for (int[] edge : treeEdges) {
            System.out.println(edge[0] + " " + edge[1]);
        }

        // Output the operations
        for (int[] operation : operations) {
            System.out.println(operation[0] + " " + operation[1] + " " + operation[2]);
        }
    }
}
