import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt();
        while (testCases-- > 0) {
            int arraySize = inputScanner.nextInt();
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = inputScanner.nextInt();
            }
            isSorted(array);
            
            int myVar = 0;
            Arrays.sort(array);
            for (int num : array) {
                if (num == myVar) {
                    myVar++;
                }
            }
            
            if (myVar == 0) {
                System.out.println(0);
                continue;
            }
            
            Vector<Integer> frequency = new Vector<>(myVar);
            for (int i = 0; i < myVar; i++) {
                frequency.add(0);
            }
            
            for (int num : array) {
                if (num < myVar) {
                    frequency.set(num, frequency.get(num) + 1);
                }
            }
            
            Vector<Long> dp = new Vector<>(myVar);
            long maxLong = Long.MAX_VALUE;
            for (int i = 0; i < myVar; i++) {
                dp.add(maxLong);
            }
            
            for (int i = 0; i < myVar; i++) {
                for (int j = 0; j <= i; j++) {
                    dp.set(i, Math.min(dp.get(i), (frequency.get(j) - 1) * (i + 1) + j + (j >= 1 ? dp.get(j - 1) : 0)));
                }
            }
       
            System.out.println(dp.get(myVar - 1));
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
