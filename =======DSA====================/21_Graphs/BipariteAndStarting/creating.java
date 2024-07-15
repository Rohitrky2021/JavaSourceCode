import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class creating { // Here also Bfs is used somehat modifyed type
    static class edge {
        int sorce;
        int dest;
        int weight;

        edge(int s, int d, int w) {
            this.sorce = s;
            this.dest = d;
            this.weight = w;
        }

    }

    public static void main(String args[]) {
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1, 5));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 3));
        graph[1].add(new edge(1, 0, 5));
        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 2));
        graph[3].add(new edge(3, 1, 3));
        graph[3].add(new edge(3, 2, 1));
        graph[4].add(new edge(4, 2, 2));
        // my neighbour Nodes;
        // for(int i=0;i<graph[2].size();i++){
        // edge e=graph[2].get(i);
        // System.out.println(e.dest);
        // }

        System.out.println(Bipartite(graph));

        // BFS(graph);

    }

    public static void BFS(ArrayList<edge>[] graph) {
        // int visit[]={};

        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visit[curr]) {
                visit[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
                // System.out.println(e);
            }
        }

    }

    public static boolean Bipartite(ArrayList<edge>[] graph) {
        int col[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            // q.add(col[i]);
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;// red
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            // col[e.dest]=1;//black
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;// not bipartitie
                        }
                        // else()

                    }
                }
            }
            // if(col[i]==0)
        }
        return true;

    }
}
