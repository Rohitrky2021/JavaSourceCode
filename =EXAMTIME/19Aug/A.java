import java.util.*;

public class A {
    private static List<List<Integer>> tree;
    private static int[] weights;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minWeight = findMinWeightInPath(i, j);
                if (minWeight != Integer.MAX_VALUE) { // Only add to result if a valid path is found
                    result += minWeight;
                }
            }
        }

        System.out.println(result);
        scanner.close();
    }

    private static int findMinWeightInPath(int start, int end) {
        boolean[] visited = new boolean[n];
        return dfs(start, end, visited, Integer.MAX_VALUE);
    }

    private static int dfs(int current, int target, boolean[] visited, int minWeight) {
        if (current == target) {
            return Math.min(minWeight, weights[current]);
        }

        visited[current] = true;
        int minW = Integer.MAX_VALUE;
        for (int neighbor : tree.get(current)) {
            if (!visited[neighbor]) {
                int currentMin = Math.min(minWeight, weights[current]);
                int result = dfs(neighbor, target, visited, currentMin);
                if (result != Integer.MAX_VALUE) {
                    minW = Math.min(minW, result);
                }
            }
        }
        visited[current] = false;
        return minW;
    }
}
