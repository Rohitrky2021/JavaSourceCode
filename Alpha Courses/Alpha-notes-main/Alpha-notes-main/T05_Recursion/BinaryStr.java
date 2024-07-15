package T05_Recursion;

public class BinaryStr {
    public static void main(String[] args) {
        printStr(5, 0, "");
    }

    public static void printStr(int n, int i, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printStr(n - 1, 0, str + "0");
        if (i == 0) {
            printStr(n - 1, 1, str + "1");
        }

    }
}
