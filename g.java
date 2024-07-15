import java.util.HashSet;
import java.util.Set;

public class g {
    public static int minAreaSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<int[]> ones = new HashSet<>();

        // Collect all the positions of 1s in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    ones.add(new int[]{r, c});
                }
            }
        }

        int minSumArea = Integer.MAX_VALUE;
        int[][][] rectangles = generateRectangles(rows, cols);

        // Check all combinations of 3 rectangles
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                for (int k = j + 1; k < rectangles.length; k++) {
                    if (coversAllOnes(rectangles[i], rectangles[j], rectangles[k], ones, grid)) {
                        int sumArea = area(rectangles[i]) + area(rectangles[j]) + area(rectangles[k]);
                        minSumArea = Math.min(minSumArea, sumArea);
                    }
                }
            }
        }

        return minSumArea;
    }

    private static int[][][] generateRectangles(int rows, int cols) {
        int count = rows * cols * (rows + 1) * (cols + 1) / 4;
        int[][][] rectangles = new int[count][2][2];
        int index = 0;

        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                for (int r2 = r1; r2 < rows; r2++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        rectangles[index++] = new int[][]{{r1, c1}, {r2, c2}};
                    }
                }
            }
        }

        return rectangles;
    }

    private static boolean coversAllOnes(int[][] rect1, int[][] rect2, int[][] rect3, Set<int[]> ones, int[][] grid) {
        Set<String> covered = new HashSet<>();

        for (int[][] rect : new int[][][]{rect1, rect2, rect3}) {
            for (int r = rect[0][0]; r <= rect[1][0]; r++) {
                for (int c = rect[0][1]; c <= rect[1][1]; c++) {
                    if (grid[r][c] == 1) {
                        covered.add(r + "," + c);
                    }
                }
            }
        }

        if (covered.size() != ones.size()) {
            return false;
        }

        for (int[] pos : ones) {
            if (!covered.contains(pos[0] + "," + pos[1])) {
                return false;
            }
        }

        return true;
    }

    private static int area(int[][] rect) {
        return (rect[1][0] - rect[0][0] + 1) * (rect[1][1] - rect[0][1] + 1);
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 0, 1}, {1, 1, 1}};
        int[][] grid2 = {{1, 0, 1, 0}, {0, 1, 0, 1}};

        System.out.println(minAreaSum(grid1));  // Output: 5
        System.out.println(minAreaSum(grid2));  // Output: 5
    }
}
