//WAP to perform break statement when entering numbers 1 to 5
public class breakstatement {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++) {
            if(i==3) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("i am out of the loop");
    }
}
/*
 * Explanation-
 * in this prog we want to print numbers 1 to 5 but as we put break statement at 3 it only prints numbers 1 and 2
 */