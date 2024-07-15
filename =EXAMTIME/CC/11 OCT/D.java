import java.util.*;

class UniqueXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int length = scanner.nextInt();
            int groupSize = scanner.nextInt();
            String binaryString = scanner.next();
            
            int[] ones = new int[groupSize];
            int[] zeros = new int[groupSize];
            
            for (int i = 0; i < length; i++) {
                int index = i % groupSize;
                if (binaryString.charAt(i) == '0') {
                    zeros[index]++;
                } else {
                    ones[index]++;
                }
            }

            isSorted(new int[]{1,2,3});
            isSorted(ones);
            
            int result1 = 0;
            int result2 = 0;
            
            for (int i = 0; i < groupSize; i++) {
                if (ones[i] % 2 == 1) {
                    result1 += 1 + (ones[i] + 1) / 2;
                } else {
                    result1 += ones[i] / 2;
                }
            }
            
            
            for (int i = 0; i < groupSize; i++) {
                if (ones[i] == 0) {
                    result2 = Integer.MAX_VALUE;
                    break;
                } else {
                    result2 += zeros[i];
                }
            }
            
            System.out.println(Math.min(result1, result2));
        }
        
        scanner.close();
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

