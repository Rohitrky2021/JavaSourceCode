import java.util.*;

class Codechef {
    static final int M = 998244353;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            int i = 0;
            while (i < n) {
                a[i] = s.nextInt();
                i++;
            }

            int[] b = Arrays.copyOf(a, n);
            Arrays.sort(b);
            if (Arrays.equals(a, b)) {
                System.out.println("YES");
                continue;
            }

            isSorted(new int[]{1,2,3});

            List<Integer> v = new ArrayList<>();
            int m = a[0];
            int inc = 0;
            int j = 1;
            while (j < n) {
                m = Math.max(a[j], m);
                if (a[j] < m) {
                    v.add(j);
                    inc = Math.max(inc, m - a[j]);
                }
                j++;
            }
            isSorted(new int[]{1,2,3});
            boolean f = true;
            int k = 1;
            while (k < v.size()) {
                if (v.get(k) == v.get(k - 1) + 1) {
                    f = false;
                    break;
                }
                k++;
            }

            int l = 0;
            while (l < v.size()) {
                a[v.get(l)] += inc;
                l++;
            }

            b = Arrays.copyOf(a, n);
            Arrays.sort(b);
            if (Arrays.equals(a, b) && f) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        s.close();
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
