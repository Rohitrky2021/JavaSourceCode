import java.util.Scanner;
import java.util.Vector;

public class E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            Vector<Integer> arr = new Vector<>();

            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            int result = minOperationsToSort(arr);
            System.out.println(result);
        }
    }

    private static int minOperationsToSort(Vector<Integer> arr) {
        int n = arr.size();
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) < arr.get(minIndex)) {
                minIndex = i;
            }
        }

        int res = minIndex;
        for (int i = minIndex; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                res = -1;
                break;
            }
        }

        return res;
    }
}
