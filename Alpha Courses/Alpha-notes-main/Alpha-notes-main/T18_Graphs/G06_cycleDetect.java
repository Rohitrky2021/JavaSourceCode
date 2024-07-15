package T18_Graphs;

import java.util.*;

public class G06_cycleDetect {

    public static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int w) {
            this.dst = d;
            this.src = s;
            this.wt = w;
        }

    }

    static void creatGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *           (5)
         *       0 ------- 1
         *                / \
         *           (1) /   \ (3)
         *              /     \
         *             2 ----- 3
         *             |  (1)
         *         (2) |
         *             |
         *             4
         * 
         */

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        // graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        // graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

    }

    public static boolean cycleDetect(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleDetect_util(graph, i, -1, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetect_util(ArrayList<Edge>[] graph, int src, int per, boolean vis[]) {
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (vis[e.dst] && e.dst != per) {
                return true;
            } else if (!vis[e.dst]) {

                if (cycleDetect_util(graph, e.dst, src, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph);
        System.out.println(cycleDetect(graph));
    }
}
