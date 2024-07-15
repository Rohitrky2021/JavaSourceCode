package Recursion.Level1Questions;

public class PrintNto1 {
    public static void main(String args[]) {
        print(5);
    }

    static void print(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(n);
        print(n - 1);
        System.out.println(n);
    }
}
