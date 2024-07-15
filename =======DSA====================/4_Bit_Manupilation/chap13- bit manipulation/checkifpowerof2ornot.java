//WAP to check if a number is power of 2 or no
public class checkifpowerof2ornot {
    public static boolean poweroftwo (int n) {
        return (n & (n-1)) == 0;

    }
    public static void main(String[] args) {
        System.out.println(poweroftwo(8));
    }
}
