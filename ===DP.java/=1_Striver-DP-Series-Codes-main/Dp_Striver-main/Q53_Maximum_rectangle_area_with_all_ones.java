// given a 2D array which contains 0's and 1's we have to find out maximum rectangle area with all ones
// previously we solved this for single dimension array for maximum rectangular histrogram 
// so we simply use that code and pass for every col
// create 1D array heights and add matrix[i][j] if this is 1 then increase heights[j] by 1
// else if it is 0 then make it 0 bcoz we cannot make rectangle for cuurent element
import java.util.*;
public class Q53_Maximum_rectangle_area_with_all_ones {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        
        for(int i = 0; i <= n; i++){
            while(st.size() > 0 && (i == n || heights[st.peek()] >= heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.size() == 0) width = i;
                else width = i - st.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        
        return maxArea;
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0 } };

        int n = matrix.length;
        int m = matrix[0].length;  
        int maxArea = 0;
        
        int[] heights = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1) heights[j]++;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        System.out.println(maxArea);     
    }
}
