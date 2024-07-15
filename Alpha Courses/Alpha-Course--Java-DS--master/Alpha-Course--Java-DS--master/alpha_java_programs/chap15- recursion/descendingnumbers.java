//WAP to print numbers from n to 1 in descending order using recursion 
public class descendingnumbers {
    public static void printdec(int n) {
        if(n == 1) {
            System.out.print(n);
            return;
        }

        System.out.println(n + " ");
        printdec(n-1);
    }
    public static void main(String[] args) {
        int n = 10;
        printdec(n);
    }
}