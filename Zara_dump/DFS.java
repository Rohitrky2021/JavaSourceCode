import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<Integer> ls = new ArrayList<>();
    static boolean[] vis;

    public static void dfs(int node, ArrayList<Integer>[] adj,List<Boolean> hasApple,int ans) {
        vis[node] = true;
        if(hasApple.get(node))ls.add(node);
        

        for (int it : adj[node]) { // Iterate over neighbors of 'node'
            if (!vis[it]) {
                if(ans==count)break;
                dfs(it, adj,hasApple,ans+1);
            }
        }
    }

    static int count=0;

    public static ArrayList<Integer> dfsOfGraph(int n, ArrayList<Integer>[] adj,List<Boolean> hasApple) {
        vis = new boolean[n];
        int ans = 0;
        
        for(boolean x:hasApple){
            if(x)count++;
        }
        dfs(0, adj,hasApple,ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 7; // Number of vertices
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Example edges
        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(4);
        adj[1].add(5);
        adj[2].add(3);
        adj[2].add(6);

        ArrayList<Integer> result = dfsOfGraph(n, adj);
        System.out.println("DFS Traversal: " + result);
    }
}
