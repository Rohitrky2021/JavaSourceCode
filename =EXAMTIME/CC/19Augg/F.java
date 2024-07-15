import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class F {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            DSU dsu = new DSU(n);

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                dsu.union(u, v);
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
            Map<Integer, Integer> sz = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = dsu.find(i);
                mp.putIfAbsent(x, new HashMap<>());
                mp.get(x).put(a[i], mp.get(x).getOrDefault(a[i], 0) + 1);
                sz.put(x, sz.getOrDefault(x, 0) + 1);
            }

            long ans = 1;

            for (Entry<Integer, Map<Integer, Integer>> entry : mp.entrySet()) {
                for (Entry<Integer, Integer> subEntry : entry.getValue().entrySet()) {
                    ans = (ans * factorial(subEntry.getValue())) % MOD;
                }
            }

            ans = (ans * factorial(n)) % MOD;

            for (int value : sz.values()) {
                ans = (ans * inverseFactorial(value)) % MOD;
            }

            System.out.println(ans);
        }
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    static long inverseFactorial(int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result = (result * i) % MOD;
        }
        return result;
    }

    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}
