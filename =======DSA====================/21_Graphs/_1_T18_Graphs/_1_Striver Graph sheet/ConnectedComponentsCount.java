/*
    Time Complexity : O(N^2) ||  Space Complexity : O(N)
     Where 'N' is the number of cities.
*/
public class usingBFS {
    public static int findNumOfProvinces(int[][] roads, int n) {
        int[] visited = new int[n];
        int count = 0;
        Queue<Integer> bfsQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // If city 'i' is unvisited then mark all cities connected to it as visited using BFS traversal.
            if (visited[i] == 0) {
                visited[i] = 1;
                bfsQ.add(i);
                while (!bfsQ.isEmpty()) {
                    int v = bfsQ.poll();
                    for (int j = 0; j < n; j++) {
                        if (roads[v][j] != 0 && visited[j] == 0) {
                            visited[j] = 1;
                            bfsQ.add(j);
                        }
                    }
                }
                // Increase 'COUNT' for each BFS traversal.
                count++;
            }
        }
        return count;
    }
}
/*
    Time Complexity : O(N^2) ||  Space Complexity : O(N)
    Where 'N' is the number of cities.
*/
public class usingDFS {
    public static int findNumOfProvinces(int[][] roads, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            // If city 'i' is unvisited then mark all cities connected to it as visited using DFS traversal.
            if (!visited[i]) {
                dfs(i, n, roads, visited);
                // Increase 'COUNT' for each DFS traversal
                count++;
            }
        }
        return count;
    }
    public static void dfs(int p, int n, int[][] roads, boolean[] visited) {
        visited[p] = true;

        for (int i = 0; i < n; i++) {
            if (roads[p][i] == 1 && !visited[i]) {
                dfs(i, n, roads, visited);
            }
        }
    }
}

// Leetcode SOlutions 

// https://leetcode.com/problems/number-of-provinces/

 


// M1 --> SAMe As DFS LOGIC 
class Solution1 {
    public int findCircleNum(int[][] g) {
        int V = g.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (g[i][j] == 1) {
                    adj.get(i).add(j); // Add edge (i, j) to the adjacency list
                }
            }
        }

        // write your code here
        boolean[] visited = new boolean[V];
        int count = 0; // Counter for the number of connected components

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(adj, v, visited);
                count++;  /// Minimum jitna loop chlega utna he bus  --> Jub Not Visited Next Component aayega 
            }
        }

        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        visited[src] = true;
        for (int neighbor : adj.get(src)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}


// M2 SAme as ABove just direct 2D graph is used ; 

class Solution2 {
    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}

// M ==> 3 SAme Logic just using an BFS approach 

class Solution {
    public void bfs(int node, int[][] isConnected, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                bfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}

//  M3 USing DSU 

// Time complexity: O(n^2)  || Space complexity: O(N)
class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        int numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    numberOfComponents--;
                    dsu.union_set(i, j);
                }
            }
        }

        return numberOfComponents;
    }
}
