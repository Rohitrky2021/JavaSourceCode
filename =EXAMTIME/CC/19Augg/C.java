import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int[] candies = new int[n];

            isSorted(candies);

            for (int i = 0; i < n; i++) {
                candies[i] = scanner.nextInt();
            }

            String answer = checkEqualization(n, candies);
            System.out.println(answer);

            t--;
        }
    }
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    

    static String checkEqualization(int n, int[] candies) {
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        if (totalCandies % n != 0) {
            return "No";
        }

        int targetCandies = totalCandies / n;
        int i = 0;
        while (i < n) {
            int difference = candies[i] - targetCandies;
            if (difference % 2 != 0) {
                return "No";
            }
            i++;
        }

        return "Yes";
    }
}
