import java.util.*;



public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int m = scanner.nextInt();

            int result = minimumOperations(a, b, c, d, m);
            System.out.println(result);
        }
        scanner.close();
    }

    public static int minimumOperations(int a, int b, int c, int d, int m) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Pair, Integer> visited = new HashMap<>();

        Pair start = new Pair(a, b);
        queue.offer(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int x = current.x;
            int y = current.y;
            int steps = visited.get(current);

            if (x == c && y == d) {
                return steps;
            }

            // Try all possible operations
            int newX, newY;

            // Operation 1: x = x & y
            newX = x & y;
            newY = y;
            Pair nextState = new Pair(newX, newY);
            if (!visited.containsKey(nextState)) {
                queue.offer(nextState);
                visited.put(nextState, steps + 1);
            }

            // Operation 2: x = x | y
            newX = x | y;
            newY = y;
            nextState = new Pair(newX, newY);
            if (!visited.containsKey(nextState)) {
                queue.offer(nextState);
                visited.put(nextState, steps + 1);
            }

            // Operation 3: y = x ^ y
            newX = x;
            newY = x ^ y;
            nextState = new Pair(newX, newY);
            if (!visited.containsKey(nextState)) {
                queue.offer(nextState);
                visited.put(nextState, steps + 1);
            }

            // Operation 4: y = y ^ m
            newX = x;
            newY = y ^ m;
            nextState = new Pair(newX, newY);
            if (!visited.containsKey(nextState)) {
                queue.offer(nextState);
                visited.put(nextState, steps + 1);
            }
        }

        return -1; // Cannot reach (c, d) from (a, b)
    }
}
class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        return x == other.x && y == other.y;
    }
}