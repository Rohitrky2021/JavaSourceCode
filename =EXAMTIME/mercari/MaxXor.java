public class MaxXor {
    public static void main(String[] args) {
        int result = maxXor(3, 10, 5);
        System.out.println("Max XOR: " + result);
    }

    static int maxXor(int lo, int hi, int k) {
        int max_XOR = 0;
        for (int a = lo; a <= hi; ++a) {
            for (int b = a + 1; b <= hi; ++b) {
                int current_XOR = a ^ b;
                if (current_XOR > max_XOR && current_XOR <= k) {
                    max_XOR = current_XOR;
                }
            }
        }
        return max_XOR;
    }
}



int maxXor(int lo, int hi, int k) {
    int max_XOR = 0;
    for (int a = lo; a <= hi; ++a) {
        for (int b = a + 1; b <= hi; ++b) {
            int current_XOR = a ^ b;
            if (current_XOR > max_XOR && current_XOR <= k) {
                max_XOR = current_XOR;
            }
        }
    }
    return max_XOR;
}
// ercari QS 5
//Bit Logic
 