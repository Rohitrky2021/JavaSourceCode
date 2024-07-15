
    import java.util.*;

    public class Saq {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            long n = input.nextLong();
            long m = input.nextLong();
            Map<Long, Long> mp = new HashMap<>();
    
            for (int i = 1; i <= n; i++) {
                long x = input.nextLong();
                if (x == 1) {
                    mp.put((long) i, 1L);
                }
            }
    
            List<Long> outDegree = new ArrayList<>(Collections.nCopies((int) (n + 1), 0L));
            List<List<Long>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
    
            for (int i = 1; i < n; i++) {
                long u = input.nextLong();
                long v = input.nextLong();
                adj.get((int) u).add(v);
                outDegree.set((int) u, outDegree.get((int) u) + 1);
            }
    
            Map<Long, Long> leafMap = new HashMap<>();
    
            for (long i = 1; i <= n; i++) {
                if (outDegree.get((int) i) == 0) {
                    leafMap.put(i, 1L);
                }
            }
    
            Queue<Pair<Long, Long>> q = new LinkedList<>();
            List<Long> vis = new ArrayList<>(Collections.nCopies((int) (n + 1), 0L));
    
            if (mp.containsKey(1L)) {
                q.add(new Pair<>(1L, 1L));
            } else {
                q.add(new Pair<>(1L, 0L));
            }
    
            long countRestaurant = 0;
    
            while (!q.isEmpty()) {
                long node = q.peek().getKey();
                long catCount = q.peek().getValue();
                q.poll();
    
                if (catCount > m) {
                    continue;
                }
    
                if (outDegree.get((int) node) == 0 && catCount <= m) {
                    countRestaurant++;
                    continue;
                }
    
                vis.set((int) node, 1L);
    
                for (long it : adj.get((int) node)) {
                    long newNode = it;
                    if (mp.containsKey(newNode)) {
                        q.add(new Pair<>(newNode, catCount + 1));
                        vis.set((int) newNode, 1L);
                    } else {
                        q.add(new Pair<>(newNode, 0L));
                        vis.set((int) newNode, 1L);
                    }
                }
            }
    
            System.out.println(countRestaurant);
        }
    
        static class Pair<A, B> {
            A key;
            B value;
    
            Pair(A key, B value) {
                this.key = key;
                this.value = value;
            }
    
            A getKey() {
                return key;
            }
    
            B getValue() {
                return value;
            }
        }
    }
    