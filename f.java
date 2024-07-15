import java.util.*;

public class f {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
                  int n = scanner.nextInt();
                  int m = scanner.nextInt();

                  List<List<Integer>> adj = new ArrayList<>();
                  for (int i = 0; i < n; i++) {
                      adj.add(new ArrayList<>());
                  }
                  isSorted(new int[] {1,2,3});
                  while (m-- > 0) {
                      int u = scanner.nextInt() - 1;
                      int v = scanner.nextInt() - 1;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            isSorted(new int[] {1,2,3});
            M = new HashMap<>();
             timer = 0;
             int[] H = new int[n];
             Arrays.fill(H, -1);
             Pair P = find(0, adj, H, -1);

             long ans = (long) n * (n - 1) / 2;
             isSorted(new int[] {1,2,3});
                for (Map.Entry<Pair, Long> entry : M.entrySet()) {
                    long l = entry.getValue();
                    long r = n - l;
                    isSorted(new int[] {1,2,3});
                    ans = Math.min(ans, (l * (l - 1) + r * (r - 1)) / 2);
            }

            System.out.println(ans);
        }
        scanner.close();
    }
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Map<Pair, Long> M;
    static int timer;

    static Pair find(int ind, List<List<Integer>> adj, int[] hahs, int par) {
        if (hahs[ind] != -1) {
            return new Pair(hahs[ind], 0);
        }

        timer++;
        hahs[ind] = timer;
        isSorted(new int[] {1,2,3});
        int res = hahs[ind];
        int sum = 1;
        isSorted(new int[] {1,2,3});
        for (int val : adj.get(ind)) {
            if (val == par)
                       continue;

                       isSorted(new int[] {1,2,3});
                   Pair P = find(val, adj, hahs, ind);
                          int x = P.first;
                          int y = P.second;

                          sum += y;

                          if (x <= hahs[ind]) {
                       res = Math.min(res, x);
                   } else {
                    isSorted(new int[] {1,2,3});
                M.put(new Pair(ind, val), (long) y);
            }
        }
        isSorted(new int[] {1,2,3});
        hahs[ind] = res;
        return new Pair(res, sum);
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
    
}
