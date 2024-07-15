import java.util.*;
import java.io.*;

class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                String[] edge = br.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                adj.get(u).add(v);
            }

            int[] inDegree = new int[n + 1];
            for (int u = 1; u <= n; u++) {
                for (int v : adj.get(u)) {
                    inDegree[v]++;
                }
            }

            long[] ans = new long[n + 1];
            for (int u = 1; u <= n; u++) {
                if (inDegree[u] == 0) {
                    dfs(u, adj, inDegree, ans);
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                result.append(ans[i]).append(" ");
            }
            System.out.println(result.toString().trim());
        }
    }

    static void dfs(int u, List<List<Integer>> adj, int[] inDegree, long[] ans) {
        ans[u] = 1;
        for (int v : adj.get(u)) {
            ans[v] += ans[u];
            inDegree[v]--;
            if (inDegree[v] == 0) {
                dfs(v, adj, inDegree, ans);
            }
        }
    }
}
