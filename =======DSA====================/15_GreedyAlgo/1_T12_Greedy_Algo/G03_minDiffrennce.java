package T12_Greedy_Algo;

import java.util.Arrays;

public class G03_minDiffrennce {
    public static void main(String[] args) {
        int a[] = { 1, 4, 2, 5, 6 };
        int b[] = { 3, 1, 4, 6, 3 };
        Arrays.sort(a);
        Arrays.sort(b);
        int minDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }
        System.out.println(minDiff);
    }
}
