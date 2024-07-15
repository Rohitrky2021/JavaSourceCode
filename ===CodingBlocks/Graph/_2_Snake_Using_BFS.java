 
import java.util.*;

class Graph<T> {

    private Map<T, List<T>> l;

    public Graph() {
        l = new HashMap<>();
    }

    public void addEdge(T x, T y) {
        l.computeIfAbsent(x, k -> new ArrayList<>()).add(y); // the snake ladder is not bidirectional so i
    // l.computeIfAbsent(y, k -> new ArrayList<>()).add(x); ==-->//we remove the other line easy ways 
    }

    public int bfs(T src, T dest) {
        Queue<T> q = new LinkedList<>();
        q.offer(src);

        Map<T, Integer> dist = new HashMap<>();
        Map<T, T> parentOf = new HashMap<>();

        // All other nodes will have inf dist
        for (T key : l.keySet()) {
            dist.put(key, Integer.MAX_VALUE);
        }
        // Dist of src from src = 0
        dist.put(src, 0);
        parentOf.put(src, src);

        while (!q.isEmpty()) {
            T curr = q.poll();

            // Push all neighbours of curr
            List<T> neighbours = l.get(curr);
            if (neighbours != null) {
                for (T nbr : neighbours) {
                    if (dist.get(nbr) == Integer.MAX_VALUE) {
                        q.offer(nbr);
                        dist.put(nbr, dist.get(curr) + 1);
                        parentOf.put(nbr, curr);
                    }
                }
            }
        }

        // Print dist to every node
        for (Map.Entry<T, Integer> entry : dist.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Print shortest path
        T curr = dest;
        while (!curr.equals(src)) {
            System.out.print(curr + " ");
            curr = parentOf.get(curr);
        }
        System.out.println(curr);

        return dist.get(dest);
    }

    public void printAdjList() {
        for (Map.Entry<T, List<T>> entry : l.entrySet()) {
            System.out.print(entry.getKey() + " => ");
            for (T nbr : entry.getValue()) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }
}

public class _2_Snake_Using_BFS {

    public static int minThrows(int[] board) {
        Graph<Integer> g = new Graph<>();

        for (int i = 0; i < 36; i++) {
            if (board[i] != -1) continue;

            for (int dice = 1; dice <= 6; dice++) {

                if (i + dice > 36) continue;

                if (board[i + dice] == -1) {
                    // There exists no ladder/snake at i+dice
                    g.addEdge(i, i + dice);
                } 
                else {
                    g.addEdge(i, board[i + dice]);
                }
            }
        }

        g.addEdge(36, 36);

        g.printAdjList();

        return g.bfs(0, 36);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] board = new int[37];
        Arrays.fill(board, -1);
        board[2] = 15;
        board[5] = 7;
        board[9] = 27;
        board[18] = 29;
        board[25] = 35;
        board[17] = 4;
        board[34] = 12;
        board[32] = 30;
        board[20] = 6;

        System.out.println(minThrows(board));
    }
}
