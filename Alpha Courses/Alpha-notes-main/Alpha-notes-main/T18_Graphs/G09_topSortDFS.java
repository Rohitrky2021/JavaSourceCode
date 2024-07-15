package T18_Graphs;

import java.util.*;

public class G09_topSortDFS {
    static class Edge {
        int src;
        int dst;

        Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    static void creatGraph(ArrayList<Edge>[] graph) {
        
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, vis, s, i);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    static void topSortUtil(ArrayList<Edge>[] graph, boolean vis[], Stack<Integer> s, int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                topSortUtil(graph, vis, s, e.dst);
            }
        }
        s.push(curr);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);
        topSort(graph);
    }
}
