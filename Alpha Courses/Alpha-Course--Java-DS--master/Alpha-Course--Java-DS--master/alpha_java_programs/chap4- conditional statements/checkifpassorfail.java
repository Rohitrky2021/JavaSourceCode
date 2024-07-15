//prog to check if the student has passed or failed using ternary operator
public class checkifpassorfail {
    public static void main(String[] args) {
        int marks = 33;
        String status = (marks>=33)? "passed":"failed";
        System.out.println("The student has: "+status);
    }
}
/*
 * Explanation-
 * if the marks is greater than 33 then the student has pass or else fail
 */