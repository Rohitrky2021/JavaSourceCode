import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet {
    private HashMap<String, Integer> map = new HashMap<>();
    private Set<String> ans = new HashSet<>();
    private int max = -1;

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 1);
            max = Math.max(max, words[i].length());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[i].length];
                check(i, j, "", board, visited);
            }
        }
        return new ArrayList<>(ans);
    }

    private void check(int i, int j, String str, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] || str.length() >= max)
            return;

        visited[i][j] = true;
        str += board[i][j];

        if (map.containsKey(str)) {
            ans.add(str);
        }

        // check(i - 1, j, str, board, visited);
        check(i + 1, j, str, board, visited);
        // check(i, j - 1, str, board, visited);
        check(i, j + 1, str, board, visited);

        str = str.substring(0, str.length() - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        leet solution = new leet();

        char[][] matrix1 = {
                {'a', 'b', 'a', 'c'},
                {'x', 'a', 'c', 'd'},
                {'y', 'r', 'd', 's'}
        };
        String[] words1 = {"ac", "cat", "car", "bar", "acdc", "abacaba"};
        System.out.println(solution.findWords(matrix1, words1));  // Output: [ac, acdc, car, abacaba]

        // char[][] matrix2 = {
        //         {'a', 'a', 'a'},
        //         {'a', 'a', 'a'}
        // };
        // String[] words2 = {"aaaa"};
        // System.out.println(solution.findWords(matrix2, words2));  // Output: [aaaa]

        // char[][] matrix3 = {
        //         {'c', 'o', 'd', 'g'},
        //         {'a', 't', 'e', 'r'},
        //         {'z', 'o', 'p', 's'}
        // };
        // String[] words3 = {"code", "signal", "coder", "cat", "dog", "top", "spot"};
        // System.out.println(solution.findWords(matrix3, words3));  // Output: [dog, top, code]
    
    }
}
