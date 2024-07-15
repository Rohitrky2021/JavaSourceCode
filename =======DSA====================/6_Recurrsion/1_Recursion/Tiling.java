package T05_Recursion;

public class Tiling {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(tilingfor2xn(n));
        System.out.println(tilingfor4xn(n));
    }

    public static int tilingfor2xn(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return tilingfor2xn(n - 1) + tilingfor2xn(n - 2);
    }

    public static int tilingfor4xn(int n) {
        // int temp = tilingfor2xn(n);
        // return temp*temp;

        if (n == 1 || n == 0) {
            return 1;
        }
        if(n < 0){
            return 0;
        }

        return tilingfor4xn(n - 1) + tilingfor4xn(n - 4);

    }
}
