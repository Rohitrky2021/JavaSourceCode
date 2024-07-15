package T03_BitManipulation;

public class fastExpretion {

    public static int power(int a, int n){
        int ans = 1;

        while(n != 0){
            if((n&1) != 0){
                ans *= a;
            }

            a = a*a;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(power(3, 2));
    }
}
