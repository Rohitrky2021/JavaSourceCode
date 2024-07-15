import java.util.Scanner;

// https://codeforces.com/contest/1872/problem/D

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            long n = scanner.nextInt();
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            if (x == y) {
                System.out.println("0");
                continue;
            }

            // Calculate the maximum score for the current test case
            long lcm = lcm(x, y);

            // Calculate the count of numbers divisible by both x and y within range 1 to n
            long count = n / lcm;
            long maxScore = getMaxScore(n, x, y, count);
            // System.out.println(count);

            // Print the maximum score
            System.out.println(maxScore);
        }

        scanner.close();
    }

    // Function to calculate the maximum score for a test case
    private static long getMaxScore(long n, long x, long y, long count) {
        long maxScore = 0;
        // long y=Math.max(m, p);
        // long x=Math.min(m, p);

        // Calculate the number of elements divisible by x and y
        long divX = n / x;
        long divY = n / y;
        // System.out.prlongln(divX+" "+divY);

        long sumx = 0, i = 1;
        long sumy = 0;

        long s1 = divX - count;
        // System.out.println(s1);
        long s2 = divY - count;
        // System.out.println(s2);


        sumx = (s1*((2*n)-s1+1))/2;
        // System.out.println(sumx);

        sumy = ((s2 + 1)*s2) / 2;
        // System.out.println(sumy);

        return sumx - sumy;
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // Function to calculate the greatest common divisor (GCD) of two numbers
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return (long) gcd(b, a % b);
    }
}
