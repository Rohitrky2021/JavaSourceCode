import java.util.*;

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // Create adjacency list to represent the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new int[]{v, weight});
            graph.get(v).add(new int[]{u, weight});
        }
        
        // Initialize the result array with -1
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0}); // Start from node 0 with time 0
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            
            // Skip if this node has already been visited
            if (result[node] != -1) continue;
            
            // Update the result for this node
            result[node] = time;
            
            // // Check if this node disappears before reaching other nodes
            // if (disappear[node] <= time){
            //     result[node] = -1;
            //     continue;
            // } 
            
            // Explore neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    // Add neighbor to the priority queue with updated time
                    pq.offer(new int[]{nextNode, time + weight});
                }
            }
        }
        
        return result;
    }
}


public class C {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0,1,2},{1,2,1},{0,2,4}};
        int[] disappear1 = {1,1,5};
        int[] result1 = solution.minimumTime(n1, edges1, disappear1);
        System.out.println("Example 1: " + Arrays.toString(result1)); // Expected: [0,-1,4]
        
        // Example 2
        int n2 = 3;
        int[][] edges2 = {{0,1,2},{1,2,1},{0,2,4}};
        int[] disappear2 = {1,3,5};
        int[] result2 = solution.minimumTime(n2, edges2, disappear2);
        System.out.println("Example 2: " + Arrays.toString(result2)); // Expected: [0,2,3]
        
        // Example 3
        int n3 = 2;
        int[][] edges3 = {{0,1,1}};
        int[] disappear3 = {1,1};
        int[] result3 = solution.minimumTime(n3, edges3, disappear3);
        System.out.println("Example 3: " + Arrays.toString(result3)); // Expected: [0,-1]
    }
}
