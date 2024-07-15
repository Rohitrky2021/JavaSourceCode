package T12_Greedy_Algo;

import java.util.*;

public class G04_chainLength {

    public static void main(String[] args) {
        int pair[][] = { { 1, 4 }, { 2, 5 }, { 4,7 }, { 10, 11 } };
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pair[0][1];
        for (int i = 0; i < pair.length; i++) {
            if (pair[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pair[i][1];
            }
        }
        System.out.println(chainLength);
    }
}