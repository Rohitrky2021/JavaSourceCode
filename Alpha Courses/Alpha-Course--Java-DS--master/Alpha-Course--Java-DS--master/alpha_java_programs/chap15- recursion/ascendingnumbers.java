//WAP to print numbers from n to 1 in ascending order using recursion
public class ascendingnumbers {
    public static void printInc(int n) {
        if(n==1) {
            System.out.print(n);
            return;
        }

        printInc(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        int n = 5;
        printInc(n);
    }
}