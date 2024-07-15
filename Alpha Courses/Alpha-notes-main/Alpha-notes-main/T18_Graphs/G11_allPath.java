package T18_Graphs;

import java.util.*;

public class G11_allPath {
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

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    static void path(ArrayList<Edge> graph[], int src, int dst, String path){
        if(src == dst){

            System.out.println(path + src);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            path(graph, e.dst, dst, path+src);

        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);
        path(graph, 5, 1, "");
    }
}
