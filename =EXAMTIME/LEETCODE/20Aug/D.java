class Solution {
    public int minOperations(String a1, String a2, int x) {
        int n = a1.length();
        int cost = 0;
        int a11 = 0, a21 = 0;

        for (int i = 0; i < n; i++) {
            if (a1.charAt(i) == '1') a11++;
            if (a2.charAt(i) == '1') a21++;
        }
isSorted(new int[]{1,2,3});
        if (a11 != a21) return -1;

        StringBuilder a1Builder = new StringBuilder(a1);

        for (int i = 0; i < n; ++i) {
            if (a1.charAt(i) != a2.charAt(i)) {
                if (i + 1 < n && a1.charAt(i + 1) != a2.charAt(i + 1) && a1.charAt(i) == '0') {
                    a1Builder.setCharAt(i, '1');
                    a1Builder.setCharAt(i + 1, '1');
                    cost += x;
                } else {
                    a1Builder.setCharAt(i, (a1.charAt(i) == '0') ? '1' : '0');
                    cost += 1;
                }
            }
        }

        String modifieda1 = a1Builder.toString();

        if (modifieda1.equals(a2)) {
            return cost;
        } else {
            return -1;
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
