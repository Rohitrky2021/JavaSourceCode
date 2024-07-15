// package T05_Recursion;

public class BinaryStr {
    public static void main(String[] args) {
        printStr(2, 0, "");

    }

    public static void printStr(int n, int i, String str) { // i == previos places num was 0 or 1
        if (n == 0) {
            System.out.println(str);
            return;
        }
        

        printStr(n - 1, 0, str + "0");
        if (i == 0) {   // if u comment out this whole permuatiion will be printed
            printStr(n - 1, 1, str + "1");
        }

    }
}
