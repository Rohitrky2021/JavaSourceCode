 
import java.util.ArrayList;

public class Chinese_Remainder_Theorem {
    static long chineseRemainderTheorem(ArrayList<Long> num, ArrayList<Long> rem) {
        // Find pp vector
        ArrayList<Long> pp = new ArrayList<>();
        long prod = 1L;

        for (long i : num) {
            prod *= i;
        }

        for (long i : num) {
            pp.add(prod / i);
        }

        // Find inv[] vector
        // inv[i] is modular inverse of pp[i] with respect to num[i]
        ArrayList<Long> inv = new ArrayList<>();
        for (int i = 0; i < pp.size(); ++i) {
            inv.add(modularInverse(pp.get(i), num.get(i) - 2, num.get(i)));
        }

        // Use the sum formula
        long ans = 0L;
        for (int i = 0; i < pp.size(); ++i) {
            ans = (ans % prod + ((rem.get(i) * pp.get(i)) % prod * inv.get(i) % prod) % prod) % prod;
        }

        return ans;
    }

    static long modularInverse(long a, long b, long m) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Long> num = new ArrayList<>();
        ArrayList<Long> rem = new ArrayList<>();

        // Add your values to num and rem ArrayLists
        num.add(3L);
        num.add(5L);
        num.add(7L);

        rem.add(2L);
        rem.add(3L);
        rem.add(2L);

        long result = chineseRemainderTheorem(num, rem);
        System.out.println(result);
    }
}
