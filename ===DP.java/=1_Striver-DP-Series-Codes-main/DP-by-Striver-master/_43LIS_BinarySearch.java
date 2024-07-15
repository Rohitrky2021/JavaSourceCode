import java.util.ArrayList;

public class _43LIS_BinarySearch {
    public static void main(String[] a) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        System.out.println("len is "  + size);
    }


}
