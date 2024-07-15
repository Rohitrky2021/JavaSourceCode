package T18_Graphs;

import java.util.*;

public class G16_cheapest_flite_within_k_stops {

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

    static void creatGraph(int flights[][], ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    @SuppressWarnings("unchecked")
    public static int cheapestPath(int flights[][], int n, int src, int dest, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];

        creatGraph(flights, graph);
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {

            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                // int U = e.src;
                int V = e.dest;
                int W = e.wt;
                if (curr.cost + W < dist[V] && curr.stop <= k) {
                    dist[V] = curr.cost + W;
                    q.add(new Info(V, dist[V], curr.stop + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {

            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        System.out.println(cheapestPath(flights, n, src, dest, k));
    }
}
