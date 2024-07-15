import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    // Solved type of Reverse BFS travelser moving from 0-to--->1
    // Distance of the nearest 0 from number 
    // https://leetcode.com/problems/01-matrix/

    public static class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<pair> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (queue.size() > 0) {
            pair rem = queue.remove();

            for (int i = 0; i < 4; i++) {
                int rowdash = rem.x + direc[i][0];
                int coldash = rem.y + direc[i][1];

                if (rowdash >= 0 && coldash >= 0 && rowdash < mat.length && coldash < mat[0].length && mat[rowdash][coldash] < 0) {
                    queue.add(new pair(rowdash, coldash));
                    mat[rowdash][coldash] = mat[rem.x][rem.y] + 1;
                }
            }
        }

        return mat;
    }

    static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                           
}
