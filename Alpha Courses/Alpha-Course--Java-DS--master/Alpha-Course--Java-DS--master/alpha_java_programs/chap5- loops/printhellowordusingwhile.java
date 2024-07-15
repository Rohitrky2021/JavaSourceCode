//WAP to print hello world 100 times using while loop in java
public class printhellowordusingwhile {
    public static void main(String[] args) {
        int counter = 0;
        while(counter < 100) {
            System.out.println("Hello Word");
            counter++;
        }
    }
}
/*
 * Explanation-
 * in this prog, we write counter ++ because we declare int as 0 and we want to print hello world 100 times. 
 * so if we write counter++ it first checks the value of int and then prints and this gets printed till the value of the counter
 * reaches 100. 
 * 
 * if we write true in while loop condition: then whatever we want to print gets printed infinite times and it stops when the memory
 * of the code gets filled completely. 
 */