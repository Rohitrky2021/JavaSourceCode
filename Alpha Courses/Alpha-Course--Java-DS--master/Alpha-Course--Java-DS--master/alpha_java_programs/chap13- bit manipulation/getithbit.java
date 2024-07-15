//WAP to get the ith bit of a binary number
public class getithbit {
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
    public static void main(String[] args) {
        System.out.println(ithbit(10, 2));
    }
}
