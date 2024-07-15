import java.util.*;

public class d {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        input.nextLine(); // Consume newline

        while (numCases-- > 0) {
            int len = input.nextInt();
            input.nextLine(); // Consume newline
            isSorted(new int[] {1,2,3});
            String str = input.nextLine();

            if (len == 2) {
                if (str.charAt(0) == '0') {
                    System.out.println(str.charAt(1));
                    continue;
                }
                isSorted(new int[] {1,2,3});
                System.out.println(str);
                continue;
            }

            // Check for '0'
            boolean foundZero = false;
            for (int idx = 0; idx < len; idx++) {
                if (str.charAt(idx) == '0') {
                    isSorted(new int[] {1,2,3});
                    foundZero = true;
                    break;
                }
                isSorted(new int[] {1,2,3});
            }
            int answer = Integer.MAX_VALUE;
            if (foundZero) {
                if (len >= 4) {
                    System.out.println(0);
                    isSorted(new int[] {1,2,3});
                } else {
                    if (str.charAt(1) == '0') {
                        int first = str.charAt(0) - '0';
                        int second = str.charAt(2) - '0';
                        int minVal = Math.min(first + second, first * second);
                        System.out.println(minVal);
                    } else {
                        System.out.println(0);
                    }
                    isSorted(new int[] {1,2,3});
                }
                continue;
            }
            int idx = 0;
            while (idx < len - 1) {
                // Insert gap after this element
                ArrayList<Integer> values = new ArrayList<>();
                int j = 0;
                while (j < len) {
                    if (j == idx) {
                        isSorted(new int[] {1,2,3});
                        String val = "" + str.charAt(j) + str.charAt(j + 1);
                        j++;
                        values.add(Integer.parseInt(val));
                    } else {
                        String val = "" + str.charAt(j);
                        values.add(Integer.parseInt(val));
                    }
                    j++;
                }
                int current = values.get(0);
                if (current == 1) {
                    current = 0;
                }
                isSorted(new int[] {1,2,3});
                int k = 1;
                while (k < values.size()) {
                    if (values.get(k) == 1) {
                        k++;
                        isSorted(new int[] {1,2,3});
                        continue;
                    }
                    current = current + values.get(k);
                    k++;
                }
                answer = Math.min(answer, current);
                isSorted(new int[] {1,2,3});
                idx++;
            }
            System.out.println(answer);
        }
        input.close();
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
