import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static String adityaSamaGymSession(int N, int W, int R, int[] weights) {
        HashSet<Integer> s = new HashSet<>();
        int dupli=0;
        for (int weight : weights) {
            if(s.contains(weight)){
                dupli++;
            }
            s.add(weight);
        }
        

        if (R >= W) {
            return "waku waku";
        }

        Arrays.sort(weights);
        int remainingWeight = W - R;
        int totalWeight = 0;
        int used=0;

        for (int i = N - 1; i >= 0; i -= 2) {
            if (i > 0) {
                int pairWeight = weights[i] + weights[i - 1];
                totalWeight += pairWeight;

                if (totalWeight >= remainingWeight && used <= dupli) {
                    return "waku waku";
                }
                used++;
            }
        }

        if(used <= dupli){
            return "waku waku";
        }

        return "orewa kanashii desu";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input
        int N = scanner.nextInt();  // Number of weights
        int W = scanner.nextInt();  // Minimum required weight
        int R = scanner.nextInt();  // Rod weight
        int[] weights = new int[N]; // Weights array

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }

        // Output result
        System.out.println(adityaSamaGymSession(N, W, R, weights));

        scanner.close();
    }
}
