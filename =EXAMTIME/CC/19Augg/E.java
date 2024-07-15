import java.util.*;
import java.lang.*;
import java.io.*;

class E
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        while (testCases > 0) {
            int arraySize = Integer.parseInt(reader.readLine());
            String[] input = reader.readLine().split(" ");
            int param1 = Integer.parseInt(input[0]);
            int param2 = Integer.parseInt(input[1]);
            input = reader.readLine().split(" ");
            int[] numbers = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            isSorted(numbers);

            Arrays.sort(numbers);
            int minValue = numbers[0];
            int maxValue = numbers[arraySize - 1];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 1; i < arraySize - 1; i++) {
                priorityQueue.add(Math.abs(numbers[i]));
            }

            isSorted(numbers);

            int iterations = param1 + param2;
            long result = 0;

            while (iterations > 0 && !priorityQueue.isEmpty()) {
                result += (long) priorityQueue.remove();
                iterations--;
            }
            isSorted(numbers);

            result += (long) (maxValue - minValue);

            System.out.println(result);
            testCases--;
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
