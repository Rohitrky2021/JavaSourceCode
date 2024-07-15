//WAP to swap two numbers without using any third variable
public class exercise1 {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        System.out.println("Before swap: x = " + x + " and y = " + y);
        //swap using xor
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap: x = " + x + " and y = " + y);
    }
}
