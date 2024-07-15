import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class I {
    @SuppressWarnings("unchecked")
    static class Graph {
        int V;
        ArrayList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u); // Since it's an undirected graph
        }

        int findMinimumWalkLength() {
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0); // Start from vertex 1
            dist[0] = 0;

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : adj[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        queue.add(v);
                    }
                }
            }

            for (int u = 0; u < V; u++) {
                if (dist[u] == -1) {
                    return -1; // If any vertex is not reachable from 1, return -1
                }
            }

            int maxDist = 0;
            for (int u = 0; u < V; u++) {
                maxDist = Math.max(maxDist, dist[u]);
            }

            return maxDist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);

            Graph graph = new Graph(N);

            for (int i = 0; i < M; i++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]) - 1; // 0-based indexing
                int v = Integer.parseInt(uv[1]) - 1;
                graph.addEdge(u, v);
            }

            int minWalkLength = graph.findMinimumWalkLength();
            System.out.println(minWalkLength);
        }
    }
}
