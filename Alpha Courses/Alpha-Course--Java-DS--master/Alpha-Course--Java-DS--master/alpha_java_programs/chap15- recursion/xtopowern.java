//WAP to print x to the powerr n
public class xtopowern {
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }

        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;
    }
    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
