//WAP to find the factorial of a number
public class factorialofnumber {
    public static int factorial(int n) {
        int f=1; //1 is the starting value
        for(int i=1;i<=n;i++) {
            f=f*i;
        }
        return f; //factorial of n
    }
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
