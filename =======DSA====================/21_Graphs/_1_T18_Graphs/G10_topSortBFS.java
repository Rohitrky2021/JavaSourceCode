package T18_Graphs;

// Kahns Algorith 
import java.util.*;

public class G10_topSortBFS {
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

    static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dst]++;
            }
        }
    }
    static void topSort(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];

        // 1. Calculate Indegree 
        calcIndeg(graph, indeg);

        // 2. Jinki Indegree==0 h unko Queue m daal do for a BFS start 
        Queue<Integer> q =  new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){  //tho update bhi krna h mtlb sub ka indegree  , these 0 indegree will used to start porblem
                q.add(i);
            }
        }
        // NOrmal BFS 
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dst]--;       // ye rha kyuki papa k paas se aaaye h or unka Value ab in Indree htana h
                if(indeg[e.dst] == 0){
                    q.add(e.dst);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);
        topSort(graph);
    }
}
