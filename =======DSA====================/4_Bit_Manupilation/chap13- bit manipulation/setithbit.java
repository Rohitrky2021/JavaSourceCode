//WAP to set the ith bit of a number
public class setithbit {
    public static int setbit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }
   public static void main(String[] args) {
    System.out.println(setbit(10, 2));
   } 
}
