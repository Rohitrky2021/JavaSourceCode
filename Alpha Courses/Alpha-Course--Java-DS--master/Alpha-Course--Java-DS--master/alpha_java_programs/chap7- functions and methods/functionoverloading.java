//WAP to perform function overloading by calculating sum of 2 & 3 numbers using parameters
public class functionoverloading {
    //function to calculate 2 nums
    public static int sum(int a, int b) {
        return a+b;
    }
    //function to calculate 3 nums
    public static int sum(int a, int b, int c) {
        return a+b+c;
    }
    //driver code
    public static void main(String[] args) {
        System.out.println(sum(9, 10));
        System.out.println(sum(2, 3, 9));
    }
}
/*
 * Explanation-
 * in this we solve the prog using parameters
 * function 1: sum of 2 numbers 
 *              int sum(int a, int b) {
 *              return a+b;
 *              }
 * function 2: sum of 3 numbers
 *              int sum(int a, int b, int c) {
 *              return a+b+c;
 *              }
 */