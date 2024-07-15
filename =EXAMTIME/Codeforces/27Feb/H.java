import java.util.*;

public class H {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();

            // Initialize grid and counts
            boolean[][] grid = new boolean[n][m];
            int[] rowCounts = new int[n];
            int[] colCounts = new int[m];
            int[] diag1Counts = new int[n + m - 1];
            int[] diag2Counts = new int[n + m - 1];
            int totalWays = countWays(grid, rowCounts, colCounts, diag1Counts, diag2Counts, n, m);

            System.out.println(totalWays);

            for (int j = 0; j < q; j++) {
                int r = scanner.nextInt() - 1;
                int c = scanner.nextInt() - 1;
                String shape = scanner.next();

                // Update grid and counts
                if (shape.equals("circle"))
                    grid[r][c] = true;
                else
                    grid[r][c] = false;

                rowCounts[r] = countRow(grid, r);
                colCounts[c] = countCol(grid, c);
                diag1Counts[r - c + m - 1] = countDiag1(grid, r, c);
                diag2Counts[r + c] = countDiag2(grid, r, c);

                totalWays = countWays(grid, rowCounts, colCounts, diag1Counts, diag2Counts, n, m);
                System.out.println(totalWays);
            }
        }
    }

    static int countRow(boolean[][] grid, int r) {
        int count = 0;
        for (boolean cell : grid[r]) {
            if (cell)
                count++;
        }
        return count;
    }

    static int countCol(boolean[][] grid, int c) {
        int count = 0;
        for (boolean[] row : grid) {
            if (row[c])
                count++;
        }
        return count;
    }

    static int countDiag1(boolean[][] grid, int r, int c) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int min = Math.min(r, c);
        int startRow = r - min;
        int startCol = c - min;
        while (startRow < n && startCol < m) {
            if (grid[startRow][startCol])
                count++;
            startRow++;
            startCol++;
        }
        return count;
    }

    static int countDiag2(boolean[][] grid, int r, int c) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int min = Math.min(r, m - 1 - c);
        int startRow = r - min;
        int startCol = c + min;
        while (startRow < n && startCol >= 0) {
            if (grid[startRow][startCol])
                count++;
            startRow++;
            startCol--;
        }
        return count;
    }

    static int countWays(boolean[][] grid, int[] rowCounts, int[] colCounts, int[] diag1Counts, int[] diag2Counts, int n, int m) {
        int totalWays = 1;
        for (int i = 0; i < n; i++) {
            totalWays = (int) ((totalWays * (m - rowCounts[i])) % MOD);
        }
        for (int i = 0; i < m; i++) {
            totalWays = (int) ((totalWays * (n - colCounts[i])) % MOD);
        }
        for (int i = 0; i < n + m - 1; i++) {
            totalWays = (int) ((totalWays * (2 - diag1Counts[i])) % MOD);
        }
        for (int i = 0; i < n + m - 1; i++) {
            totalWays = (int) ((totalWays * (2 - diag2Counts[i])) % MOD);
        }
        return totalWays;
    }
}
