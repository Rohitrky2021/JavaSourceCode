import java.io.*;
import java.util.*;
import java.util.stream.*;

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine().trim());
            List<Set<Integer>> tree = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                tree.add(new HashSet<>());
            }

            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                st.nextToken();  // Ignore the character on the edge
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            String s = br.readLine();
            int m = s.length();

            int[][] dp = new int[n][m];
            int[] result = new int[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[j][i] = (s.charAt(i) == (char) ('a' + j)) ? i : -1;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int max1 = -1;
                        int max2 = -1;

                        for (int k : tree.get(j)) {
                            max1 = Math.max(max1, dp[i][0] + result[k]);
                            max2 = Math.max(max2, dp[i][0] + dp[k][0] + 1);
                        }

                        for (int k = 1; k < m; k++) {
                            dp[j][k] = Math.max(dp[j][k], dp[i][k - 1] + 1);

                            for (int x : tree.get(j)) {
                                max1 = Math.max(max1, dp[i][k] + result[x]);
                                max2 = Math.max(max2, dp[i][k] + dp[x][k] + 1);
                            }

                            dp[j][k] = Math.max(dp[j][k], max2);
                            max2 = -1;
                        }

                        result[j] = Math.max(result[j], max1);
                    }
                }
            }

            int maxGoodies = 0;
            for (int i = 0; i < n; i++) {
                maxGoodies = Math.max(maxGoodies, result[i]);
            }

            System.out.println(maxGoodies);
        }
    }
}
