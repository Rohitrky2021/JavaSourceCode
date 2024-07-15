import java.util.*;
// https://www.geeksforgeeks.org/unique-triplets-sum-given-value/

public class triplet {

    public static void countDivisibleTriplets(int[] numbers, int divisor) {
        // Map to store the frequency of remainders when dividing by the divisor
        HashMap<Integer, Integer> remainderFrequencyMap = new HashMap<>();

        // Count the frequency of each remainder
        for (int number : numbers) {
            int remainder = number % divisor;
            int frequency = remainderFrequencyMap.getOrDefault(remainder, 0);
            remainderFrequencyMap.put(remainder, frequency + 1);
        }

        // Count triplets with remainder 0
        int tripletCount = remainderFrequencyMap.getOrDefault(0, 0) / 3;

        // Count triplets with non-zero remainders
        for (int i = 1; i <= divisor / 2 && i != divisor - i; i++) {
            tripletCount += Math.min(
                remainderFrequencyMap.getOrDefault(i, 0),
                remainderFrequencyMap.getOrDefault(divisor - i, 0)
            );
        }

        // Handle the case where divisor is even and has triplets with remainder divisor/2
        if (divisor % 2 == 0) {
            tripletCount += remainderFrequencyMap.getOrDefault(divisor / 2, 0) / 3;
        }

        System.out.println("The number of divisible triplets is: " + tripletCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int numberOfElements = scanner.nextInt();

        int[] numbers = new int[numberOfElements];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        countDivisibleTriplets(numbers, divisor);
    }
}
