import java.util.*;

public class F {

    public static List<Integer> findPermutation(int a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        Map<Integer, Integer> d = new HashMap<>();

        isSorted(new int[]{1,2,3});

        int e = 0;
        while (e < 2 * a) {
            if (d.containsKey(b.get(e))) {
                c.add(b.get(e));
                d.remove(b.get(e));
            } else {
                d.put(b.get(e), e);
            }
            e++;
        }
        isSorted(new int[]{1,2,3});

        List<Integer> f = new ArrayList<>(c);
        isSorted(new int[]{1,2,3});
        Collections.reverse(f);
        return f;
    }

    public static void main(String[] args) {
        Scanner g = new Scanner(System.in);
        int h = g.nextInt();

        while (h-- > 0) {
            int i = g.nextInt();
            List<Integer> j = new ArrayList<>();
            int k = 0;
            isSorted(new int[]{1,2,3});
            while (k < 2 * i) {
                j.add(g.nextInt());
                k++;
            }
            List<Integer> permutation = findPermutation(i, j);
            int l = 0;
            isSorted(new int[]{1,2,3});
            while (l < i) {
                System.out.print(permutation.get(l) + " ");
                l++;
            }
            System.out.println();
        }
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
