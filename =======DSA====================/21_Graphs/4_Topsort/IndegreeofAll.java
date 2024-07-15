import java.util.*;


    public class IndegreeofAll {
    static class edge {
        int source;
        int dest;

        edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 1));
        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 3));

        graph[5].add(new edge(5, 2));
    }

    public static void calcindeee(ArrayList<edge> graph[], int indegree[],int[] outdegree) {
        // doing ++ in destination
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                edge e = graph[v].get(j);
                indegree[e.dest]++;
                outdegree[e.source]++;
            }
        }
    }
    

    public static void topsort(ArrayList<edge> graph[]) {
        int indegree[] = new int[graph.length];
        int outdegree[] = new int[graph.length];
        calcindeee(graph, indegree,outdegree);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        System.out.println("In-degree of vertices:");
        System.out.println(Arrays.toString(outdegree));
        System.out.println(Arrays.toString(indegree));


        for (int i = 0; i < indegree.length; i++) {
            System.out.println("Vertex " + i + ": " + indegree[i]);
            ans.add(indegree[i]+outdegree[i]);
        }
        Collections.sort(ans,Collections.reverseOrder());
        System.out.println(ans.toString());
        System.out.println(ans.get(0));

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topsort(graph);
    }
}
