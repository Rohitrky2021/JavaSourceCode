
package T18_Graphs;

import java.util.*;

public class G14_bellmanford2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // A easier way of Storing Graph yha Array nhi use hoga
    static void creatGraph(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    static void bellmanford(ArrayList<Edge> graph, int src, int v) {
        int dist[] = new int[v];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < graph.size(); j++) { // Now that before 2 loop converted to one
                Edge e = graph.get(j);               // TC will remain same as previous
                int V = e.dest;
                int U = e.src;
                int wt = e.wt;
                if (dist[U] != Integer.MAX_VALUE && dist[V] > dist[U] + wt) {
                    dist[V] = dist[U] + wt;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        creatGraph(graph);
        int src = 0;
        bellmanford(graph, src, v);

    }
}
