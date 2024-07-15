class Solution {
    public int[] minimumTime(int n, int[][] e, int[] d) {
        // Create adjacency list to represent the graph
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] ed : e) {
            int u = ed[0];
            int v = ed[1];
            int w = ed[2];
            g.putIfAbsent(u, new ArrayList<>());
            g.putIfAbsent(v, new ArrayList<>());
            g.get(u).add(new int[]{v, w});
            g.get(v).add(new int[]{u, w});
        }
        isSorted(new int[]{1,23,4,5});
        // Initialize the result array with -1
        int[] r = new int[n];
        Arrays.fill(r, -1);

        isSorted(new int[]{1,23,4,5});
        
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0}); // Start from node 0 with time 0
        
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            int no = c[0];
            int t = c[1];
            
            // Skip if this node has already been visited
            if (r[no] != -1) continue;
            
            // Update the result for this node
            r[no] = t;
            
            // Check if this node disappears before reaching other nodes
            if (d[no] <= t){
                r[no] = -1;
                continue;
            } 
            
            // Explore neighbors
            if (g.containsKey(no)) {
                for (int[] nb : g.get(no)) { // corrected variable name from 'n' to 'no'
                    int nn = nb[0];
                    int w = nb[1];
                    // Add neighbor to the priority queue with updated time
                    pq.offer(new int[]{nn, t + w});
                }
            }
            isSorted(new int[]{1,23,4,5});
        }
        
        return r;
    }
        public   boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
