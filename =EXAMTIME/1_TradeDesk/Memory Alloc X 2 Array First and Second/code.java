import java.util.*;

public class code {
    public static void main(String[] args) {
        List<Integer> memory = Arrays.asList(0,1,0,0,0,1,1,0,0,0,0,0,1,1,1,1);
        List<List<Integer>> queries = Arrays.asList(
                Arrays.asList(0, 2),  // Allocate 3 consecutive zeros
                Arrays.asList(0, 1),  // Deallocate the allocation with id 1
                                Arrays.asList(0, 1),  // Deallocate the allocation with id 1

                Arrays.asList(1, 1),  // Allocate 4 consecutive zeros
                Arrays.asList(0, 3),  // Allocate 2 consecutive zeros
                Arrays.asList(1, 4),   // Deallocate the allocation with id 2
                Arrays.asList(0, 4)  // Deallocate the allocation with id 2

        );

        List<Integer> result = code.solve(memory, queries);

        System.out.println("Memory state after queries: " + memory);
        System.out.println("Result of queries: " + result);
    }

    public static List<Integer> solve(List<Integer> mem, List<List<Integer>> queries) {
        Map<Integer, Pair<Integer, Integer>> alloc = new HashMap<>();
        int id = 1;
        List<Integer> res = new ArrayList<>();

        for (List<Integer> q : queries) {
            if (q.get(0) == 0) {
                int x = q.get(1);
                int start = -1;
                int count = 0;

                for (int i = 0; i < mem.size(); ++i) {
                    if (mem.get(i) == 0) {
                        if (start == -1 && i % 8 == 0) {
                            start = i;
                        }
                        if (start != -1) {
                            ++count;
                        }
                        if (count == x) {
                            break;
                        }
                    } else {
                        start = -1;
                        count = 0;
                    }
                }

                if (count == x) {
                    fill(mem, start, start + x, 1);
                    alloc.put(start, new Pair<>(id, x));
                    res.add(start);
                    ++id;
                } else {
                    res.add(-1);
                }
            } else {
                int eraseId = q.get(1);
                int length = -1;

                for (Iterator<Map.Entry<Integer, Pair<Integer, Integer>>> it = alloc.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Integer, Pair<Integer, Integer>> entry = it.next();
                    if (entry.getValue().getFirst() == eraseId) {
                        fill(mem, entry.getKey(), entry.getKey() + entry.getValue().getSecond(), 0);
                        length = entry.getValue().getSecond();
                        it.remove();
                        break;
                    }
                }

                res.add(length);
            }
        }

        return res;
    }

    private static void fill(List<Integer> list, int fromIndex, int toIndex, int value) {
        for (int i = fromIndex; i < toIndex; i++) {
            list.set(i, value);
        }
    }

    private static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }
}
