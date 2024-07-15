public class D {
    public static void main(String[] args) {
        int[] testCases = { 3, 5, 14 }; // Example test cases

        for (int testCase : testCases) {
            System.out.print("Divisors of " + testCase + ": ");
            printDivisors(testCase);
            System.out.println(); // Move to the next line for the next test case
        }
    }

    public static void printDivisors(int n) {
        int i = 0;

        for (i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

        for (i = i - 1; i >= 1; i--) {
            if (n % i == 0 && i != n / i) {
                System.out.print(n / i + " ");
            }
        }
    }
}
