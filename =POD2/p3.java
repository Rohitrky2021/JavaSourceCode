import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

class p3 {
    public int countStudents(int[] students, int[] sandwiches) {

        int n = students.length;

        int st0 = 0;
        int st1 = 0;
        int sa = 0;
        int sa1 = 0;

      for (int i : students) {
            if (i == 0) st0++;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (sandwiches[i] == 0) sa++;
        }

        st1 = n - st0;
        sa1 = n - sa;

        int c = 0;

        int i;
        for (i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && st0 > 0) st0--;
            else if (sandwiches[i] == 1 && st1 > 0) st1--;
            else break;
        }

        return n - i;
    }

    public static void main(String[] args) {
        p3 solution = new p3();
        
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println("Test Case 1: " + solution.countStudents(students1, sandwiches1)); // Output: 0

        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println("Test Case 2: " + solution.countStudents(students2, sandwiches2)); // Output: 3
    }
}
