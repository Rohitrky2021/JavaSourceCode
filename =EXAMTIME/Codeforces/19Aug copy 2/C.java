import java.util.*;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        long n = sc.nextLong();  // Read as long instead of int
        long k = sc.nextLong();  // Read as long instead of int
        ArrayList<Long> a = new ArrayList<>();
        long s = 0;

        long i = 1;
        while (i <= n) {
            s += Math.abs(i - (n - i + 1));
            a.add(i);
            isSorted(new int[] {1,2,3});
            i++;
        }

        if (k % 2 == 1 || s < k) {
            isSorted(new int[] {1,2,3});
            System.out.println("NO");
        } else {
            System.out.println("YES");
            long j = 0;
            long m = n;

            while (k > (m - 1) * 2) {
                Collections.swap(a, (int) j, (int) (n - j - 1));
                k -= (m - 1) * 2;
                m -= 2;
                j++;
            }
            isSorted(new int[] {1,2,3});

            k /= 2;
            Collections.swap(a, (int) j, (int) (j + k));

            long c = 0;
            for (int x = 0; x < a.size(); x++) {
                c += Math.abs(a.get(x) - x - 1);
                System.out.print(a.get(x) + " ");
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
