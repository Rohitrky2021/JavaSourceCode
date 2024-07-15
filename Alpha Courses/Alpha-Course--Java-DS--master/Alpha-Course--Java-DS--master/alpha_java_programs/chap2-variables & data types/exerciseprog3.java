//WAP to enter cost of 3 item from the user (using float)- a pencil, pen & eraser. You have to output the total cost of the items 
//back to the user as their bill
import java.util.Scanner;

public class exerciseprog3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declare the value of each item using float datatype
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();
        //total all the values of the items to get the total bill
        float total = pencil + pen + eraser;
        System.out.println("The cost of pencil is: "+pencil);
        System.out.println("The cost of pen is: "+pen);
        System.out.println("The cost of eraser is: "+eraser);
        System.out.println("The total bill is: "+total);

        //add-on the bill with 18% GST tax
        float newtotal = total + (0.18f * total); //using gst formula
        System.out.println("The final bill with 18% GST tax is: " + newtotal);
        sc.close();
    }
}
