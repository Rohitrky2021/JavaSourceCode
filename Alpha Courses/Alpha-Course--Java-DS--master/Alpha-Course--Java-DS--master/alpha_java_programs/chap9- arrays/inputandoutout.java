//WAP to input some marks and then take the output and then find percentage using arrays
import java.util.Scanner;

public class inputandoutout {
    public static void main(String[] args) {
        int marks[] = new int [100];
        Scanner sc = new Scanner(System.in);
        //input marks
        System.out.println("Write the marks of physics, chemistry and maths-");
        marks[0] = sc.nextInt(); //phy marks
        marks[1] = sc.nextInt(); //chem marks
        marks[2] = sc.nextInt(); //math marks
        //output marks
        System.out.println("physics marks: " + marks[0]);
        System.out.println("chemistry marks: " + marks[1]);
        System.out.println("maths marks: " + marks[2]);

        marks[2] = 100; //it will print this as we have printed this and 
        //it will update it to 100. if we type 67 in maths marks, it will give us 100 as 100 is updated in maths marks 
        System.out.println("maths marks: " + marks[2]);

        //to calculate percentage
        int percentage = (marks[0] + marks[1] + marks[2])/3;
        System.out.println("Percentage of all the subjects is: " + percentage + "%");
        sc.close();
    }
}
