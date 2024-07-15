import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

// Can also used to divide array in SUM/2---

public class indian_coin {
    public static void main(String arg[]) {
        Integer coin[] = { 2000, 500,200, 50, 100, 10, 20, 5, 2, 1 };
        // Collections.sort(coin,Collections.reverseOrder());
        Arrays.sort(coin, (a, b) -> {
            return b - a;
        });

        // int value=1000;
        int notes = 0;
        int newval = 39;
        // Arrays.reverseOrde
        for (int j = 0; j < coin.length; j++) {
            // System.out.println(coin[coin.length-j-1]);
            if (coin[j] <= newval) {
                while (coin[j] <= newval) {
                    notes++;
                    newval = newval - coin[j];// arraylist add ans.add coin can also be used
                    System.out.print(coin[j] + " ");
                }

            }
        }
        System.out.println();
        System.out.println(" the notes required are :" + notes);
        // for
    }
}
