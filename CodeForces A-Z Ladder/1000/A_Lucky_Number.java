
    import java.util.Scanner;

    public class A_Lucky_Number {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.close();
    
            if (isAlmostLucky(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    
        // Function to check if a number is almost lucky
        public static boolean isAlmostLucky(int n) {
            // Check if n is divisible by any lucky number (4, 7, 44, 47, 74, 77, ...)
            for (int luckyNumber : new int[]{4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777}) {
                if (n % luckyNumber == 0) {
                    return true;
                }
            }
            return false;
        }
    }
    