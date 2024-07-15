//WAP to update the ith bit of a number
public class updateithbit {
    public static int ithbit(int n, int i) {
        int bitMask = 1 << i;
        if((n & bitMask) == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public static int setbit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }
    public static int clearbit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }
    public static int updatebit(int n, int i, int newbit) {
        n = clearbit(n, i);
        int bitMask = newbit << i;
        return n | bitMask;
    }
    public static void main(String[] args) {
        System.out.println(updatebit(10, 2, 1));
    }
}
