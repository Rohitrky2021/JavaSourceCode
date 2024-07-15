//WAP to implement binary strings problem
public class binarystrings {
    public static void printbinary(int n, int lastPlace, String str) {
        // base case
        if(n == 0) {
            System.out.println(str);
            return;
        }
        //working
        printbinary(n-1, 0, str + "0");

        if(lastPlace == 0) {
            printbinary(n-1, 1, str + "1");
        }
    }
    public static void main(String[] args) {
        printbinary(3, 0, "");
    }
}
