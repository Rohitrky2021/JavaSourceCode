// util function are used to travell all break part of graph also !!

// This aslo Keep mind that its Double end directed graph i.e if A->B then there is B->A

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// public class creating {
    public class BfsUtil {
    static class edge{
        int sorce;
        int dest;
        int weight;

        edge(int s,int d,int w){
            this.sorce=s;
            this.dest=d;
            this.weight=w;
        } 

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

    public static void main(String args[]){
        int v=7;
        ArrayList<edge>[] graph=new ArrayList[v];

        for(int i=0;i<v;i++){
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
        //my neighbour Nodes;
        // for(int i=0;i<graph[2].size();i++){
        //     edge e=graph[2].get(i);
        //     System.out.println(e.dest);
        // }

        //    System.out.println(Bipartite(graph)); 

        BFS(graph);


    }
    public static void BFS(ArrayList<edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        // boolean stack[]=new boolean[graph.length];

            for(int i=0;i<graph.length;i++){
                if(!vis[i]){
                    BFSUtil(graph,vis);

                }
            }

    }

    public static void BFSUtil(ArrayList<edge>[] graph,boolean visit[]){
        // int visit[]={};
       
        Queue<Integer> q=new LinkedList<>();
       
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visit[curr]){
                // System.out.println(curr);
                visit[curr]=true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

}


