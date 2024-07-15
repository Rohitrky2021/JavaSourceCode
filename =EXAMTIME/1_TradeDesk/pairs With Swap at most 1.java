public class pair {

    public static int countDistinctPairs(int[] nums) {
        int distinctPairsCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (haveExactlyTwoDifferentDigits(nums[i], nums[j]) && haveEqualLength(nums[i], nums[j])) {
                    distinctPairsCount++;
                }
            }
        }

        return distinctPairsCount;
    }

    private static boolean haveExactlyTwoDifferentDigits(int num1, int num2) {
        int diffCount = 0;

        // Compare digits at each place
        while (num1 > 0 && num2 > 0 && diffCount <= 2) {
            if (num1 % 10 != num2 % 10) {
                diffCount++;
            }

            num1 /= 10;
            num2 /= 10;
        }

        // Exactly two different digits at the same place
        return diffCount == 2;
    }

    private static boolean haveEqualLength(int num1, int num2) {
        return Integer.toString(num1).length() == Integer.toString(num2).length();
    }

    public static void main(String[] args) {
        int[] nums = {1, 23, 156, 1650, 651, 165, 32};  //3
        int result = countDistinctPairs(nums);
        System.out.println("Number of distinct pairs: " + result);
    }
}
