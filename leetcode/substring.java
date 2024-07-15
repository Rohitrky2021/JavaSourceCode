import java.util.Scanner;

public class substring {
    public static void main(String args[]){
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        int n=10;
        String A="abcd";
        String B="cdabcdab0";
        for (int i = 1; i <n; i++) {
            String C=A.repeat(i);
            // System.out.println(C);
            if(C.contains(B)){
                C.
                System.out.println(i);
                // break;
            }
            // System.out.println();
        }
    }
}
