import java.util.*;

public class D {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int tes = sc.nextInt();
        for (int fuck = 1; fuck <= tes; fuck++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            long gcd = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                gcd = gcd((long) a[i], gcd);
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            
            if (map.getOrDefault((int) gcd, 0) > 1) {
                System.out.println("NO");
                continue;
            }
            
            System.out.println("YES");
        }
        sc.close();
    }

    // Method to calculate the Greatest Common Divisor (GCD)
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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
