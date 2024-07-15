 
import java.util.ArrayList;
import java.util.List;

public class AWS_Scalable_system {
    public static long makePowerNondecreasing(List<Integer> power) {
        int n = power.size();
        long adjustments = 0;

        for (int i = 1; i < n; ++i) {
            if (power.get(i) < power.get(i - 1)) {
                adjustments += power.get(i - 1) - power.get(i);
            }
        }

        return adjustments;
    }

    public static void main(String[] args) {
        List<Integer> power = new ArrayList<>();
        power.add(3);
        power.add(4);
        power.add(1);
        power.add(6);
        power.add(2);

        System.out.println(makePowerNondecreasing(power));
    }


    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}


// #include (tg://search_hashtag?hashtag=include) <iostream>
// #include (tg://search_hashtag?hashtag=include) <vector>

// using namespace std;

// long makePowerNondecreasing(vector<int>& power) {
//     int n = power.size();
//     long adjustments = 0;

//     for (int i = 1; i < n; ++i) {
//         if (power[i] < power[i - 1]) {
//             adjustments += power[i - 1] - power[i];
//         }
//     }

//     return adjustments;
// }

// Amazon ✅