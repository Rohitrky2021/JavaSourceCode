import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc {   // Tested fine
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
                check(i, j, "", board, visited, 0, -1);  // -1 represents no previous direction
            }
        }
        return new ArrayList<>(ans);
    }

    private void check(int i, int j, String str, char[][] board, boolean[][] visited, int prevRow, int prevCol) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] || str.length() >= max)
            return;

        if(prevRow>3)return;    
        // System.out.println(prevRow);

        visited[i][j] = true;
        str += board[i][j];

        if (map.containsKey(str)) {
            ans.add(str);
        }

        // Check in all possible directions, avoiding opposite direction of the previous one
        // check(i - 1, j, str, board, visited, 1, 0); // Up
        check(i + 1, j, str, board, visited,prevRow+1, 0); // Down
        // check(i, j - 1, str, board, visited, 0, 1); // Left
        check(i, j + 1, str, board, visited, prevRow+1, -1); // Right

        str = str.substring(0, str.length() - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        lc solution = new lc();

        // char[][] matrix2 = {
        //         {'a', 'a', 'a'},
        //         {'a', 'a', 'a'}
        // };
        // String[] words2 = {"aaaa"};
        // System.out.println(solution.findWords(matrix2, words2));  // Output: [aaaa]


      char[][] matrix3 = {
                {'c', 'o', 'd', 'g'},
                {'a', 't', 'e', 'r'},
                {'z', 'o', 'p', 's'}
        };
        String[] words3 = {"code", "signal", "coder", "cat", "dog", "top", "spot"};
        System.out.println(solution.findWords(matrix3, words3));  // Output: [dog, top, code]
    }
}
