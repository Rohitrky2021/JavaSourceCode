import java.util.*;

public class code {

    public static void solve(List<Long> a, long l, long r) {
        Set<Pair<Long, Long>> s = new HashSet<>();
        Map<Long, Long> m = new HashMap<>();
        long i = 0;
        long ans = Integer.MAX_VALUE;

        for (long x : a) {
            if (x < l || x > r) {
                i++;
                continue;
            } else {
                if (!m.containsKey(x)) {
                    m.put(x, i);
                    s.add(new Pair<>(i, x));
                } else {
                    s.remove(new Pair<>(m.get(x), x));
                    s.add(new Pair<>(i, x));
                    m.put(x, i);
                }
            }

            if (m.size() == r - l + 1) {
                Pair<Long, Long> firstPair = s.iterator().next();
                ans = Math.min(ans, i - firstPair.getFirst() + 1);
            }
            i++;
        }
        System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));
    }

    public static void main(String[] args) {
        List<Long> a = Arrays.asList(2L, 4L, 1L, 3L, 5L);
        long l = 2;
        long r = 4;

        solve(a, l, r);
    }

    // Pair class for simplicity
    static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}
