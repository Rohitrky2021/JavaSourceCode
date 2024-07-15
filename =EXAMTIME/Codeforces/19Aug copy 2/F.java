import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < t; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Step 1: Construct the matrix b
            int[][] b = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = a[(j - i + n) % n];
                }
            }

            // Step 2: Initialize DSU structures
            int totalVertices = n * n;
            parent = new int[totalVertices];
            rank = new int[totalVertices];
            for (int i = 0; i < totalVertices; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            // Step 3: Union by conditions
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int current = i * n + j;
                    if (j > 0 && Math.abs(b[i][j] - b[i][j - 1]) <= k && gcd(b[i][j], b[i][j - 1]) > 1) {
                        union(current, current - 1);
                    }
                    if (i > 0 && Math.abs(b[i][j] - b[i - 1][j]) <= k && gcd(b[i][j], b[i - 1][j]) > 1) {
                        union(current, current - n);
                    }
                }
            }

            // Step 4: Count the number of connected components
            List<Integer> components = new ArrayList<>();
            boolean[] visited = new boolean[totalVertices];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int root = find(i * n + j);
                    if (!visited[root]) {
                        components.add(root);
                        visited[root] = true;
                    }
                }
            }

            sb.append(components.size()).append("\n");
        }

        System.out.print(sb);
    }

    // Helper method to find the greatest common divisor
    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // Union-Find (Disjoint Set Union) operations
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
