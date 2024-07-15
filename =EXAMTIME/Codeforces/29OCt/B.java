import java.util.Scanner;
import java.util.ArrayList;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int arrayLength = scanner.nextInt();
            int numQueries = scanner.nextInt();

            ArrayList<Long> elements = new ArrayList<>();
            int elementIndex = 0;
            while (elementIndex < arrayLength) {
                elements.add(scanner.nextLong());
                elementIndex++;
            }

            boolean elementsSorted = isSorted(elements); // Check if elements are sorted

            ArrayList<Long> queries = new ArrayList<>();
            int queryIndex = 0;
            while (queryIndex < numQueries) {
                long queryValue = scanner.nextLong();
                if (queries.isEmpty() || queries.get(queries.size() - 1) > queryValue) {
                    queries.add(queryValue);
                }
                queryIndex++;
            }

            boolean queriesSorted = isSorted(queries); // Check if queries are sorted

            int queryElementIndex = 0;
            while (queryElementIndex < queries.size()) {
                long queryElement = queries.get(queryElementIndex);
                int elementPosition = 0;
                while (elementPosition < arrayLength) {
                    if (elements.get(elementPosition) % (1L << queryElement) == 0) {
                        elements.set(elementPosition, elements.get(elementPosition) + (1L << (queryElement - 1)));
                    }
                    elementPosition++;
                }
                queryElementIndex++;
            }

            int elementOutputIndex = 0;
            while (elementOutputIndex < arrayLength) {
                System.out.print(elements.get(elementOutputIndex) + " ");
                elementOutputIndex++;
            }
            System.out.println();
        }
    }

    public static boolean isSorted(ArrayList<Long> list) {
        long n = list.size();
        for (long i = 0; i < n - 1; i++) {
            if (list.get((int) i) > list.get((int) (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
