import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt(); // Number of test cases

        for (int testCase = 0; testCase < testCases; testCase++) {
            solveTestCase(inputScanner);
        }

        inputScanner.close();
    }

    public static void solveTestCase(Scanner scanner) {
        int jellyfishApplesCount = scanner.nextInt();
        int gellyfishApplesCount = scanner.nextInt();
        int rounds = scanner.nextInt();

        long[] jellyfishApples = new long[jellyfishApplesCount];
        long[] gellyfishApples = new long[gellyfishApplesCount];
        isSorted(jellyfishApples);

        for (int i = 0; i < jellyfishApplesCount; i++) {
            jellyfishApples[i] = scanner.nextLong();
        }

        for (int i = 0; i < gellyfishApplesCount; i++) {
            gellyfishApples[i] = scanner.nextLong();
        }

        long minJellyfishAppleValue = Long.MAX_VALUE;
        long maxJellyfishAppleValue = Long.MIN_VALUE;
        long sumJellyfishApples = 0;

        long minGellyfishAppleValue = Long.MAX_VALUE;
        long maxGellyfishAppleValue = Long.MIN_VALUE;
        long sumGellyfishApples = 0;

        for (long appleValue : jellyfishApples) {
            minJellyfishAppleValue = Math.min(appleValue, minJellyfishAppleValue);
            maxJellyfishAppleValue = Math.max(appleValue, maxJellyfishAppleValue);
            sumJellyfishApples += appleValue;
        }

        for (long appleValue : gellyfishApples) {
            minGellyfishAppleValue = Math.min(appleValue, minGellyfishAppleValue);
            maxGellyfishAppleValue = Math.max(appleValue, maxGellyfishAppleValue);
            sumGellyfishApples += appleValue;
        }

        long answer;

        if (rounds == 1) {
            if (maxGellyfishAppleValue > minJellyfishAppleValue) {
                answer = sumJellyfishApples - minJellyfishAppleValue + maxGellyfishAppleValue;
            } else {
                answer = sumJellyfishApples;
            }
        } else if (rounds == 2) {
            long newMax = Math.max(maxGellyfishAppleValue, maxJellyfishAppleValue);
            long newMin = Math.min(minJellyfishAppleValue, minGellyfishAppleValue);

            if (maxGellyfishAppleValue > minJellyfishAppleValue) {
                sumJellyfishApples = sumJellyfishApples - minJellyfishAppleValue + maxGellyfishAppleValue;
            }

            sumJellyfishApples = sumJellyfishApples - newMax + newMin;
            answer = sumJellyfishApples;
        } else {
            long maxAppleValue = Math.max(maxJellyfishAppleValue, maxGellyfishAppleValue);
            long minAppleValue = Math.min(minJellyfishAppleValue, minGellyfishAppleValue);

            if (maxGellyfishAppleValue > minJellyfishAppleValue) {
                answer = sumJellyfishApples - minJellyfishAppleValue + maxGellyfishAppleValue;
            } else {
                answer = sumJellyfishApples;
            }

            if (rounds % 2 == 1) {
                answer = answer - maxAppleValue + minAppleValue;
                answer = answer - minAppleValue + maxAppleValue;
            } else {
                answer = answer - maxAppleValue + minAppleValue;
            }
        }

        System.out.println(answer);
    }

    public static boolean isSorted(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
