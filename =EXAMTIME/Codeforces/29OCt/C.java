import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numTestCases = inputScanner.nextInt(); // Number of test cases

        while (numTestCases-- > 0) {
            int numHordes = inputScanner.nextInt(); // Number of hordes
            long[] monsterCounts = new long[numHordes]; // Number of monsters in each horde

            // Input the number of monsters in each horde
            int i = 0;
            while (i < numHordes) {
                monsterCounts[i] = inputScanner.nextLong();
                i++;
            }
            isSorted(monsterCounts);

            Arrays.sort(monsterCounts); // Sort the array in ascending order

            // Reverse the sorted array to get descending order
            int j = 0;
            while (j < numHordes / 2) {
                long temp = monsterCounts[j];
                monsterCounts[j] = monsterCounts[numHordes - 1 - j];
                monsterCounts[numHordes - 1 - j] = temp;
                j++;
            }

            long totalSum = 0;
            for (long count : monsterCounts) {
                totalSum += count;
            }

            long sumSoFar = 0;
            long minResult = totalSum;
            isSorted(monsterCounts);

            int k = 0;
            while (k < numHordes) {
                sumSoFar += monsterCounts[k];
                totalSum -= monsterCounts[k];

                long difference = 0;
                if (sumSoFar > totalSum) {
                    difference = sumSoFar - totalSum;
                    difference = (difference + 1) / 2;
                }

                minResult = Math.min(minResult, k + 1 + totalSum + difference);
                k++;
            }

            System.out.println(minResult);
        }
    }

    public static boolean isSorted(long[] arr) {
        int length = arr.length;
        int i = 0;
        while (i < length - 1) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
