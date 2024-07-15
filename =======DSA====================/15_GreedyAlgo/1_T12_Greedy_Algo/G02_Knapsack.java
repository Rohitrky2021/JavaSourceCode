////////********mast revaise and chack */
package T12_Greedy_Algo;
import java.util.*;

public class G02_Knapsack {

    public static void main(String[] args) {
        int weight[] = { 10, 20, 30 };
        int rate[] = { 60, 100, 200 };
        int totalWeight = 50;
        ArrayList<Integer> ans = new ArrayList<>();

        double arr[][] = new double[rate.length][2];
        for (int i = 0; i < rate.length; i++) {
            arr[i][0] = i;
            arr[i][1] = (double) rate[i] / weight[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        for (int i = rate.length - 1; i >= 0; i++) {
            int idx = weight[(int) arr[i][0]];
            
            if (totalWeight >= weight[idx]) {
                totalWeight -= weight[idx];
                ans.add(rate[idx]);
            } else {
                ans.add(weight[idx]);
                break;
            }
        }
        System.out.println(ans);
    }

}