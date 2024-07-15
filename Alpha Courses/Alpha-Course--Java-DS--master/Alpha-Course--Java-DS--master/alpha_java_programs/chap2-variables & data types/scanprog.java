//to use scanner class in java
import java.util.*;
public class scanprog {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //String input = sc.next();
        //System.out.println(input);

        String name = sc.nextLine(); //to capture anything after we put space in the output
        System.out.println(name);
        sc.close();
    }
}
/*
 * Explanation-
 * 1. in this we use .next() to capture any word
 * 2. we use system.in as we are using scanner and we want to receive user input
 * 3. it is not necessary to keep the scanner variable as sc. you can store it at whenever you want. 
 */