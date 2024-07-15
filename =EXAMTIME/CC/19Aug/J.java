import java.util.HashSet;
import java.util.Set;
public class J {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };
        
        int n = 4; // Number of rows
        int m = 5; // Number of columns
        
        int result = Solution.distinctIsland(arr, n, m);
        
        System.out.println("Number of distinct islands: " + result);
    }
}


class Solution {

    // Direction arrays for movement
    static int row[] = { 0, -1, 0, 1 };
    static int col[] = { -1, 0, 1, 0 };

    // Depth First Search (DFS) to traverse and collect island configuration
    private static String DFS(int[][] arr, int r, int c, StringBuilder s, char ch, int n, int m) {
        // Marking island as visited
        arr[r][c] = 0;

        // Append the current state or direction for coding
        s.append(ch);

        // Search in 4 directions for 1s
        char[] sDir = new char[] { 'l', 'u', 'r', 'd' };
        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            // Make sure children are valid before traversing
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] == 0) {
                continue;
            }

            // Recursive DFS traversal
            DFS(arr, nr, nc, s, sDir[i], n, m);
            s.append('b'); // Need to record the backtracking step.
        }

        System.out.println(s.toString());

        return s.toString();
    }

    // Function to find the number of distinct islands
    public static int distinctIsland(int[][] arr, int n, int m) {
        Set<String> set = new HashSet<>();

        // Traverse the grid
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {

                    // Initialize StringBuilder to store island path
                    StringBuilder s = new StringBuilder();

                    // Add the path of DFS in set
                    set.add(DFS(arr, i, j, s, 's', n, m));
                }
            }
        }

        return set.size(); // Return the count of distinct islands
    }
}
