import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            String s = scanner.nextLine();

            int minSegmentLength = findMinSegmentLength(n, s);
            System.out.println(minSegmentLength);
        }

        scanner.close();
    }

    public static int findMinSegmentLength(int n, String s) {
        int firstIndex = s.indexOf('B');
        int lastIndex = s.lastIndexOf('B');

        // System.out.println(firstIndex  +" "+lastIndex );

        int minSegmentLength = lastIndex-firstIndex+1;
        return minSegmentLength;
    }
}
