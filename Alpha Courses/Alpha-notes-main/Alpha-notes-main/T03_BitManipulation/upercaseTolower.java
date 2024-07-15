package T03_BitManipulation;

// import java.util.Scanner;

public class upercaseTolower {

    public static int tolower(char c){
        int a = (int)c;
        return (a&(1<<5));
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // System.out.println(tolower('A'));
        System.out.println((int)'a');
        


        // sc.close();
    }
}
