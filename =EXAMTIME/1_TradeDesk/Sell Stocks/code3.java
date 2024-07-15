import java.util.*;

public class code3 {
    public static void main(String[] args) {
        ArrayList<Integer> r = new ArrayList<>(List.of(2, 4, 1, 5, 10, 6));
        ArrayList<Integer> s = new ArrayList<>(List.of(-1, 1, 0, 1, -1, 0));
        int k = 4;

        long pr = sol(r, s, k);

        System.out.println("Maximum profit: " + pr);
    }

    public static long calc(ArrayList<Integer> r, ArrayList<Integer> s) {
        long bp = 0;
        long tp = 0;

        for (int i = 0; i < s.size(); ++i) {
            if (s.get(i) == -1) {
                bp += r.get(i);
            } else if (s.get(i) == 1) {
                tp += r.get(i) - bp;
                bp = 0;
            }
        }

        return tp;
    }

    public static long sol(ArrayList<Integer> r, ArrayList<Integer> s, int k) {
        int n = r.size();
        long mp = Long.MIN_VALUE;

        for (int i = 0; i <= n - k; ++i) {
            ArrayList<Integer> cs = new ArrayList<>(s);
            for (int j = 0; j < k / 2; ++j) {
                cs.set(i + j, 0);
                cs.set(i + k / 2 + j, 1);
            }

            long pr = calc(r, cs);
            mp = Math.max(mp, pr);
            System.out.println(mp+" p");
        }

        return mp;
    }
}
