//WAP to find factorial of n using recursion
public class factorialofn {
    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n * fact(n-1);
        return fn;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(5));
    }
}
/*
 * Explanation:
 * in this prog,
 * fnm1 means factorial of "n" minus "1"
 * fn means factorial of "n"
 */