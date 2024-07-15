//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
// This is the Modification of LArgest Histogram Area in STack 

import java.util.Stack;

public class _55MaximumRectangleArea {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 0 && matrix[i][j] == '1')
                    matrix[i][j] = (char) ('0' + (matrix[i][j] - '0') + (matrix[i - 1][j] - '0'));
            }
            max = Math.max(max, area(matrix[i]));
        }

        // System.out.println(Arrays.deepToString(matrix));

        System.out.println("max area is : " + max);
    }


    public static int area(char[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) left[i] = 0;
            else left[i] = st.peek() + 1;
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) right[i] = n - 1;
            else right[i] = st.peek() - 1;
            st.push(i);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        int max = 0;

        for (int i = 0; i < n; i++) {
            int leftmin = left[i];
            int rightmin = right[i];
            int area = (arr[i] - '0') * (rightmin - leftmin + 1);
            max = Math.max(max, area);
        }
        // System.out.println(max);
        return max;

    }
}