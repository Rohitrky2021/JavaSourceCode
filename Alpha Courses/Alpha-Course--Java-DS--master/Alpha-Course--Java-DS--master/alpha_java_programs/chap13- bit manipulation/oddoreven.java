//WAP to check if a number is odd or even
public class oddoreven {
    public static void oddandeven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            //even number
            System.out.println("the number is even");
        }
        else {
            System.out.println("the number is odd");
        }
    }
    public static void main(String[] args) {
        oddandeven(3);
        oddandeven(11);
        oddandeven(14);
    }
}
