//prog on arithematic unary operators: post increment type
public class arithematic_unaryoperators1 {
    public static void main(String[] args) {
        int a = 10;
        int b = a++;
        System.out.println(a);
        System.out.println(b);
    }
}
/*
 * Explanation-
 * in this, the value of a is 10 and b is post incremented by a, hence the value of a which is 10 assigns in b and the value of b
 * increments by 1 which turns the value of a to 11
 */