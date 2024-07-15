package T18_Graphs;

// Using --> DFS 
import java.util.*;
// https://www.youtube.com/watch?v=K_LamGUvwUc&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=6

public class G08_cycleDetection_directedGraph {
    static class Edge{
        int src;
        int dst;
        Edge(int s, int d){
            this.src = s;
            this.dst = d;
        }
    }
    static void creatGraph(ArrayList<Edge> [] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    // Using --> DFS 
    static boolean isCycle(ArrayList<Edge> [] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(isCycleUtil(graph, vis, stack, i)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isCycleUtil(ArrayList<Edge> [] graph, boolean vis[], boolean stack[], int curr){
        vis[curr] = true;
        stack[curr] = true;  // recurr[] --> used for Diff recurr Calls check 
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dst]){ // u se v m pehle he v bisited hai to yes -> for Current DFS cyle k liye use hota hai 
                return true;
            }
            if(!vis[e.dst]){
                if(isCycleUtil(graph, vis, stack, e.dst)){
                    return true;
                }
            }
        }
        stack[curr] = false; // Backtrack Step 
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);
        System.out.println(isCycle(graph));
    }
}
