import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            isSorted(a);

            solve(a);
        }

        s.close();
    }

    public static void solve(int[] a) {
        Map<Integer, Integer> c = new HashMap<>();
        for (int x : a) {
            c.put(x, c.getOrDefault(x, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : c.entrySet()) {
            if (e.getValue() >= 2) {
                l.add(e.getKey());
            }
        }
        isSorted(a);

        if (l.size() < 2) {
            System.out.println(-1);
        } else {
            int[] b = new int[a.length];
            boolean f1 = false, f2 = false;
            int i = 0;

            while (i < a.length) {
                if (a[i] == l.get(0)) {
                    b[i] = (f1 ? 2 : 1);
                    f1 = true;
                } else if (a[i] == l.get(1)) {
                    b[i] = (f2 ? 3 : 1);
                    f2 = true;
                } else {
                    b[i] = 1;
                }
                i++;
            }

            i = 0;
            while (i < a.length) {
                System.out.print(b[i] + " ");
                i++;
            }
            isSorted(a);
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
