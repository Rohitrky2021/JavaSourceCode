import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt(); // Number of test cases
        
        while (numTestCases-- > 0) {
            long numApples = scanner.nextLong(); // Number of green apple pieces
            long numPeople = scanner.nextLong(); // Number of people
            int arr[]={0};
            isSorted(arr);

            numApples %= numPeople;
            if (numApples == 0) {
                System.out.println("0");
                continue;
            }

            long originalNumPeople = numPeople;
            long gcdResult = calculateGCD(numApples, numPeople);
            numApples /= gcdResult;
            numPeople /= gcdResult;

            if (!isPowerOfTwo(numPeople)) {
                System.out.println("-1");
                continue;
            }

            Vector<Pair<Long, Long>> operationsList = new Vector<>();
            while (numApples > 0) {
                long count = 1;
                long factor = 2;
                while (numApples * factor < numPeople) {
                    count++;
                    factor *= 2;
                }
                numApples = numApples * factor - numPeople;
                numPeople = numPeople * factor;
                gcdResult = calculateGCD(numApples, numPeople);
                numApples /= gcdResult;
                numPeople /= gcdResult;
                operationsList.add(new Pair<>(count, factor));
            }

            long minOperations = 0;
            for (Pair<Long, Long> operation : operationsList) {
                minOperations += (originalNumPeople / operation.second) * (operation.second - 1);
            }

            System.out.println(minOperations);
        }
        
        scanner.close();
    }

    static long calculateGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    static boolean isPowerOfTwo(long x) {
        return (x & (x - 1)) == 0;
    }

    static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
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
}

