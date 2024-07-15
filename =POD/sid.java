import java.util.ArrayList;
import java.util.List;

public class sid {
    public static List<Integer> getNumPoints(int[] layers, int[] energy, int k) {
        List<Integer> res = new ArrayList<>();
        int n = layers.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = layers[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + layers[i];
        }

        for (int i = 0; i < n; i++) {
            int remaining = k;
            int score = 0;

            for (int j = i; j < n; j++) {
                int consumed = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                remaining -= consumed;

                if (remaining >= energy[j]) {
                    score += 1;
                }

                if (remaining <= 0) {
                    break;
                }
            }

            res.add(score);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] layers = {5, 8, 1};
        int[] energy = {4, 2, 1};
        int k = 10;

        List<Integer> result = getNumPoints(layers, energy, k);

        System.out.println(result);
    }
}
