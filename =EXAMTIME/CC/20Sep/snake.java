
    import java.util.*;

    public class snake {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt(); // Number of test cases
            
            while (t-- > 0) {
                int n = scanner.nextInt(); // Size of the grid
                int q = scanner.nextInt(); // Number of queries
                
                char[][] grid = new char[n][n];
                for (int i = 0; i < n; i++) {
                    String row = scanner.next();
                    grid[i] = row.toCharArray();
                }
                
                for (int query = 0; query < q; query++) {
                    int time = scanner.nextInt(); // Time for the query
                    int danger = calculateMinimumDanger(grid, n, time);
                    System.out.println(danger);
                }
            }
            
            scanner.close();
        }
    
        public static int calculateMinimumDanger(char[][] grid, int n, int time) {
            int[][][] snakeEnds = new int[n][n][4]; // To store the ends of snakes
            
            // Initialize snakeEnds with -1 (indicating no snake at that cell)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(snakeEnds[i][j], -1);
                }
            }
            
            // Initialize the snakes and their ends
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != '.') {
                        int dir = getDirection(grid[i][j]);
                        int x = i;
                        int y = j;
                        while (x >= 0 && x < n && y >= 0 && y < n) {
                            snakeEnds[x][y][dir] = time;
                            x += dx[dir];
                            y += dy[dir];
                        }
                    }
                }
            }
             
        // Helper arrays for movement directions
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};
        
        public static int getDirection(char c) {
            if (c == 'L') return 2;
            if (c == 'R') return 3;
            if (c == 'U') return 0;
            if (c == 'D') return 1;
            return -1; // Invalid character
        }
    }
    