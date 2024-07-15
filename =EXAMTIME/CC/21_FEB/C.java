import java.util.Scanner;

class C {
    static final int M = 1000000007;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int c = 0;
            int p = 0;
            int i = 31;
            while (i >= 0) {
                if ((n & (1L << i)) != 0) {
                    if (p == 0) {
                        p = i;
                    }
                    if (c == 0 || c == 2) {
                        c++;
                    }
                } else {
                    if (c == 1) {
                        c = 2;
                    }
                }
                 
                i--;
            }
            if (c != 3) {
                System.out.println(0);
                continue;
            }
             
            int cur = 0;
            int ans = (int) 1e18;
            i = p;
             
            while (i >= 0) {
                cur += Math.pow(2, i);
                if (cur < n) {
                    i--;
                    continue;
                }
                ans = Math.min(ans, cur - n);
                i--;
                 
            }
            System.out.println(ans);
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
