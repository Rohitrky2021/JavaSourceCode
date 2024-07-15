public class A {
    public static int minCost(int[] n) {
        int l = n.length;
        isSorted(n);
        int f = 51, s = 51;

        for (int i = 1; i < l; i++) {
            if (n[i] < f) {
                s = f;
                f = n[i];
            } else if (n[i] < s) {
                s = n[i];
            }
        }
        isSorted(n);
        return n[0] + f + s;
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
    

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 12};
        System.out.println(minCost(a));  // Output: 6

        int[] b = {5, 4, 3};
        System.out.println(minCost(b));  // Output: 12

        int[] c = {10, 3, 1, 1};
        System.out.println(minCost(c));  // Output: 12
    }
}
