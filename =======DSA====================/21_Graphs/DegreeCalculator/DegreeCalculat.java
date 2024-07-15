import java.util.*;
public class DegreeCalculat {

class Solution {
    static class edge {
        int source;
        int dest;

        edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    public static void calcDegrees(ArrayList<edge> graph[], int indegree[], int outdegree[]) {
        // Calculate in-degrees and out-degrees
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                edge e = graph[v].get(j);
                indegree[e.dest]++;
                outdegree[e.source]++;
            }
        }
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int source = roads[i][0];
            int dest = roads[i][1];
            graph[source].add(new edge(source, dest));
            graph[dest].add(new edge(dest, source));
        }
        
        int maxRank = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                maxRank = Math.max(maxRank, topsort(graph, i, visited));
            }
        }

        return maxRank;
    }

    public static int topsort(ArrayList<edge> graph[], int start, boolean[] visited) {
        int n = graph.length;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        calcDegrees(graph, indegree, outdegree);

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> inDegrees = new ArrayList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (!visited[e.dest] && indegree[e.dest] == 0) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            inDegrees.add(indegree[i]);
        }
        Collections.sort(inDegrees, Collections.reverseOrder());

        return inDegrees.get(0) + inDegrees.get(1);
    }
}

}
