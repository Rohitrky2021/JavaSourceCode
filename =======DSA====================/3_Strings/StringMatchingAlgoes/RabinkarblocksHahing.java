 
import java.util.*;
import java.io.*;

public class MaRabinkarblocksHahingin {
    static final long M1 = 1000000007;
    static final long M2 = 998244353;
    static final int N = (int) 1e5 + 3;
    static final double PI = Math.acos(-1.0);
    static final int prime = 119;
    static final int inf = 0x3f3f3f3f;
    static final long INF = 0x3f3f3f3f3f3f3f3fL;

    static long calculateMex(Set<Long> set) {
        long mex = 0;
        while (set.contains(mex)) {
            mex++;
        }
        return mex;
    }

    static long createHashValue(String str, int n) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) (str.charAt(i) * ((long) (Math.pow(prime, i))));
        }
        return result;
    }

    static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patLength) {
 long newHash = (long) ((oldHash - str.charAt(oldIndex)) / prime  + (long) (str.charAt(newIndex) * Math.pow(prime, patLength - 1)));
        return newHash;
    }

    static boolean checkEqual(String str1, String str2, int start1, int end1, int start2, int end2) {
        if (end2 - start2 != end1 - start1) {
            return false;
        }
        while (start1 <= end1 && start2 <= end2) {
            if (str1.charAt(start1) != str2.charAt(start2)) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String pt = scanner.next();
        int n = s.length();
        int p = pt.length();
        long patHash = createHashValue(pt, p);
        long strHash = createHashValue(s, p);
        int count = 0;
        for (int i = 0; i <= n - p; i++) {
            if (patHash == strHash && checkEqual(s, pt, i, i + p - 1, 0, p - 1)) {
                count++;
                System.out.println(i + 1);
            }
            if (i < n - p) {
                strHash = recalculateHash(s, i, i + p, strHash, p);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        // t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }
}
