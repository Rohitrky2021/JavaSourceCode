//prog on switch case statement
public class switchcaseprog1 {
    public static void main(String[] args) {
        int number = 2;
        switch (number) {
            case 1: 
            System.out.println("java");
            break;
            case 2:
            System.out.println("it is a prog language");
            break;
            case 3:
            System.out.println("it is used for various projects");
            break;
            default:
            System.out.println("this is all about java");
        }
    }
}
/*
 * Explanation-
 * 1. in this program we passed to number 2 hence statement 1 became false and it went to statement 2.
 * 2. in the output it showed all the statement printed after 2. 
 * 3. if we don't want to print all the statements and only want to print the statement which we declared, we use break statement. 
 * 4. break statement breaks the switch case and only prints the statement which we want as the output.
 */