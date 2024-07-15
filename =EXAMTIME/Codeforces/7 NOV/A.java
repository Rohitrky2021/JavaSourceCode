import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Number of plays
            String plays = scanner.next(); // Sequence of plays

            char[] playArray = plays.toCharArray();

            int winsA = 0;
            int winsB = 0;
            int setsA = 0;
            int setsB = 0;

            for (int j = 0; j < n; j++) {
                if (playArray[j] == 'A') {
                    winsA++;
                } else {
                    winsB++;
                }

                if (winsA >= winsB) {
                    setsA++;
                } else {
                    setsB++;
                }
            }

        
                System.out.println(playArray[n-1]); // Winner cannot be determined
            }
        }

        
    }

