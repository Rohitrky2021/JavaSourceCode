//WAP to clear the last i bits of a number
public class clearlastibits {
    public static int clearbits(int n, int i) {
        int bitMask = ~(0) << i;
        return n & bitMask;
    }
    public static void main(String[] args) {
        System.out.println(clearbits(15, 2));
    }
}
