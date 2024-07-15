import java.util.LinkedList;
import java.util.Queue;

public class matri {
    public static int getMinJumps(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

        // Find the positions of 'S' and 'E' in the grid
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                if (grid[i].charAt(j) == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        int[][] minJumps = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minJumps[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        minJumps[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                for (int k = 1; k <= n * m; k++) {
                    int newX = x + k * dir[0];
                    int newY = y + k * dir[1];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX].charAt(newY) == 'C') {
                        break; // Stop jumping in this direction if we hit a blocked cell or go out of bounds.
                    }

                    if (minJumps[newX][newY] > minJumps[x][y] + 1) {
                        minJumps[newX][newY] = minJumps[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                    }

                    if (newX == endX && newY == endY) {
                        return minJumps[endX][endY];
                    }
                }
            }
        }

        return -1; // If 'E' cannot be reached from 'S'
    }

    public static void main(String[] args) {
        String[] grid = {
            "S..E..",
            "......",
            "......",
            "......",
            "......",
            "..C...",
        };
        int minJumps = getMinJumps(grid);
        System.out.println("Minimum number of jumps: " + minJumps);
    }
}
