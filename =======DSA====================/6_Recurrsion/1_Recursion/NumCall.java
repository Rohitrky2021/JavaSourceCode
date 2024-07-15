package T05_Recursion;

public class NumCall {

    static String digit[] = { "Zero", "one", "two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    public static void main(String[] args) {
        int n = 2022;
        // numIs(n);
        numCall(n);
    }

    public static void numCall(int n) {
        if (n == 0)
            return;
        int Dg = n % 10;
        numCall(n / 10);
        System.out.print(digit[Dg] + " ");
    }

    public static void numIs(int n) {
        if (n == 0) {
            return;
        }
        int digit = n % 10;
        n = n / 10;
        numIs(n);
        switch (digit) {
            case 1:
                System.out.print("One ");
                break;
            case 2:
                System.out.print("Two ");
                break;
            case 3:
                System.out.print("Three ");
                break;
            case 4:
                System.out.print("Four ");
                break;
            case 5:
                System.out.print("Five ");
                break;
            case 6:
                System.out.print("Six ");
                break;
            case 7:
                System.out.print("Seven ");
                break;
            case 8:
                System.out.print("Eight ");
                break;
            case 9:
                System.out.print("Nine ");
                break;
            case 0:
                System.out.print("Zero ");
                break;
        }

    }
}
