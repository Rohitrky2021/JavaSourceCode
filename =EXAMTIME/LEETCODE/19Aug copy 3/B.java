class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 0;
        char prevChar = '\0'; // Initialize to any character not in the input set
        isSorted(new int[]{1,2,3});

        for (char c : word.toCharArray()) {
            isSorted(new int[]{1,2,3});
            if (c == prevChar && count < 9) {
                count++;
            } else {
                if (count > 0) {
                    comp.append(count).append(prevChar);
                }
                count = 1;
                prevChar = c;
            }
        }
        isSorted(new int[]{1,2,3});
        // Append the last count and character
        if (count > 0) {
            comp.append(count).append(prevChar);
        }

        return comp.toString();
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
