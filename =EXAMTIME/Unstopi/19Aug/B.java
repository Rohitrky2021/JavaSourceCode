import java.util.*;

public class B {
    
    static class PairHash<T1, T2> {
        public int hashCode(Pair<T1, T2> pair) {
            return Objects.hashCode(pair.first) ^ Objects.hashCode(pair.second);
        }
    }

    static class Pair<T1, T2> {
        T1 first;
        T2 second;

        Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    static void calculateDegrees(int node, int parent, int[] degree, List<List<Integer>> adj) {
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                degree[node]++;
                degree[neighbor]++;
                calculateDegrees(neighbor, node, degree, adj);
            }
        }
    }

    static void findUniquePairs(int node, int parent, int[] degree, List<List<Integer>> adj, Set<Pair<Integer, Integer>> uniquePairs) {
        int n = degree.length - 1;
        int[][] dp = new int[n + 1][n * 2 + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                for (int k = n * 2; k >= degree[i]; k--) {
                    dp[j][k] += dp[j - 1][k - degree[i]];
                }
            }
        }

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n * 2; y++) {
                if (dp[x][y] > 0) {
                    uniquePairs.add(new Pair<>(x, y));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int Ai = scanner.nextInt();
            int Bi = scanner.nextInt();
            adj.get(Ai).add(Bi);
            adj.get(Bi).add(Ai);
        }

        int[] degree = new int[N + 1];
        calculateDegrees(1, -1, degree, adj);

        Set<Pair<Integer, Integer>> uniquePairs = new HashSet<>();
        findUniquePairs(1, -1, degree, adj, uniquePairs);

        System.out.println(uniquePairs.size());
    }
}
