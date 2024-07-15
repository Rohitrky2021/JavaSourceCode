package T18_Graphs;

import java.util.*;

public class G07_bipartite {

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
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

    }

    public static void BFS(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean check[] = new boolean[graph.length];
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!check[curr]) {
                System.out.print(curr + " ");
                check[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }

    // Normal BFS 
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int vis[] = new int[graph.length];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == -1) {
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(i);
                        if (e.dst == -1) {
                    //New color assigning should be differnt         
                            int newColour = vis[curr] == 0 ? 1 : 0;
                            vis[e.dst] = newColour;
                            q.add(e.dst);
                        } else if (vis[e.dst] == vis[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph);
        // BFS(graph);
        System.out.println(isBipartite(graph));
    }
}
