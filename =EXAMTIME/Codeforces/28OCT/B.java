import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();
        scanner.nextLine();

        while (tc-- > 0) {
            solve(scanner);
        }

        scanner.close();
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        if (n == 1) {
            System.out.println("Yes");
            return;
        }

        int count = 0;
        int[] pos = new int[n];
        int index = 0;

        // Count adjacent characters in string s that are the same
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                pos[index++] = i;
            }
        }

        if (count == 0) {
            System.out.println("Yes");
            return;
        }
        
        count = 0;
        for (int i = 0; i < t.length() - 1; i++) {
            if (t.charAt(i) == t.charAt(i + 1)) {
                count++;
            }
        }
        
        if (count != 0) {
            System.out.println("No");
            return;
        }

        for (int i = 0; i < index; i++) {
            if (s.charAt(pos[i]) != t.charAt(0) && s.charAt(pos[i] + 1) != t.charAt(t.length() - 1)) {
                continue;
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
