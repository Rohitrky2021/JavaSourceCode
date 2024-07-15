package T18_Graphs;

import java.util.*;


public class G02_BFS {

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
    static void creatGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *          
         *       0 ------- 1
         *                / \
         *               /   \ 
         *              /     \
         *             2 ----- 3
         *             | 
         *             |
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
    public static void BFS(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean check[] = new boolean[graph.length];
        q.add(0); // source = 0

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!check[curr]){
                System.out.print(curr + " ");
                check[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph);
        BFS(graph);


    }
}
