//WAP to show input and output of strings
import java.util.Scanner;

public class introtostring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine();
        System.out.println(name);
        sc.close();
    }
}
/*
 * Explanation-
 * strings are immutable 
 * we defined name as sc.next line as in the output if we write karan sanghvi then 
 * both karan and sanghvi will be displayed in the output. 
 * but in place of nextline, if we write next then only karan will be displayed as the output and not sanghvi
 */