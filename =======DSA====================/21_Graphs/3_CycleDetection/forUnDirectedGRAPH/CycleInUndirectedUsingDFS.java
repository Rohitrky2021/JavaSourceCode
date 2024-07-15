import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;

public class CycleInUndirectedUsingDFS{

    // A modified DFS code used ---------->O(V+E);

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
        int v=4;
        // edge e=new edge;
        ArrayList<edge>[] graph=new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,1));
        graph[0].add(new edge(0,3,1));
        graph[1].add(new edge(1,2,1));
        graph[3].add(new edge(3,2,1));
        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(1,0,1));



        System.out.println(iscycle(graph)); 




    }
    
    public static boolean iscycle(ArrayList<edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

            for(int i=0;i<graph.length;i++){
                if(!vis[i]){
                    if(iscycleutil(graph, i, vis, stack)){
                        return true;
                    }
                }
            }
            return false;
    }


    public static boolean iscycleutil(ArrayList<edge>[] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e= graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            else if(!vis[e.dest] && iscycleutil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;

    }
}
