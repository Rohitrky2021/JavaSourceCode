package T18_Graphs;

import java.util.*;

public class G13_bellmanford {
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

    static void creatGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    // 1. Same As Dijstra but if weight-> (Negative) then ye use krte hai
    // 2. But Doest Work for Negative Cycle and Thodi TC jaada hai eski
    // 3. Its a DP based Algo And Dijstra was Greedy Based
    static void bellmanford(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int v = graph.length;
        // O(V*E)-> OVerall TC 
        for (int i = 0; i < v - 1; i++) {//this loop take O(V)
            // edge - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int j2 = 0; j2 < graph[j].size(); j2++) {
                    Edge e = graph[j].get(j2);
                    int V = e.dest;
                    int U = e.src;
                    int wt = e.wt;
                    // Integer.MAX_VALUE na ho kyui or add hoke -ve m chle jaayega pr ans galtat
                    // aayega then
                    if (dist[U] != Integer.MAX_VALUE && dist[V] > dist[U] + wt) {
                        dist[V] = dist[U] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);
        int src = 0;
        bellmanford(graph, src);

    }
}
