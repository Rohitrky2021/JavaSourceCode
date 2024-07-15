// import java.util.ArrayList;
// import java.util.PriorityQueue;

// public class Dijs {

//     /**
//      * edge
//      */
//     public class edge {
//         int src;
//         int dest;
//         int wt;
//         edge(int s,int d,int wt){
//             this.src=s;
//             this.dest=d;
//             this.wt=wt;
//         }
//     }

//     public class pair {
//       int val, idx;
    
//       pair(int a, int b) {
//         idx = a;
//         val = b;
//       }
//     }

//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         ArrayList<edge> gph[]=new ArrayList[n];
//         int i=0;
//         for(int[] x:flights){
//             gph[i]=new ArrayList<>();
//             gph[i].add(new edge(x[0], x[1], x[2]));
//             i++;
//         }
//         boolean visited[]=new boolean[n];

//         int dist[]=new int[n];
//         PriorityQueue<pair> pq=new PriorityQueue<>( (a,b)->a.val-b.val);
//         int ans =Integer.MAX_VALUE;

//         pq.add(new pair(src, 0));
//         for (int j = 0; j < n; j++) {
//             if(j!=src)dist[j]=Integer.MAX_VALUE;
//         }

//         while (!pq.isEmpty()) {
//             pair curr=pq.poll();
//             if( !visited[curr.idx]){
//                 visited[curr.idx]=true;
//                 for (int j = 0; j < gph[curr.idx].size(); j++) {
//                     edge e=gph[curr.idx].get(j);
//                     int d=e.wt;
//                     int v=e.dest;
//                     int u=e.src; 
//                    if(dist[u]!=Integer.MAX_VALUE &&  dist[u]+d<dist[v] ){
//                     dist[v]=dist[u]+d;
//                     pq.add(new pair(v, dist[v]));
//                     k--;
//                    }
//                    if(v==dst && k>=0)ans=Math.max(ans, dist[v]); 
//                 }
//             }
//         }
//         return ans==Integer.MAX_VALUE?-1:ans;
//     }


//     public static void main(String[] args) {





        
//     }
    
// }
import java.util.*;

public class Solution {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    @SuppressWarnings("unchecked")
    public static int findCheapestPrice(int n,int flights[][] , int src, int dest, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Info> q=new PriorityQueue<>((a,b)->a.cost-b.cost);

        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int V = e.dest;
                int W = e.wt;
                if (curr.cost + W < dist[V] && curr.stop <= k) {
                    dist[V] = curr.cost + W;
                    q.add(new Info(V, dist[V], curr.stop + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }
}
