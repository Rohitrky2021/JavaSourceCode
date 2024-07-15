import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt(); // Alice's initial score
            int B = scanner.nextInt(); // Bob's initial score
            int cnt=0;

            int difference = A - B;

             while(difference<10){
                        A+=3;
                        difference = A - B;
                        cnt++;
             }
              
             System.out.println(cnt);
           
        }

        scanner.close();
    }
}

 