import java.util.*;

public class BFS {

    static class Edge {
        int dst;

        Edge(int dst) {
            this.dst = dst;
        }
    }

    public static List<Integer> convertAdjacencyListToGraph(int n, List<List<Integer>> adj) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        
        // Convert List<List<Integer>> adj to ArrayList<Edge>[] graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < adj.get(i).size(); j++) {
                graph[i].add(new Edge(adj.get(i).get(j)));
            }
        }

        return bfsTraversal(n, graph);
    }

    public static List<Integer> bfsTraversal(int n, ArrayList<Edge>[] graph) {
        List<Integer> traversal = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                traversal.add(curr);
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
        return traversal;
    }
 
}


/*
    Time complexity: O(n + m). ||  Space complexity: O(n).

    Where 'n' is the number of vertices in the input graph and
   'm' is the number of edges in the input graph.
*/
public class Solution2 {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        // Start BFS from vertex 0
        q.add(0);
        // Initialize the visited array with all zeros
        int[] vis = new int[n];
        // Mark vertex 0 as visited (1 indicates visited, 0 indicates not visited)
        vis[0] = 1;
        while (!q.isEmpty()) {
            // Get the front vertex from the queue
            int topVertex = q.poll();
            // Add the current vertex to the result list
            res.add(topVertex);
            // Traverse all neighbors of the current vertex
            for (int neighbor : adj.get(topVertex)) {
                // If the neighbor is not visited, mark it as visited and enqueue it
                if (vis[neighbor] == 0) {
                    vis[neighbor] = 1;
                    q.add(neighbor);
                }
            }
        }
        return res;
    }
}

