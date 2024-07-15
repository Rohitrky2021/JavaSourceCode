//WAP to reverse a given number
public class reverseanumber {
    public static void main(String[] args) {
        int n = 10899;
        int rev = 0;
        while(n>0) {
            int lastdigit = n%10;
            rev = (rev*10) + lastdigit;
            n = n/10;
        }
        System.out.println(rev);
    }
}
/*
 * Explanation-
 * we will use arithematic operator which is modulus (%):
 * 1. last digit n%10
 * 2. remove last digit num/10
 */