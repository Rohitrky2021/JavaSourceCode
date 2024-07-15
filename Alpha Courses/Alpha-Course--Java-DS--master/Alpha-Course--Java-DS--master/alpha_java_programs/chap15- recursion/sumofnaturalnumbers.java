//WAP to print sum of first "n" natural numbers
public class sumofnaturalnumbers {
    public static int calcSum(int n) {
        if(n == 1) {
            return 1;
        }
        int snm1 = calcSum(n-1);
        int sn = n + snm1;
        return sn;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(calcSum(n));
    }
}
/*
 * Explanation:
 * in this snm1 means sum of n minus 1
 * and
 * sn means sum of b
 */