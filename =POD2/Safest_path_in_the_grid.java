 /**
   * Approach 1: BFS + PQ + DIJKSTRA'S ALGO
   * calculate the shortest dist. in score[][] using BFS from every enemy -> then check PQ
   * ? Complexity
   ** Time complexity:  O(n^2 * log(n))
   ** Space complexity: O(n^2)
   */

class Solution {
    private int[] roww = {0, 0, -1, 1};
    private int[] coll = {-1, 1, 0, 0};
    private void bfs(List<List<Integer>> grid, int[][] score, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            int s = score[x][y];

            for (int i = 0; i < 4; i++) {
                int newX = x + roww[i];
                int newY = y + coll[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && score[newX][newY] > 1 + s) {
                    score[newX][newY] = 1 + s;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] score = new int[n][n];
        for (int[] row : score) Arrays.fill(row, Integer.MAX_VALUE);

        // Updating the Score matrix 
        bfs(grid, score, n);

        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{score[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int safe = temp[0];
            int i = temp[1], j = temp[2];

            if (i == n - 1 && j == n - 1) return safe;
            vis[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int newX = i + roww[k];
                int newY = j + coll[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !vis[newX][newY]) {
                    int s = Math.min(safe, score[newX][newY]);
                    pq.offer(new int[]{s, newX, newY});
                    vis[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}


  /**
     * Approach 2:  Multi Source BFS + Binary Search
     * calculate the Mahaten  dist. in score[][] using BFS from every enemy --> Then binary  
     * ? Complexity
     ** Time complexity:  O(n^2 * log(n^2))
     ** Space complexity: O(n^2)
     */
    

class Solution {
    
    private int n;
    private int[][] dist, dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private boolean isPossible(int x) {
        Queue<int[]> q = new LinkedList<>();
        if (dist[0][0] < x || dist[n - 1][n - 1] < x)
            return false;
        boolean[][] vis = new boolean[n][n];
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x1 = temp[0], y1 = temp[1];
            if (vis[x1][y1])
                continue;
            vis[x1][y1] = true;
            for (int[] dir : dirs) {
                int x2 = x1 + dir[0], y2 = y1 + dir[1];
                if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && !vis[x2][y2] && dist[x2][y2] >= x)
                    q.offer(new int[] {x2, y2});
            }
        }
        return vis[n - 1][n - 1];
    }
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int res = 0, low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        n = grid.size();
        dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[] {i,  j});
                    dist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x1 = temp[0], y1 = temp[1];
            for (int[] dir : dirs) {
                int x2 = dir[0] + x1, y2 = dir[1] + y1;
                if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && dist[x2][y2] > 1 + dist[x1][y1]) {
                    q.offer(new int[] {x2, y2});
                    dist[x2][y2] = 1 + dist[x1][y1]; 
                }
            } 
        }
        for (int i = 0;  i < n; i++) {
            for (int j = 0; j < n; j++) {
                low = Math.min(low, dist[i][j]);
                high = Math.max(high, dist[i][j]);
            }
        }



        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid)) {
                res = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        
        return res;
    }
}