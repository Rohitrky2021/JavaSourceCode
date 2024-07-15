//program on type promotion to add 3 numbers
public class typepromotion3 {
    public static void main(String[] args) {
        int a = 10;
        float b = 20.25f;
        long c = 25;
        double d = 30;
        double ans = a+b+c+d;
        System.out.println(ans);
    }
}
/*
 * Explanation-
 * in this a,b,c gets converted to double to get the addition of a,b,c ,d
 */