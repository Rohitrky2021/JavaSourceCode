import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();
        long c = s.nextLong();
        long d = s.nextLong();
        s.close();
        
        System.out.println("48 50");
        f('A', 'B', b - 1);
        f('B', 'A', a - 1);
        f('C', 'D', d - 1);
        f('D', 'C', c - 1);
    }

    private static void f(char x, char y, long v) {
        for (int i = 0; i < 50; i++) {
            System.out.print(x);
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            if (v > 0 && i % 2 == 1) {
                System.out.print(y);
                v--;
            } else {
                System.out.print(x);
            }
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {

            
            System.out.print(x);
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            if (v > 0 && i % 2 == 0) {
                System.out.print(y);
                v--;
            } else {
                System.out.print(x);
            }
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {


            System.out.print(x);
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            if (v > 0 && i % 2 == 1) {
                System.out.print(y);
                v--;
            } else {
                System.out.print(x);
            }
        }


        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            System.out.print(x);
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            if (v > 0 && i % 2 == 0) {
                System.out.print(y);
                v--;
            } else {
                System.out.print(x);
            }
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            System.out.print(x);
        }
        System.out.println();
        int z = 0;


        while ( z < 3) {
            for (int i = 0; i < 50; i++) {
                System.out.print(x);
            }
            z++;
            System.out.println();
        }
    }
}
