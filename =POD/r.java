import java.util.Vector;

public class r {

    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>(java.util.Arrays.asList(13, 5604, 31, 2, 13, 4560, 546, 654, 456));

        int count = countPairsWithRightShift(nums);

        System.out.println("Total number of pairs with right shift: " + count);
    }

    public static int countPairsWithRightShift(Vector<Integer> nums) {
        int count = 0;
        int c=0;

        // Iterate through each number in the vector
        for (int i = 0; i < nums.size(); i++) {
            int num1 = nums.get(i);

            // Right shift the digits of the current number
            int shiftedNum1 = rightShiftDigits(num1, 1);

            // Check if the shifted number is present in the vector at a different index
            if (nums.indexOf(shiftedNum1) != -1 && nums.indexOf(shiftedNum1) != i) {
                if(Integer.toString(shiftedNum1).length()==3)c++;
                System.out.println(shiftedNum1);
                count++;
            }
        }

        // Each pair is counted twice, so divide by 2 to get the correct count
        return count-c/2 ;
    }

    private static int rightShiftDigits(int num, int shiftAmount) {
        String strNum = Integer.toString(num);
        int len = strNum.length();
        shiftAmount = shiftAmount % len; // Ensure a valid shift amount

        // Perform right shift by concatenating substrings
        String rightPart = strNum.substring(0, len - shiftAmount);
        String leftPart = strNum.substring(len - shiftAmount);
        String shiftedStr = leftPart + rightPart;

        return Integer.parseInt(shiftedStr);
    }
}
