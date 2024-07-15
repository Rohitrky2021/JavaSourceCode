
// package T18_Graphs;

import java.util.*;

public class G21_KosaRaju {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    // the talk is going for Directed Graph
    // SCC-> Strongly COnnected Component is way if we divide the graph is parts
    // then if we choose a node a then us part k hur part p i can reach from that
    // node
    // have to DO the Reverese DFS
    static void DFS(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                DFS(graph, e.dst, vis);
            }
        }
    }
// 1. Perform the topsort using stack last one of list will come on below we add while backtracking=>TC O(V+E)
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
    static void kosaRaju(ArrayList<Edge> graph[], int V) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, vis, s, i);
            }
        }

 // 2. Transpose the Grapgh ==> Just means ki Direction of All arrows ko Reverse Krna hai =>TC O(V+E)
        ArrayList<Edge> tranpose[] = new ArrayList[V];
        for (int i = 0; i < tranpose.length; i++) {
            vis[i] = false;
            tranpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.src -> e.dest
                tranpose[e.dst].add(new Edge(e.dst, e.src));//Reverseing of Edge 
            }
        }
// step 3. Perform the DFS now on the Transpose Graph =>TC O(V+E)
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {

                DFS(tranpose, curr, vis);
                System.out.println();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatGraph(graph);
        kosaRaju(graph, V);
    }
}
