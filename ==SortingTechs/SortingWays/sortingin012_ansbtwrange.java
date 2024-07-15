// public class  {
      
//Three way partition 
// can be easily converted to 01 As replacing 2 also to 1;

import java.util.List;

public class sortingin012_ansbtwrange {
    public void threeWayPartition(List<Integer> array, int a, int b) {
        int l = 0;
        int m = 0;
        int h = array.size() - 1;

        while (m <= h) {
            if (array.get(m) < a) {
                swap(array, m, l);
                l++;
                m++;
            } else if (array.get(m) >= a && array.get(m) <= b) {
                m++;
            } else if (array.get(m) > b) {
                swap(array, m, h);
                h--;
            }
        }
    }

    private void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}

    
    // } Driver Code Ends

