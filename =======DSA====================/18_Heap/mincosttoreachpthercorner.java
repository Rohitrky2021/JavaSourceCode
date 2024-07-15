
import java.lang.reflect.Array;
import java.util.*;



class Cell implements Comparable<Cell> {
    int row;
    int col;
    int cost;

    public Cell(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cell other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class mincosttoreachpthercorner{
    public static int minCostPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] minCost = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        // Create a priority queue (min-heap)
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        // Start from the top-left cell
        pq.offer(new Cell(0, 0, grid[0][0]));
        minCost[0][0] = grid[0][0];

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int currRow = cell.row;
            int currCol = cell.col;

            // Check if reached the bottom-right cell
            if (currRow == rows - 1 && currCol == cols - 1) {
                return minCost[currRow][currCol];
            }

            // Explore the neighboring cells
            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                Arrays.sort(dir);
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newCost = Math.max(cell.cost, Math.abs(grid[newRow][newCol] - grid[currRow][currCol]));

                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new Cell(newRow, newCol, newCost));
                    }
                }
            }
        }

        return -1; // No valid path found
    }

    public static void main(String[] args) {
        int[][] grid = {
            {31, 100, 65, 12, 18},
            {10, 13, 47, 157, 6},
            {100, 113, 174, 11, 33},
            {88, 124, 41, 20, 140},
            {99, 32, 111, 41, 20}
        };

        int minCost = minCostPath(grid);
        System.out.println("Minimum cost path: " + minCost);
    }
}

// In the given problem of finding the minimum cost path in a two-dimensional grid, a heap can be helpful to efficiently select the next cell with the minimum cost during the path finding process. Specifically, a priority queue implemented as a min-heap can be used.

// Here's how a heap can be helpful in the problem:

// Initialize a priority queue (min-heap) to store cells based on their costs. The priority queue should prioritize cells with lower costs, ensuring that the cell with the minimum cost is always at the front of the queue.

// Start from the top left cell and add it to the priority queue with its cost as the priority.

// While the priority queue is not empty, do the following:

// Remove the cell with the minimum cost from the priority queue.
// Check if the removed cell is the bottom right cell. If it is, then the minimum cost path has been found.
// Otherwise, iterate through the neighboring cells (above, left, right, below) of the removed cell.
// Calculate the cost to reach each neighboring cell by adding the cost of the removed cell to the cost of the neighboring cell.
// If the calculated cost is lower than the existing cost of the neighboring cell (or the neighboring cell is unvisited), update the cost of the neighboring cell and add it to the priority queue.
// Once the bottom right cell is reached or the priority queue becomes empty, the minimum cost path has been found.

// Using a heap in this manner allows us to always select the cell with the minimum cost, ensuring that we explore the cells with lower costs first. This helps in finding the minimum cost path efficiently without exploring unnecessary cells with higher costs.

// By utilizing the priority queue (min-heap) approach, the algorithm can find the minimum cost path with a time complexity of O(NMlog(N*M)), where N and M represent the number of rows and columns in the grid, respectively.

// I hope this clarifies how a heap can be helpful in solving the given problem.