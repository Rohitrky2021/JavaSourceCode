package T03_BitManipulation;

// import java.util.Scanner;

public class AddOne {
    // public static int addOne(int n) {
    //     int i = 0;
    //     while (n != 0) {
    //         if ((n & (1 << i)) == 0) {
    //             n = n | (1 << i);
    //             return n;
    //         } else {
    //             n = n | (~(1 << i));
    //             i++;
    //         }
    //     }
    //     return n + 1;
    // }
    

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // System.out.println(addOne(n));

        // sc.close();
        int x = 6;
        System.out.println(-~x);
        x = -4;
        System.out.println(-~x);


    }
}
