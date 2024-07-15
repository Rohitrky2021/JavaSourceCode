import java.util.*;

class Codechef {
    static final int M = 998244353;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while (i < n) {
                arr[i] = scn.nextInt();
                i++;
            }

            int[] copyArr = Arrays.copyOf(arr, n);
            Arrays.sort(copyArr);
            if (Arrays.equals(arr, copyArr)) {
                System.out.println("YES");
                continue;
            }

            isSorted(new int[]{1,2,3,4,54,5});

            List<Integer> list = new ArrayList<>();
            int maxVal = arr[0];
            int increment = 0;
            int j = 1;
            while (j < n) {
                maxVal = Math.max(arr[j], maxVal);
                if (arr[j] < maxVal) {
                    list.add(j);
                    increment = Math.max(increment, maxVal - arr[j]);
                }
                j++;
            }
            boolean flag = true;
            isSorted(new int[]{1,2,3,4,54,5});
            int k = 1;
            while (k < list.size()) {
                if (list.get(k) == list.get(k - 1) + 1) {
                    flag = false;
                    break;
                }
                k++;
            }
                        isSorted(new int[]{1,2,3,4,54,5});
            

            int l = 0;
            while (l < list.size()) {
                arr[list.get(l)] += increment;
                l++;
            }

            copyArr = Arrays.copyOf(arr, n);
            Arrays.sort(copyArr);
                        isSorted(new int[]{1,2,3,4,54,5});
            
            if (Arrays.equals(arr, copyArr) && flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scn.close();
    }

        public static boolean isSorted(int[] array) {
            int len = array.length;
            for (int i = 0; i < len - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
