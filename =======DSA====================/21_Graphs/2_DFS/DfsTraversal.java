import java.util.*;
public class DfsTraversal {
    static class edge{
        int source;
        int dest;
        int weigh;

        edge(int s,int ds,int w){
            this.source=s;
            this.dest=ds;
            this.weigh=w;

        }
    }
    public static void main(String args[]){
        int v=7;
        // edge e=new edge;
        ArrayList<edge>[] graph=new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,1));
        graph[0].add(new edge(0,2,1));

        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,1));

        graph[2].add(new edge(2,4,1));
        graph[2].add(new edge(2,0,1));

        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,4,1));
        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,3,1));
        graph[4].add(new edge(4,5,1));
        graph[4].add(new edge(4,2,1));

        graph[5].add(new edge(5,6,1));
        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,3,1));

        graph[6].add(new edge(6,5,1));

        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        dfs(graph, 0, vis, stack);
    }
    
  public static void dfs(ArrayList<edge>[] graph,int curr,boolean vis[],boolean stack[]){
    System.out.println(curr+" ");
        vis[curr]=true;
        // stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis, stack);
            }
        }
    }
}
