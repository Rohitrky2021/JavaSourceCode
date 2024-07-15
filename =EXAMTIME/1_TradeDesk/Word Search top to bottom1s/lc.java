import java.util.ArrayList;
import java.util.List;

public class lc {
    public static int solveLC(char[][] mat, String[] words) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> res = new ArrayList<>();

        for (String w : words) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : new int[][]{{0, 1}, {1, 0}}) {
                        int di = dir[0];
                        int dj = dir[1];
                        int x = i, y = j;

                        if (w.charAt(0) != mat[x][y]) continue;

                        for (int k = 1; k < w.length(); k++) {
                            x += di;
                            y += dj;

                            if (x < 0 || y < 0 || x == m || y == n) break;

                            if (w.charAt(k) != mat[x][y]) {
                                break;
                            }

                            if (x == m - 1 || y == n - 1) {
                                di = -di;
                                dj = -dj;
                            }
                        }

                        if (x == m - 1 || y == n - 1) {
                            cnt++;
                        }
                    }
                }
            }

            res.add(cnt);
        }

        return res.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 'a', 'c'},
                {'x', 'a', 'c', 'd'},
                {'y', 'r', 'd', 's'}
        };

        String[] words = {"ac", "cat", "car", "bar", "acdc", "abacaba"};

        System.out.println(solveLC(matrix, words));  // Output: 7
    }
}
