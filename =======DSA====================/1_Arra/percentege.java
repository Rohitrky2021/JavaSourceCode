  
import java.util.Scanner;
public class percentege {
    public static void main(String args[]){
        int marks[]=new int[100];
        int ans;
        
        // marks=new Scanner
        Scanner sc=new Scanner(System.in);
            marks[0]=sc.nextInt();
            marks[1]=sc.nextInt();
            marks[2]=sc.nextInt();

            System.out.println(marks[0]);
            System.out.println(marks[1]);
            System.out.println(marks[2]);
            System.out.println((marks[0]+marks[1]+marks[2])/3 + "%");

    }
}
