//WAP to swap values using function and call by value
public class callbyvalue {
    public static void swap (int a, int b)
    {
        //swap
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
    public static void main(String[] args) {
        //swap- values exchange
        int a = 5;
        int b = 10;
        swap(a, b);
    }
}
/*
 * Explanation-
 * there is only call by value in java, not call by reference. 
 * if we call a method passing a value it is known as call by value. 
 * in case of call by reference original value is changed if we made changes in the call method. 
 * if we pass object in place of any primitive value, original value will be changed. 
 */