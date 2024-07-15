package Recursion.Level1Questions;

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String args[]) {
        System.out.println(countSteps(3));
    }

    // calculate Number Of Steps To Reduce A Number To Zero
    // if a number is even -- divide it by 2
    // if a number is odd -- subtract by 1
    // calculate the steps taken

    static int countSteps(int n) {
        return helper(n, 0);
    }

    static int helper(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 2 == 0) {
            return helper(n / 2, count + 1);
        } else {
            return helper(n - 1, count + 1);
        }
    }
}
