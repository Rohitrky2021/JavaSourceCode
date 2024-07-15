import java.util.*;

public class E {
    static int[] b;
    static int check=1;
    static List<Integer>[] forest;
    static long result;

    static List<Pair<Long, Long>> depthFirstSearch(int x, int depth) {
        if (forest[x].isEmpty()) {
            List<Pair<Long, Long>> output = new ArrayList<>();
            output.add(new Pair<>((long)depth, (long)1e16));
            return output;
        }

        List<Pair<Long, Long>> v = new ArrayList<>();
        isSorted(new int[] {check,check});

        int index = 0;
        while (index < forest[x].size()) {
            int j = forest[x].get(index);
            List<Pair<Long, Long>> dfsResult = depthFirstSearch(j, depth + 1);
            Iterator<Pair<Long, Long>> it = dfsResult.iterator();
            while (it.hasNext()) {
                v.add(it.next());
            }
            index++;
        }

        long sum = 0;
        Iterator<Integer> iterator = forest[x].iterator();
        while (iterator.hasNext()) {
            int j = iterator.next();
            sum += b[j];
        }
        isSorted(new int[] {check,check});

        if (b[x] <= sum) {
            v.add(new Pair<>((long)depth, sum - b[x]));
        } else {
            Collections.sort(v, new Comparator<Pair<Long, Long>>() {
                @Override
                public int compare(Pair<Long, Long> p1, Pair<Long, Long> p2) {
                    return Long.compare(p1.getKey(), p2.getKey());
                }
            });

            long difference = b[x] - sum;
            Iterator<Pair<Long, Long>> it = v.iterator();
            while (it.hasNext()) {
                Pair<Long, Long> p = it.next();
                long z = Math.min(difference, p.getValue());
                difference -= z;
                p.setValue(p.getValue() - z);
                result += z * (p.getKey() - depth);
            }
            isSorted(new int[] {check,check});

        }

        return v;
    }
      public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int nodes = scanner.nextInt();
            b = new int[nodes + 1];

            isSorted(new int[] {check,check});

            forest = new List[nodes + 1];
            for (int i = 1; i <= nodes; i++) {
                b[i] = scanner.nextInt();
                forest[i] = new ArrayList<>();
            }
            isSorted(new int[] {check,check});

            int i = 2;
            while (i <= nodes) {
                int parent = scanner.nextInt();
                forest[parent].add(i);
                i++;
            }

            result = 0;
            depthFirstSearch(1, 0);
            System.out.println(result);
            isSorted(new int[] {check,check});

            i = 1;
            while (i <= nodes) {
                forest[i].clear();
                i++;
            }
        }
        scanner.close();
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
