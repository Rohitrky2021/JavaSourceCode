import java.util.ArrayList;
import java.util.List;

public class D {
    public int maxKDivisibleComponents(int n, int[][] rohedges, int[] rohvalues, int k) {
        int ans = 1;

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : rohedges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[1];

        // Define a recursive function cp
        // The lambda function will take two parameters: u and p
        // In Java, you can use an array to store the result because Java does not allow modifying local variables from within a lambda expression
        cp(0, -1, rohvalues, g, result);

        return result[0] % k;
    }

    // Define a recursive function cp
    private void cp(int u, int p, int[] rohvalues, List<List<Integer>> g, int[] result) {
        long c = rohvalues[u];
        for (int v : g.get(u)) {
            if (v == p)
                continue;
            cp(v, u, rohvalues, g, result);
            c += result[0];
            if (result[0] == 0)
                result[0]++;
        }
        result[0] = (int) (c % k);
    }
}
