package topsort;

public class quest {
    
}
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indegre[]=new int[n];
        calcindeee(graph, indegre);

        for (int i = 0; i < indegre.length; i++) {
            ArrayList<Integer> arr=new ArrayList<>();
            if(indegre[i]==0){
                arr.add(i);
            }
            System.out.println(arr);
        }

    }

    public static void calcOutdegree(ArrayList<Edge>[] graph, int outdegree[]) {
        int n = graph.length;

        // Doing ++ in outdegree for each outgoing edge
        for (int i = 0; i < n; i++) {
            int v = i;
            for (Edge e : graph[v]) {
                outdegree[v]++;
            }
        }
    }
    public static void calcindeee(ArrayList<edge> graph[], int indegre[]){
        //doing ++ in destination
        for (int i = 0; i < n; i++) {
            int v=i;
            for (int j = 0; j < graph[v].size() ; j++) {
                List m=edges[i];
                indegre[e.dest]++;
            }
        }
    }
    public static void topsort(ArrayList<edge> graph[]){

    }
}


 