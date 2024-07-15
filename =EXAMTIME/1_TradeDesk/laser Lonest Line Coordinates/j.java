import java.util.ArrayList;
import java.util.List;

public class j {

    static int findLongestStraightLine(int[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}};

        int maxLength = 0;

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int length = 0;

            int i = row, j = col;
            // nrw>=1 nrw<=numRows and ncl>=1 and ncl<=numColumns
            while (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == grid[row][col]) {
                length++;
                i += dx;
                j += dy;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    static int remainingCells(int n, int m, List<Pair<Integer, Integer>> laserCoordinates, int currow, int curcol) {
        int[][] grid = new int[n][m];

        for (Pair<Integer, Integer> laser : laserCoordinates) {
            int x = laser.first;
            int y = laser.second;

            for (int i = 0; i < n; ++i) {
                grid[i][y - 1] = 0;
            }

            for (int j = 0; j < m; ++j) {
                grid[x - 1][j] = 0;
            }
        }
        int ans = findLongestStraightLine(grid, currow, curcol) - 1;
        if (ans < 0) return 1;
        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 8;
        List<Pair<Integer, Integer>> laserCoordinates = new ArrayList<>();
        laserCoordinates.add(new Pair<>(1, 6));
        laserCoordinates.add(new Pair<>(2, 8));

        int currow = 5;
        int curcol = 3;

        int result = remainingCells(n, m, laserCoordinates, currow, curcol);
        System.out.println("Remaining cells: " + result);
    }

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
