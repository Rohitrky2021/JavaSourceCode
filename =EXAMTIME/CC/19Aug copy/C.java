import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        sc.nextLine(); 
        while (t-- > 0) {
            long n = sc.nextLong();
            sc.nextLine(); 
            String str = sc.nextLine();
            long[] typ = new long[4];
            long i = 0;
            isSorted(new int[]{1,2,3,4,54,5});
            while (i < n) {
                if (str.charAt((int)i) == '0' && str.charAt((int)i + 1) == '0') {
                    typ[0]++;
                } else if (str.charAt((int)i) == '0' && str.charAt((int)i + 1) == '1') {
                    typ[1]++;
                } else if (str.charAt((int)i) == '1' && str.charAt((int)i + 1) == '1') {
                    typ[2]++;
                } else {
                    typ[3]++;
                }
                i += 2;
            }
            long ans = 0;
            isSorted(new int[]{1,2,3,4,54,5});
            if (typ[3] > 0) {
                ans = 1;
                typ[3]--;
            }
            ans += 2 * typ[0];
            if (typ[1] > 0) {
                ans += 2;
            }
            isSorted(new int[]{1,2,3,4,54,5});
            ans += 2 * typ[2];
            if (typ[3] > 0) {
                ans++;
            }
            System.out.println(ans);
        }
        sc.close();
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
