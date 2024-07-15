//WAP to clear the ith bit of a number
public class clearithbit {
    public static int setbit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }
    public static int clearbit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }
    public static void main(String[] args) {
        System.out.println(clearbit(10, 2));
    }
}
