public class Searchin2DSortedArr {

    // Time Complexity (TC): O(log(m*n))----> And SC--O(1)

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
    
        final int m = matrix.length;
        final int n = matrix[0].length;
        int l = 0;
        int r = m * n;
    
        while (l < r) {
            final int mid = (l + r) / 2;
            final int i = mid / n;
            final int j = mid % n;
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] < target)
                l = mid + 1;
            else
                r = mid;
        }
    
        return false;
    }

    // brute force 
    public boolean searchMatrixi(int[][] m, int t) {
        int i=0,j=m[0].length-1;

        while(i<m.length && j>=0){
            if(m[i][j]==t){
                return true;
            }
            if(m[i][j]<t){
                i++;
            }
            else if(m[i][j]>t){
                j--;
            }
        }
        return false;

    }
    
}
