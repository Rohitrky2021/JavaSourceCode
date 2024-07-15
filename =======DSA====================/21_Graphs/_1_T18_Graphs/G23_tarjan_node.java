
package T18_Graphs;

import java.util.*;

public class G23_tarjan_node {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

    }
/*
 * if u remove a node of a graph and its all connected edges then if Components increases--> Articulations Point
 * Like in Previous we can have multile bridge here also we can have Multiple Articulatn Point 
 * Works on Acestor And Child 
 */
    static void DFS(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean vis[],
            boolean arp[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                DFS(graph, neigh, curr, dt, low, time, vis, arp);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (par != -1 && dt[curr] <= low[neigh]) {
                    // System.out.println("point :" + curr);
                    arp[curr] = true;
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
        if (par == -1 && children > 0) {
            // System.out.println("point " + curr);
            arp[curr] = true;
        }
    }

    static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean arp[] = new boolean[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                DFS(graph, i, -1, dt, low, time, vis, arp);
            }
        }
        for (int i = 0; i < arp.length; i++) {
            if (arp[i]) {
                System.out.println("point : " + i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        creatGraph(graph);
        tarjanBridge(graph, V);

    }
}
