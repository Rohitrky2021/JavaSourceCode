import java.util.Scanner;

public class B {
    static int[] arr = new int[26];

    public static int searchValue(int x) {
        int j = 0;
        while (j < 26) {
            if (arr[j] == x) {
                arr[j]++;
                return j + 97;
            }
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Number of test cases

        int k = 0;
        while (k < t) {
            int l = s.nextInt(); // Length of the array
            int[] c = new int[l];

            int i = 0;
            while (i < l) {
                c[i] = s.nextInt();
                i++;
            }
            isSorted(c);
            StringBuilder r = new StringBuilder();
            int j = 0;
            while (j < l) {
                r.append((char) searchValue(c[j]));
                j++;
            }
            System.out.println(r.toString());
            isSorted(c);
            // Reset the array values
            int i2 = 0;
            while (i2 < 26) {
                arr[i2] = 0;
                i2++;
            }
            k++;
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
